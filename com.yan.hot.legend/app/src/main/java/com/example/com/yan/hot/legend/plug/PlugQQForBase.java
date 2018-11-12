package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.example.com.yan.hot.legend.ClickService;
import com.example.com.yan.hot.legend.pic.SimilarPicture;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

import static com.example.com.yan.hot.legend.plug.PlugQQ.getBitmap;
import static com.example.com.yan.hot.legend.plug.PlugQQ.screencap;

/**
 * Created by on 2018/11/6.
 */
public abstract class PlugQQForBase {
    private String PLUG_NAME;
    private List<ClickTool.ClientType> CLIENT_TYPE_LIST = new ArrayList<>();
    private List<Coordinate> runCoordinates;
    private float runX;
    private float runY;
    private Rect rect;
    private String LOGIN_PATH;
    private List<Action> actions;

    protected abstract String getPath();

    protected abstract Rect getRect();

    protected abstract List<ClickTool.ClientType> getClientTypeList();

    protected abstract String getPlugName();

    protected abstract Coordinate getRunCoordinate();

    public PlugQQForBase(List<Action> actions) {
        this.actions = actions;
        PLUG_NAME = getPlugName();
        runCoordinates = new ArrayList<>(getCoordinate());
        LOGIN_PATH = getPath();
        CLIENT_TYPE_LIST = getClientTypeList();
        rect = getRect();
        Coordinate coordinate = getRunCoordinate();
        runX = coordinate.getX();
        runY = coordinate.getY();
    }

    private List<Coordinate> getCoordinate() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (Action action : actions) {
            Timber.e("action:" + action + ",PLUG_NAME:" + PLUG_NAME);
            if (action.getActionTime().getCount() > 0 && action.getName().contains(PLUG_NAME)) {
                coordinates = action.getCoordinates();
                break;
            }
        }
        return coordinates;
    }

    private boolean isRunPlug(ClickTool.ClientType clientType, Coordinate coordinate) {
        boolean result = false;
        if (CLIENT_TYPE_LIST.contains(clientType) && !runCoordinates.isEmpty()) {
            if (coordinate.getX() == runX && coordinate.getY() == runY) {
                result = true;
            }
        }
        return result;
    }

    public long runPlug(ClickService clickService, ClickTool.ClientType clientType, Coordinate coordinate) {
        long currentTime = 0;
        long sleep = 0;
        long allTime = 0;
        if (isRunPlug(clientType, coordinate)) {
            LogManager.newInstance().writeMessage("running click sleep，name:PlugQQForBase:" + clientType);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String path = screencap(clickService, clientType);
            if (path == null) {
                return 0;
            }

            float per = SimilarPicture.isEqualsPer(getBitmap(path, rect), getBitmap(LOGIN_PATH, rect));
            if (per > 85) {
                for (Coordinate tmp : runCoordinates) {
                    Timber.e("PlugQQForBase,tmp:" +tmp);
                    if (currentTime != 0) {
                        sleep = (int) (tmp.getTime() - currentTime);
                    }
                    currentTime = tmp.getTime();
                    if (sleep == 0) {
                        sleep = 5000;
                    }
                    allTime += sleep;
                    clickService.runClick(sleep, tmp);

                    PlugQQ.runClick(clickService, clientType, tmp);
                }
            }

        }
        return allTime;
    }
}
