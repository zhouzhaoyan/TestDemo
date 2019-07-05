package com.example.com.yan.hot.legend.plug;

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

        for (ClickTool.ClientType clientType: clientTypes) {
            reloginMap.put(clientType, new Relogin(HOT_RELOGIN
                    + clientType.name() + ".png", clientType + "relogin"));
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

        public Relogin(String reloginPath, String plugName) {
            this.reloginPath = reloginPath;
            this.plugName = plugName;
        }
    }

    public static void runClick(ClickService clickService, ClickTool.ClientType clientType) {
        if (!clientTypes.contains(clientType)) {
            return;
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String path = screencap(clickService, clientType);
        Relogin relogin = reloginMap.get(clientType);
        if (path == null) {
            LogManager.newInstance().writeMessage("running click sleep，name:PlugQQ no path");
            return;
        }

        float per = SimilarPicture.isEqualsPer(SimilarPicture.getBitmap(path), SimilarPicture.getBitmap(relogin.reloginPath));

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
