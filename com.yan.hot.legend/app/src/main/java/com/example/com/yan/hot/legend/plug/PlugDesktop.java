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
    private static final String DEFAULT_DESKTOP_PATH = ActionFile.HOT_ROOT + File.separator + "desktop.png";
    private static final String PLUG_NAME = "桌面纠错插件";

    private static final String dir = ActionFile.HOT_ROOT + File.separator + "desktop";
    private static boolean isDebug = true;
    private static List<Action> actions;

    private static Rect rect = new Rect(590,1950,750,2110);

    @SuppressLint("CheckResult")
    public static void init(List<Action> actions) {
        if (!isDebug){
            return;
        }
        FileUtils.deleteDirectory(dir);
        PlugDesktop.actions = actions;
    }

    private static Bitmap getBitmap(String path, Rect rect) {
        Bitmap bitmap = SimilarPicture.getBitmap(path);
        return SimilarPicture.getBitmap(bitmap,
                rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
    }

    @SuppressLint("CheckResult")
    public static void runClick(final ClickService clickService, final ClickTool.ClientType clientType) {
        if (!isDebug){
            return;
        }

//        FileUtils.deleteDirectory(dir);
        new File(dir).mkdirs();
        String path = ScreencapPathUtil.getPath(dir, clientType.name());
        clickService.clickTool.screencap(path);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = new File(path);
        for (int i = 0; !((file.exists() && file.length() > 0) || i > 3); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!(file.exists() && file.length() > 0)) {
            return;
        }

        Bitmap defaultBitmap = getBitmap(DEFAULT_DESKTOP_PATH, rect);
        Bitmap currentBitmap = getBitmap(path,rect);
        float per = SimilarPicture.isEqualsPer(defaultBitmap, currentBitmap);
        LogManager.newInstance().writeMessage("running click sleep，name: PlugDesktop "
                + clientType + ",per:" + per);
        if (per < 90){
            LogManager.newInstance().writeMessage("running click sleep，name: PlugDesktop " + clientType );
            long currentTime = 0;
            long sleep = 0;
            //运行纠错插件
            List<Coordinate> runCoordinates = getCoordinate();
            for (Coordinate tmp: runCoordinates){
                if (currentTime != 0) {
                    sleep = (int) (tmp.getTime() - currentTime);
                }
                currentTime = tmp.getTime();
                if (sleep == 0){
                    sleep = 3000;
                }
                clickService.runClick(sleep, tmp);
            }
        }
    }

    private static List<Coordinate> getCoordinate(){
        List<Coordinate> coordinates = new ArrayList<>();
        for (Action action: actions) {
            if (action.getActionTime().getCount() > 0 && action.getName().contains(PLUG_NAME)){
                coordinates = action.getCoordinates();
                break;
            }
        }
        return coordinates;
    }
}
