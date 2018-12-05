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
 * 自动手机登录核弹头
 */
public class PlugPhoneForWarhead extends PlugQQForBase{

    public PlugPhoneForWarhead(List<Action> actions) {
        super(actions);
    }

    @Override
    public String getPath() {
        return ActionFile.HOT_ROOT + File.separator + "核弹头手机登录.png";
    }

    @Override
    public Rect getRect() {
        return new Rect(390,1900,480,1990);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.核弹头双开);
        return clientTypes;
    }

    @Override
    public String getPlugName() {
        return "核弹头手机登录插件";
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate(935, 2026);
    }
}
