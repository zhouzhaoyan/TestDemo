package com.example.com.yan.hot.legend.plug;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.com.yan.hot.legend.ClickService;
import com.example.com.yan.hot.legend.pic.SimilarPicture;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.FileUtils;
import com.zsctc.remote.touch.bytes.LogManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/10/26.
 */
public class PlugDesktop {

    @SuppressLint("CheckResult")
    public static void init(List<Action> actions) {
    }

    public static void runClick(ClickService clickService){
        clickService.runClick(1000, new Coordinate(502, 2188));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickService.clickTool.swipe(1000, 1700, 50, 1700);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
