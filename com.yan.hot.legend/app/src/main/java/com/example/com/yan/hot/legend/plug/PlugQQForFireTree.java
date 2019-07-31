package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/11/6.
 * 自动qq登录火树
 */
public class PlugQQForFireTree extends PlugQQForBase {

    public PlugQQForFireTree(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public Rect getRect() {
        return new Rect(450, 1180, 590, 1310);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.火树网页双开);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        String name = "火树qq插件";
        return name;
    }

    @Override
    public Coordinate getRunCoordinate(ClickTool.ClientType clientType) {
        return new Coordinate(578, 1812);
    }
}
