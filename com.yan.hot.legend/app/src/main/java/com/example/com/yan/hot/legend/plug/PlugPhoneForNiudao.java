package com.example.com.yan.hot.legend.plug;

import android.graphics.Rect;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/11/6.
 * 自动手机登录牛刀
 */
public class PlugPhoneForNiudao extends PlugQQForBase {

    public PlugPhoneForNiudao(ClickTool.ClientType clientType, List<Action> actions) {
        super(clientType, actions);
    }

    @Override
    public Rect getRect() {
        return new Rect(0, 0, 1028, 2244);
    }

    @Override
    public List<ClickTool.ClientType> getClientTypeList() {
        List<ClickTool.ClientType> clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.牛刀浏览器360);
        return clientTypes;
    }

    @Override
    public String getPlugName(ClickTool.ClientType clientType) {
        return "牛刀手机登录插件";
    }

    @Override
    public Coordinate getRunCoordinate(ClickTool.ClientType clientType) {
        return new Coordinate(355, 994);
    }
}
