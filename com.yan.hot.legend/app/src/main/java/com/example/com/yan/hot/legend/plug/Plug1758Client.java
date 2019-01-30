package com.example.com.yan.hot.legend.plug;

import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/11/29
 * 1758纠错
 */
public class Plug1758Client {
    private static final int x1 = 1000;
    private static final int y1 = 450;
    private static final int x2 = 1000;
    private static final int y2 = 2000;

    private static final int runX = 974;
    private static final int runY = 1476;
    private static List<ClickTool.ClientType> runClientTypes = new ArrayList<>();

    static {
        runClientTypes.add(ClickTool.ClientType.游戏1758);
    }

    public static void run(ClickTool clickTool, ClickTool.ClientType clientType, Coordinate coordinate) {
        if (runClientTypes.contains(clientType)
                && coordinate.getX() == runX
                && coordinate.getY() == runY) {
            LogManager.newInstance().writeMessage("running click sleep，name:Plug1758Client");
            for (int i = 0; i < 2; i++) {
                clickTool.swipe(x1, y1, x2, y2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
