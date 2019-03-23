package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.example.com.yan.hot.legend.ClickService;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/12/11.
 */
public class PlugMiBrowserRefresh extends PlugQQForBase {
    public PlugMiBrowserRefresh(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public Rect getRect() {
        return null;
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.火树);
        clientTypes.add(ClickTool.ClientType.乐趣网页);
        clientTypes.add(ClickTool.ClientType.玩蛋);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        switch (clientType) {
            case 火树:
            case 乐趣网页:
            case 玩蛋:
                return "小米浏览器刷新插件";
        }
        return "";
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate(587, 1811);
    }


    @Override
    protected long innerRun(ClickService clickService, ClickTool.ClientType clientType) {
        PlugMiBrowser.run(clickService.clickTool, clientType);
        long currentTime = 0;
        long sleep = 0;
        long allTime = 0;
        LogManager.newInstance().writeMessage("running click sleep，name:PlugQQForBase:" + getClass().getName() + ":" + clientType);

        for (Coordinate tmp : runCoordinates) {
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
        return allTime;
    }
}
