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
 */
public class Plug07073 {
    private static final String PLUG_NAME = "07073插件";
    private static final List<ClickTool.ClientType> CLIENT_TYPE_LIST = new ArrayList<>();
    private List<Coordinate> runCoordinates;
    private static final float runX = 587;
    private static final float runY = 1811;
    private static List<Action> actions;

    static {
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.游戏07073网页);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.游戏07073);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.热血单机h5);
        CLIENT_TYPE_LIST.add(ClickTool.ClientType.热血单机h5双开);
    }

    public static void init(List<Action> actions){
        Plug07073.actions = actions;
    }

    public Plug07073() {
        runCoordinates = new ArrayList<>(getCoordinate());
    }

    private List<Coordinate> getCoordinate(){
        List<Coordinate> coordinates = new ArrayList<>();
        Action newAction = null;
        for (Action action: actions) {
            if (action.getActionTime().getCount() > 0 && action.getName().contains(PLUG_NAME)){
                if (newAction == null){
                    newAction = action;
                } else {
                    if (action.getCoordinates().get(0).getTime() > newAction.getCoordinates().get(0).getTime()){
                        newAction = action;
                    }
                }
                action.getCoordinates();
            }
        }
        if (newAction != null){
            coordinates = newAction.getCoordinates();
        }
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

    public void runPlug(ClickService clickService, ClickTool.ClientType clientType, Coordinate coordinate){
        long currentTime = 0;
        long sleep = 0;
        if (isRunPlug(clientType, coordinate)){
            LogManager.newInstance().writeMessage("running click sleep，name: runPlug:" + clientType);

            for (Coordinate tmp: runCoordinates){
                if (currentTime != 0) {
                    sleep = (int) (tmp.getTime() - currentTime);
                }
                currentTime = tmp.getTime();
                if (sleep == 0){
                    sleep = 10000;
                }
                clickService.runClick(sleep, tmp);
            }
        }
    }
}
