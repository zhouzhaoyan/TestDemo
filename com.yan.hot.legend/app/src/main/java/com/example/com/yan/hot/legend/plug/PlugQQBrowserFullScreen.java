package com.example.com.yan.hot.legend.plug;

import com.example.com.yan.hot.legend.ClickService;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/10/11.
 * qq浏览器全屏
 */
public class PlugQQBrowserFullScreen {
    private static final List<ClickTool.ClientType> CLIENT_TYPE_LIST = new ArrayList<>();
    private List<Coordinate> runCoordinates;
    private static final float runX = 587;
    private static final float runY = 1811;
    private static List<Action> actions;

    static {
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.火树360浏览器);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.趣头条360浏览器);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.玩蛋360浏览器);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.游戏1758浏览器360);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.乐趣360浏览器);
        //因为有广告所以去掉全屏的功能
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.游戏07073浏览器360);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.牛刀浏览器360);
    }

    public static void init(List<Action> actions){
        PlugQQBrowserFullScreen.actions = actions;
    }

    public PlugQQBrowserFullScreen() {
        runCoordinates = new ArrayList<>(getCoordinate());
    }

    private List<Coordinate> getCoordinate(){
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate coordinate = new Coordinate(979, 2063);
        long time = System.currentTimeMillis();
        coordinate.setTime(time);
        coordinates.add(coordinate);

        coordinate = new Coordinate(920, 1405);
        coordinate.setTime(time+2000);
        coordinates.add(coordinate);

        return coordinates;
    }

    private boolean isRunPlug(ClickTool.ClientType clientType, Coordinate coordinate){
        boolean result = false;

        if (CLIENT_TYPE_LIST.contains(clientType) && !runCoordinates.isEmpty()){
            if (coordinate.getX() == runX && coordinate.getY() == runY){
                result = true;
            }
        }
        return result;
    }

    public long runPlug(ClickService clickService, ClickTool.ClientType clientType, Coordinate coordinate){
//        LogManager.newInstance().writeMessage("running click sleep，name: runPlug:" + clientType + "," + getClass());

        long currentTime = 0;
        long sleep = 0;
        long allTime = 0;
        if (isRunPlug(clientType, coordinate)){
            LogManager.newInstance().writeMessage("running click sleep，name: runPlug running:" + clientType);

            for (Coordinate tmp: runCoordinates){
                if (currentTime != 0) {
                    sleep = (int) (tmp.getTime() - currentTime);
                }
                currentTime = tmp.getTime();
                if (sleep == 0){
                    sleep = 10000;
                }
                allTime += sleep;
                clickService.runClick(sleep, tmp);
            }
        }
        return allTime;
    }
}
