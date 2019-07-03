package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/11/6.
 * 自动qq登录玩蛋
 */
public class PlugQQForPlayEggs extends PlugQQForBase {

    public PlugQQForPlayEggs(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public Rect getRect() {
        return new Rect(480, 1020, 630, 1170);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.玩蛋qq浏览器);
        clientTypes.add(ClickTool.ClientType.玩蛋qq浏览器双开);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        String name = "玩蛋qq插件";
        switch (clientType){
            case 玩蛋qq浏览器:
                name = "玩蛋qq插件";
                break;
            case 玩蛋qq浏览器双开:
                name = "玩蛋qq双开插件";
                break;
        }
        return name;
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate(587, 1811);
    }
}
