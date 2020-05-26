package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.example.com.yan.hot.legend.ClickService;
import com.example.com.yan.hot.legend.pic.SimilarPicture;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.com.yan.hot.legend.plug.PlugQQ.getBitmap;
import static com.example.com.yan.hot.legend.plug.PlugQQ.screencap;
import static com.yan.hot.legend.action.ActionFile.HOT_RELOGIN;

/**
 * Created by on 2018/10/26.
 * 重新登录
 */
public class PlugRelogin {

    private static List<ClickTool.ClientType> clientTypes = new ArrayList<>();
    private static Map<ClickTool.ClientType, Relogin> reloginMap = new HashMap();

    static {
//        clientTypes.add(ClickTool.ClientType.牛刀);
        clientTypes.add(ClickTool.ClientType.热血单机双开);
        clientTypes.add(ClickTool.ClientType.牛刀qq浏览器);
        Coordinate coordinate = null;
        Rect rect = null;
        for (ClickTool.ClientType clientType: clientTypes) {
            switch (clientType){
                case 牛刀:
                    coordinate = new Coordinate(535,1600);
                    rect = new Rect(0,1000,1080,1070);
                    break;
                default:
                    coordinate = new Coordinate(279, 613);
                    break;
            }
            reloginMap.put(clientType, new Relogin(HOT_RELOGIN
                    + clientType.name() + ".png", clientType + "relogin",
                    coordinate,rect));
        }
    }

    private static List<Action> actions;

    public static void init(List<Action> actions) {
        PlugRelogin.actions = actions;
    }

    static class Relogin {
        //重新登录的图路径
        public String reloginPath;
        //插件名
        public String plugName;
        //run坐标
        public Coordinate coordinate;
        //对比区域
        public Rect rect;

        public Relogin(String reloginPath, String plugName, Coordinate coordinate, Rect rect) {
            this.reloginPath = reloginPath;
            this.plugName = plugName;
            this.coordinate = coordinate;
            this.rect = rect;
        }
    }

    public static void runClick(ClickService clickService, ClickTool.ClientType clientType, Coordinate coordinate) {
        if (!clientTypes.contains(clientType)) {
            return;
        }

        Relogin relogin = reloginMap.get(clientType);
        if (relogin.coordinate.getX() != coordinate.getX() || relogin.coordinate.getY() != coordinate.getY()){
            return;
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String path = screencap(clickService, clientType);
        if (path == null) {
            LogManager.newInstance().writeMessage("running click sleep，name:PlugQQ no path");
            return;
        }

        float per;

        if (relogin.rect == null){
            per = SimilarPicture.isEqualsPer(SimilarPicture.getBitmap(path), SimilarPicture.getBitmap(relogin.reloginPath));
        } else {
            per = SimilarPicture.isEqualsPer(getBitmap(path,relogin.rect), getBitmap(relogin.reloginPath,relogin.rect));
        }
        LogManager.newInstance().writeMessage("running click sleep，name:PlugRelogin:"
                + clientType + ",per:" + per);
        if (per > 90) {
            List<Coordinate> coordinates = new ArrayList<>();
            for (Action action : actions) {
                if (action.getActionTime().getCount() > 0 && !relogin.plugName.equals("") && action.getName().contains(relogin.plugName)) {
                    coordinates = action.getCoordinates();
                    break;
                }
            }

            long currentTime = 0;
            long sleep = 0;
            for (Coordinate tmp : coordinates) {
                if (currentTime != 0) {
                    sleep = (int) (tmp.getTime() - currentTime);
                }
                currentTime = tmp.getTime();
                if (sleep == 0) {
                    sleep = 1000;
                }
                clickService.runClick(sleep, tmp);

                PlugQQ.runClick(clickService, clientType, tmp);
            }
        }
    }
}
