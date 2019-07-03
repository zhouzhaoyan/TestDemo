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
 * Created by on 2018/12/11.
 */
public class PlugQQBrowserRefresh extends PlugQQForBase{
    public PlugQQBrowserRefresh(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public String getPath(ClickTool.ClientType clientType) {
        return ActionFile.HOT_ROOT + File.separator + "qqBrowserRefresh.png";
    }

    @Override
    public Rect getRect() {
        return new Rect(960,230,1010,260);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.牛刀qq浏览器);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        switch (clientType){
            case 牛刀qq浏览器:
                return "牛刀qq浏览器刷新插件";
        }
        return "";
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate( 538, 1346);
    }

}
