package com.example.com.yan.hot.legend.devote;


import android.annotation.SuppressLint;

import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by on 2018/9/29.
 */
public class DevoteManager {
    @SuppressLint("CheckResult")
    public static void init() {
        Observable.just(1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                List<DevoteObject> list = DevoteFile.read();
                if (list != null) {
                    long currentTime = getCurrentTime();
                    for (DevoteObject devoteObject : list) {
                        if (devoteObject.getDate() < currentTime) {
                            devoteObject.setDate(currentTime);
                            devoteObject.setValue(devoteObject.getValue() + devoteObject.getOffset());
                        }
                    }
                    DevoteFile.write(list);
                }
            }
        });
    }

    public static List<DevoteObject> getDefault() {
        List<DevoteObject> devoteObjects = new ArrayList<>();
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        for (ClickTool.ClientType clientType : clientTypes) {
            devoteObjects.add(new DevoteObject(clientType.name(), getCurrentTime(), 0, 540));
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
