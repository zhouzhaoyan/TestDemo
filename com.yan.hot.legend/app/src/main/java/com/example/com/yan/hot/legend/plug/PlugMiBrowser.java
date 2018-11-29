package com.example.com.yan.hot.legend.plug;

import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/11/29
 * 小米浏览器纠错
 */
public class PlugMiBrowser {
    private static final int x1 = 1000;
    private static final int y1 = 2000;
    private static final int x2 = 50;
    private static final int y2 = 2000;
    private static List<ClickTool.ClientType> runClientTypes = new ArrayList<>();

    static {
        runClientTypes.add(ClickTool.ClientType.火树);
        runClientTypes.add(ClickTool.ClientType.游戏07073网页);
        runClientTypes.add(ClickTool.ClientType.乐趣网页);
        runClientTypes.add(ClickTool.ClientType.核弹头网页);
        runClientTypes.add(ClickTool.ClientType.游戏1758网页);
        runClientTypes.add(ClickTool.ClientType.牛刀网页);
        runClientTypes.add(ClickTool.ClientType.玩蛋);
    }

    public static void run(ClickTool clickTool, ClickTool.ClientType clientType) {
        if (runClientTypes.contains(clientType)) {
            LogManager.newInstance().writeMessage("running click sleep，name:PlugMiBrowser");
            clickTool.swipe(x1, y1, x2, y2);
        }
    }
}
