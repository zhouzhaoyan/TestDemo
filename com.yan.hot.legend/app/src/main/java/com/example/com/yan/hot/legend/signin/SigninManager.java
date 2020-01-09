package com.example.com.yan.hot.legend.signin;

import android.annotation.SuppressLint;

import com.example.com.yan.hot.legend.devote.DevoteObject;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class SigninManager {

    @SuppressLint("CheckResult")
    public static void init() {
    }

    public static List<SigninObject> getSignin() {
        List<SigninObject> defaults = getDefault();
        List<SigninObject> signinObjectsNew = SigninFile.read();

        if (signinObjectsNew == null) {
            signinObjectsNew = new ArrayList<>();
        }

        for (SigninObject signinObject : defaults) {
            if (!signinObjectsNew.contains(signinObject)) {
                signinObjectsNew.add(signinObject);
            }
        }
        return signinObjectsNew;
    }

    public static List<SigninObject> getDefault() {
        List<SigninObject> signinObjects = new ArrayList<>();
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        for (ClickTool.ClientType clientType : clientTypes) {
            signinObjects.add(new SigninObject(clientType, clientType.name(), getCurrentTime(), 0));
        }
        return signinObjects;
    }

    public static void updateTime(SigninObject signinObject) {
        signinObject.setDate(getCurrentTime());
    }

    private static long getCurrentTime() {
        return TimeUtil.getFirstSecondInDay(System.currentTimeMillis());
    }
}
