package com.example.com.yan.hot.legend.screencap;

import android.util.Log;

import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.yan.hot.legend.action.ActionFile;
import com.zsctc.remote.touch.bytes.FileUtils;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by on 2018/10/8.
 */
public class ScreencapPathUtil {
    private static final String TAG = "ScreencapPathUtil";

    private static String getMode() {
        ActionRun actionRun = ActionRunFile.read();
        String mode = "task";
        switch (actionRun.getModeType()){
            case DAILY:
                mode = "daily";
                break;
            case DAILY_TASK:
                mode = "dailyTask";
                break;
            case SIMPLE:
                mode = "simple";
                break;
        }
        return mode;
    }

    private static String getParent() {
        String time = TimeUtil.getFormatTimeAll(System.currentTimeMillis());
        File file = new File(ActionFile.HOT_ROOT);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File tmp : files) {
                if (tmp.isDirectory() && !tmp.getName().equals(time) && tmp.getName().length() == 10) {
                    FileUtils.delete(tmp.getPath());
                }
            }
        }
        String parent = ActionFile.HOT_ROOT + File.separator + time
                + File.separator + getMode();
        file = new File(parent);
        file.mkdirs();
        return parent;
    }

    public static String getPath(String clientType) {
        return getPath(getParent(), clientType);
    }

    public static String getPath(String dir, String clientType) {
        String parent = dir;
        String end = ".png";
        String path = "";
        File parentFile = new File(parent);
        String[] exists = null;
        if (parentFile.exists()){
            exists = parentFile.list();
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            path = parent + File.separator + i + "-" + clientType + end;
            if (exists != null && exists.length > 0){
                boolean exist = false;
                for (String tmp: exists) {
                    if (tmp.startsWith(i + "-")){
                        exist = true;
                        break;
                    }
                }
                if (!exist){
                    break;
                }
            } else {
                break;
            }
        }
        Log.e(TAG, "getPath: " + path );
        return path;
    }

    public static String getExistPath(String clientType) {
        String parent = getParent();
        String path = "";
        File parentFile = new File(parent);
        String[] exists = null;
        if (parentFile.exists()){
            exists = parentFile.list();
        }
        Arrays.sort(exists);
        Log.e(TAG, "getPath,clientType: " + clientType + ",parent:" + parent );
        for (String name: exists) {
            Log.e(TAG, "getPath,name: " + name );
            if (name.contains(clientType+".png")){
                path = parent + File.separator + name;
            }
        }
        Log.e(TAG, "getPath: " + path );
        return path;
    }
}
