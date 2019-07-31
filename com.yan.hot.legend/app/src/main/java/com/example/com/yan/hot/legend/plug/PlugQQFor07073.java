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
public class PlugQQFor07073 extends PlugQQForBase {

    public PlugQQFor07073(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public Rect getRect() {
        return new Rect(220, 1240, 360, 1380);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.游戏07073网页);
        clientTypes.add(ClickTool.ClientType.热血单机h5);
        clientTypes.add(ClickTool.ClientType.热血单机h5双开);
        clientTypes.add(ClickTool.ClientType.游戏07073);
        clientTypes.add(ClickTool.ClientType.凹凸果);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        switch (clientType){
            case 游戏07073:
                return "07073qq插件double";
        }
        return "07073qq插件";
    }

    @Override
    public Coordinate getRunCoordinate(ClickTool.ClientType clientType) {
        return new Coordinate(587, 1811);
    }
}
