package com.example.com.yan.hot.legend.screencap;

import android.util.Log;

import com.example.com.yan.hot.legend.MainActivity;
import com.yan.hot.legend.action.ActionFile;
import com.zsctc.remote.touch.bytes.FileUtils;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.io.File;

/**
 * Created by on 2018/10/8.
 */
public class ScreencapPathUtil {
    private static final String TAG = "ScreencapPathUtil";

    private static String getMode() {
        String mode = "task";
        if (MainActivity.daily && MainActivity.simple){
            mode = "simple";
        } else if (MainActivity.daily) {
            mode = "daily";
        } else if (MainActivity.simple) {
            mode = "simple";
        } else if (MainActivity.surplus) {
            mode = "surplus";
        }
        return mode;
    }

    private static String getParent() {
        String time = TimeUtil.getFormatTimeAll(System.currentTimeMillis());
        File file = new File(ActionFile.HOT_ROOT);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File tmp : files) {
                if (tmp.isDirectory() && !tmp.getName().equals(time)) {
                    FileUtils.deleteFile(tmp.getPath());
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
        Log.e(TAG, "getPath: clientType:" + clientType );
        String parent = getParent();
        String end = ".png";
        String path = "";
        File parentFile = new File(parent);
        String[] exists = null;
        if (parentFile.exists()){
            exists = parentFile.list();
        }
        Log.e(TAG, "getPath: exists:" + exists + ",length:" + exists.length);
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            path = parent + File.separator + i + "-" + clientType + end;
            if (exists != null && exists.length > 0){
                boolean exist = false;
                for (String tmp: exists) {
                    Log.e(TAG, "getPath: tmp:" + tmp );
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
}
