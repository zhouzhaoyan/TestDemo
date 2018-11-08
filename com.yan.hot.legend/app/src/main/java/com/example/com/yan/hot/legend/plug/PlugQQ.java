package com.example.com.yan.hot.legend.plug;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

import com.example.com.yan.hot.legend.ClickService;
import com.example.com.yan.hot.legend.pic.SimilarPicture;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import static android.content.ContentValues.TAG;

/**
 * Created by on 2018/10/22.
 * QQ插件
 */
public class PlugQQ {
    private static List<Action> actions;
    private static final String DEFAULT_QQ_PATH = ActionFile.HOT_ROOT + File.separator + "qqLogin.png";
    private static final Map<String, Rect> defaultRect = new HashMap<>();
    private static final float runX = 942;
    private static final float runY = 1161;

    static {
        defaultRect.put("1594225121", new Rect(80, 1500, 320, 1560));
        defaultRect.put("2594365547", new Rect(80, 1670, 320, 1730));
        defaultRect.put("1874419402", new Rect(80, 1840, 320, 1900));
    }

    private static final Map<ClickTool.ClientType, String> accountMap = new HashMap<>();

    static {
        accountMap.put(ClickTool.ClientType.热血单机双开, "2594365547");
        accountMap.put(ClickTool.ClientType.牛刀网页双开, "2594365547");
    }

    private static Map<String, Bitmap> qqBitmap;

    private static final String dir = ActionFile.HOT_ROOT + File.separator + "qq";
    private static boolean isDebug = true;

    @SuppressLint("CheckResult")
    public static void init(List<Action> actions) {
        if (!isDebug){
            return;
        }
        PlugQQ.actions = actions;
        Observable.just(1)
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        qqBitmap = new HashMap<>();
                        Iterator<Map.Entry<String, Rect>> iterator = defaultRect.entrySet().iterator();
                        Map.Entry<String, Rect> next;
                        while (iterator.hasNext()) {
                            next = iterator.next();
                            qqBitmap.put(next.getKey(), getBitmap(DEFAULT_QQ_PATH, next.getValue()));
                        }

                    }
                });
    }

    public static Bitmap getBitmap(String path, Rect rect) {
        Bitmap bitmap = SimilarPicture.getBitmap(path);
        Log.e(TAG, "getBitmap: " + bitmap.getWidth() + "," + bitmap.getHeight()
                + ",rect:" + rect);
        return SimilarPicture.getBitmap(bitmap,
                rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
    }

    //自动选择用户登录
    @SuppressLint("CheckResult")
    public static void runClick(final ClickService clickService, final ClickTool.ClientType clientType, final Coordinate coordinate) {
        if (!isDebug){
            return;
        }

        if (!accountMap.keySet().contains(clientType)) {
            return;
        }

        if (!(coordinate.getX() == runX && coordinate.getY() == runY)) {
            return;
        }

        String path = screencap(clickService, clientType);
        if (path == null){
            LogManager.newInstance().writeMessage("running click sleep，name:PlugQQ no path");
            return;
        }

        Iterator<Map.Entry<String, Rect>> iterator = defaultRect.entrySet().iterator();
        Bitmap bitmap = qqBitmap.get(accountMap.get(clientType));
        Rect rect;
        while (iterator.hasNext()) {
            Map.Entry<String, Rect> next = iterator.next();
            rect = next.getValue();
            float per = SimilarPicture.isEqualsPer(getBitmap(path, rect), bitmap);
            LogManager.newInstance().writeMessage("running click sleep，name:PlugQQ:" + clientType + ",per:" + per);
            if (per > 80) {
                Coordinate coordinate1 = new Coordinate((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2);
                Log.e(TAG, "PlugQQ runClick: " + coordinate1.getX() + "," + coordinate1.getY() + ",position:" + next.getKey());
                clickService.runClick(5000,
                        coordinate1);
                break;
            }
        }
    }

    //自动加载登录脚本
    public static void autoLogin(final ClickService clickService, final ClickTool.ClientType clientType, final Coordinate coordinate){
        PlugQQForBase[] plugQQForBases = new PlugQQForBase[]{new PlugQQFor07073(actions)};
        for (PlugQQForBase bases: plugQQForBases) {
            bases.runPlug(clickService, clientType, coordinate);
        }
    }

    @SuppressLint("CheckResult")
    static String screencap(final ClickService clickService, ClickTool.ClientType clientType){
        new File(dir).mkdirs();
        final String path = ScreencapPathUtil.getPath(dir, clientType.name());
        long MAX_SIZE = 400*1024;

        clickService.clickTool.screencap(path);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = new File(path);
        for (int i = 0; !((file.exists() && file.length() > MAX_SIZE) || i > 3); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Timber.e("screencap, length():" + file.length());
        if (!(file.exists() && file.length() > MAX_SIZE)) {
            return null;
        }

        return path;
    }
}
