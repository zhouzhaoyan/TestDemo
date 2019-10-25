package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.yan.hot.legend.plug.Plug07073;
import com.example.com.yan.hot.legend.plug.PlugDesktop;
import com.example.com.yan.hot.legend.plug.PlugQQ;
import com.example.com.yan.hot.legend.plug.PlugRelogin;
import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class AliveService extends NotificationListenerService {
    private ScreenView screenView;
    private Map<Action, List<Long>> clickTimesMap = new ArrayMap<Action, List<Long>>();
    private List<Action> actions;
    private ActionRun actionRun;
    private final String FLAG = ",";

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        screenView = new ScreenView(this, false);
        alarmEveryDay();
        actionRun = ActionRunFile.read();
    }

    public static void openAliveService(Context context) {
        Intent intent = new Intent(context, AliveService.class);
        context.startService(intent);
    }

    public static void stopService(Context context) {
        Intent intent = new Intent(context, AliveService.class);
        context.stopService(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (screenView != null) {
            screenView.hideScreenshot();
        }
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    TextView textView;
    Set<Action> filerActions = new HashSet<Action>();

    @SuppressLint({"WrongConstant", "HandlerLeak"})
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        View view = screenView.getView();

        String content = "正在运行";
        if (content != null && !content.equals("")) {
            if (view != null) {
                if (view instanceof LinearLayout) {
                    ((TextView) ((LinearLayout) view).getChildAt(0)).setText(content);
                }
            } else {
                textView = new TextView(this);
                textView.setText(content);
                textView.setTextSize(13);
                textView.setTextColor(Color.RED);
                textView.setPadding(10, 0, 10, 0);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, 50));

                screenView.showScreenshot(linearLayout);
            }
        }
        if (handler != null) {
            handler.removeMessages(0);
        }
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                int time = msg.arg1;
                Log.e("test", "running click:" + (Action) msg.obj + ",time:" + time);
                startService(ClickService.getClickService(getApplicationContext(), (Action) msg.obj, time));
                updateUi();
            }

            ;
        };

        actions = ActionFile.read();
        PlugQQ.init(actions);
        Plug07073.init(actions);
        PlugDesktop.init(actions);
        PlugRelogin.init(actions);

        if (actions != null) {
            ClickTool.initClient(actions);
            //			for (Action action : actions) {
            //				if (!action.getName().contains("野外boss") && !action.getName().equals("神域boss")){
            //					filerActions.add(action);
            //				}
            //			}
            for (Action action : actions) {
                //				if (action.getName().contains("转生")){
                alarm(action);
                //				}
            }
        }
        updateUi();
        return super.onStartCommand(intent, Service.START_REDELIVER_INTENT, startId);
    }

    private void alarm(Action action) {
        if (action.getActionTime().getCount() == 0) {
            return;
        }
        Log.e("test", "--alarm--action: " + action);
        List<Coordinate> coordinatesTmp = action.getCoordinates();
        long runTimeTmp = (coordinatesTmp.get(coordinatesTmp.size() - 1).getTime()
                - coordinatesTmp.get(0).getTime()) / 1000;
        String time = (runTimeTmp / 60 + ":" + runTimeTmp % 60);
        LogManager.newInstance().writeMessage(action.getName() + "  " + time);

        List<Long> clickTimes = ClickTool.getClickTime(System.currentTimeMillis(), action);
        clickTimesMap.put(action, clickTimes);
        int offset = getTimeOffset(action);
        for (long clickTime : clickTimes) {
            Log.e("test", action.getName() + ",runningTime:" + TimeUtil.getFormatTime(clickTime + offset)
                    + ",clickTime：" + (clickTime + offset));
            LogManager.newInstance().writeMessage("clickTime:" + TimeUtil.getFormatTime(clickTime + offset));

            if (isBreak(action.getName(), clickTime)) continue;

            long delayMillis = clickTime - System.currentTimeMillis() + offset;
            int runTime = (int) ((clickTime + offset) / 1000);
            Log.e(TAG, "alarm time: " + TimeUtil.getFormatTime(runTime));
            handler.sendMessageDelayed(handler.obtainMessage(0, runTime, 0, action),
                    delayMillis);
        }
    }

    private int getTimeOffset(Action action) {
        int offset = 0;
        if (action.getName().equals("世界boss")
                || action.getName().equals("血战比奇") || action.getName().contains("激情泡点")
                || action.getName().equals("魔界入侵") || action.getName().equals("龙城争霸")) {
            //世界boss提前1s进去
            offset = -1000;
        } else if (action.getName().equals("跨服竞技场")) {
            offset = -2000;
        }
        return offset;
    }

    private void updateUi() {
        if (actions == null) {
            return;
        }
        String ms = "运行中" + "(" + actionRun.getModeType()+ ")" + FLAG;
        long currentTime = System.currentTimeMillis();
        int showCount = 0;
        for (Action action : actions) {
            if (action.getActionTime().getCount() == 0) {
                continue;
            }
            List<Long> clickTimesTmp = clickTimesMap.get(action);
            if (clickTimesTmp == null) {
                continue;
            }

            long[] clickTimes = new long[clickTimesTmp.size()];
            for (int i = 0; i < clickTimesTmp.size(); i++) {
                clickTimes[i] = clickTimesTmp.get(i);
            }
            if (clickTimes == null) {
                return;
            }
            Arrays.sort(clickTimes);
            showCount = 0;
            int offset = getTimeOffset(action);
            boolean addContent = false;
            for (int i = 0; i < clickTimes.length; i++) {
                if (isBreak(action.getName(), clickTimes[i])) continue;

                boolean isCurrentDay = TimeUtil.getLastSecondInDay(System.currentTimeMillis()) == TimeUtil.getLastSecondInDay(clickTimes[i]);
                if (currentTime < clickTimes[i] && showCount < 1 && isCurrentDay) {
                    addContent = true;
                    if (showCount == 0) {
                        ms += action.getName() + FLAG;
                    }
                    ms += TimeUtil.getFormatTime(clickTimes[i] + offset) + "     ";
                    showCount++;
                }
            }

            if (addContent) {
                List<Coordinate> coordinates = action.getCoordinates();
                long runTime = (coordinates.get(coordinates.size() - 1).getTime()
                        - coordinates.get(0).getTime()) / 1000;
                //				ms += (runTime/60 + ":" + runTime%60);
                ms += FLAG;
            }
        }

        textView.setText(ms);
    }

    private boolean isBreak(String name, long clickTime) {
        int week = TimeUtil.dateToWeek(clickTime);
        if (name.equals("血战比奇")) {
            if (!(week == Calendar.MONDAY || week == Calendar.WEDNESDAY || week == Calendar.FRIDAY)) {
                return true;
            }
        }
        if (name.contains("激情泡点")) {
            if (!(week == Calendar.TUESDAY || week == Calendar.THURSDAY)) {
                return true;
            }
        }

        if (name.equals("龙城争霸")) {
            if (!(week == Calendar.SATURDAY)) {
                return true;
            }
        }

        if (name.equals("跨服boss")) {
            if (!(week == Calendar.TUESDAY || week == Calendar.THURSDAY || week == Calendar.SATURDAY)) {
                return true;
            }
        }

        if (name.equals("跨服竞技场")) {
            if (TimeUtil.getCurrentDay() > 28) {
                return true;
            }
        }
        return false;
    }

    Handler handler;

    private void alarmEveryDay() {
        //		((AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE))
        //        .setRepeating(AlarmManager.RTC_WAKEUP, TimeUtil.getLastSecondInDay(System.currentTimeMillis()) + 1000,
        //        		24*60*60*1000,
        //                PendingIntent.getService(getApplicationContext(), 2,
        //                        new Intent(getApplicationContext(), AliveService.class),
        //                        PendingIntent.FLAG_UPDATE_CURRENT));
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // TODO Auto-generated method stub

    }
}
