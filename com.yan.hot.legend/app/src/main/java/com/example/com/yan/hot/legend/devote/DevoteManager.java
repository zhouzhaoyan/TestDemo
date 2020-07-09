package com.example.com.yan.hot.legend.devote;


import android.annotation.SuppressLint;

import com.example.com.yan.hot.legend.runstate.ActionRun;
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
public class DevoteManager {
    private final static int MAX_VALUE = 20000;

    public static boolean isMax(ClickTool.ClientType clientType) {
        boolean result = false;
//        List<DevoteObject> list = DevoteFile.read();
//        for (DevoteObject devoteObject : list) {
//            if (devoteObject.getClientType() == clientType && devoteObject.getValue() >= MAX_VALUE){
//                result = true;
//                break;
//            }
//        }
        return result;
    }

    @SuppressLint("CheckResult")
    public static void init() {
        Observable.just(1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                List<DevoteObject> list = getDevoteNew(DevoteFile.read());
                if (list != null) {
                    long currentTime = getCurrentTime();
                    for (DevoteObject devoteObject : list) {
                        if (devoteObject.getDate() < currentTime && devoteObject.getValue() < MAX_VALUE
                                && !ActionRun.noRun.contains(devoteObject.getClientType())) {
                            devoteObject.setDate(currentTime);
                            devoteObject.setValue(Math.min(devoteObject.getValue() + devoteObject.getOffset(), MAX_VALUE));
                        }
                    }
                    DevoteFile.write(list);
                }
            }
        });
    }

    public static List<DevoteObject> getDevoteNew(List<DevoteObject> devoteObjectsOld) {
        List<DevoteObject> defaults = getDefault();
        if (devoteObjectsOld == null || devoteObjectsOld.isEmpty()) {
            return defaults;
        }
        List<DevoteObject> devoteObjectsNews = new ArrayList<>(devoteObjectsOld);
        for (DevoteObject devoteObject : defaults) {
            if (!devoteObjectsOld.contains(devoteObject)) {
                devoteObjectsNews.add(devoteObject);
            }
        }

        for (DevoteObject devoteObject : defaults) {
            for (DevoteObject devoteObjectNew : devoteObjectsNews) {
                if (devoteObjectNew.equals(devoteObject)) {
                    devoteObjectNew.setClientType(devoteObject.getClientType());
                    break;
                }
            }
        }
        return devoteObjectsNews;
    }

    public static List<DevoteObject> getDefault() {
        List<DevoteObject> devoteObjects = new ArrayList<>();
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        for (ClickTool.ClientType clientType : clientTypes) {
            devoteObjects.add(new DevoteObject(clientType.name(), getCurrentTime(), 0, 0, clientType));
        }
        return devoteObjects;
    }

    public static void updateTime(DevoteObject devoteObject) {
        devoteObject.setDate(getCurrentTime());
    }

    private static long getCurrentTime() {
        return TimeUtil.getFirstSecondInDay(System.currentTimeMillis());
    }
}
