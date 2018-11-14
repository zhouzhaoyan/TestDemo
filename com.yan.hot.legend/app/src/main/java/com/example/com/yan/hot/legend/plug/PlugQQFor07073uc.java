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
 * 自动登录07073
 */
public class PlugQQFor07073uc extends PlugQQFor07073{

    public PlugQQFor07073uc(List<Action> actions) {
        super(actions);
    }

    @Override
    public String getPath() {
        return ActionFile.HOT_ROOT + File.separator + "07073登录UC.png";
    }

    @Override
    public Rect getRect() {
        return new Rect(220,1240,360,1380);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.游戏07073);
        return clientTypes;
    }

    @Override
    public String getPlugName() {
        return "07073qq插件";
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate( 587,1811);
    }
}
