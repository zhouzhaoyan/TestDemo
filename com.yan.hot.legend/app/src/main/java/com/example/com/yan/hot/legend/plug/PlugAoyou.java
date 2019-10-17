package com.example.com.yan.hot.legend.plug;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.com.yan.hot.legend.ClickService;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/10/26.
 * 上滑
 */
public class PlugAoyou {
    private List<ClickTool.ClientType> clientTypes;
    private Coordinate coordinate = new Coordinate(578, 1812);

    {
        clientTypes = new ArrayList<>();
        clientTypes.add(ClickTool.ClientType.火树遨游);
    }

    public void runClick(ClickService clickService, ClickTool.ClientType clientType, Coordinate newCoordinate) {
        if (!clientTypes.contains(clientType)){
            return;
        }

        if (newCoordinate.getX() != coordinate.getX() || newCoordinate.getY() != coordinate.getY()){
            return;
        }

        Log.e("test", "runClick: PlugAoyou");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickService.clickTool.swipe(50, 1500, 50, 200);
    }
}
