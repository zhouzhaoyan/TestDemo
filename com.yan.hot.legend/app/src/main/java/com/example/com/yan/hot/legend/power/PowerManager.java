package com.example.com.yan.hot.legend.power;


import android.annotation.SuppressLint;

import com.example.com.yan.hot.legend.devote.DevoteFile;
import com.example.com.yan.hot.legend.devote.DevoteObject;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by on 2018/9/29.
 */
public class PowerManager {

    public static void init() {
    }

    public static List<PowerObject> getDefault() {
        List<PowerObject> powerObjects = new ArrayList<>();
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        for (ClickTool.ClientType clientType : clientTypes) {
            powerObjects.add(new PowerObject(clientType.name(), 0, 0, 0, clientType));
        }
        return powerObjects;
    }

    public static void updateTime(PowerObject powerObject) {
        powerObject.setDate(getCurrentTime());
    }

    private static long getCurrentTime() {
        return TimeUtil.getFirstSecondInDay(System.currentTimeMillis());
    }
}
