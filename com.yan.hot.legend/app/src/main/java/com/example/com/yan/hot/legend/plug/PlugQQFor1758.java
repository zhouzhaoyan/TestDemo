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
 * 自动qq登录1758
 */
public class PlugQQFor1758 extends PlugQQForBase {

    public PlugQQFor1758(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public String getPath() {
        return ActionFile.HOT_ROOT + File.separator + "1758登录.png";
    }

    @Override
    public Rect getRect() {
        return new Rect(190, 1010, 370, 1200);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.游戏1758qq浏览器);
        clientTypes.add(ClickTool.ClientType.游戏1758);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        String name = "1758qq插件";
        switch (clientType){
            case 游戏1758qq浏览器:
                name = "1758qq插件";
                break;
            case 游戏1758:
                name = "1758qq双开插件";
                break;
        }
        return name;
    }

    @Override
    public Coordinate getRunCoordinate() {
        return new Coordinate(587, 1811);
    }
}
