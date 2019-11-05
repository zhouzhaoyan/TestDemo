package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.yan.hot.legend.pic.SimilarPicture;
import com.example.com.yan.hot.legend.plug.Plug07073;
import com.example.com.yan.hot.legend.plug.PlugAoyou;
import com.example.com.yan.hot.legend.plug.PlugDesktop;
import com.example.com.yan.hot.legend.plug.PlugMiBrowser;
import com.example.com.yan.hot.legend.plug.PlugQQ;
import com.example.com.yan.hot.legend.plug.PlugRelogin;
import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;
import com.zsctc.remote.touch.bytes.NetUtils;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.zsctc.remote.touch.bytes.TimeUtil.getLastSecondInDay;

public class ClickService extends GrayService {

    private static final String ACTION_FLAG = "ACTION_FLAG";
    private static final String ACTION_RUNTIME_FLAG = "ACTION_RUNTIME_FLAG";
    private String actionName = "";
    private List<String> runTimeMap = new ArrayList<String>();
    private ClickThread clickThread;
    public static ClickTool.ClientType clientType = null;
    //无法登陆客户端
    private boolean isError = false;
    private final String FLAG = ",";

    class ClickThread extends Thread {
        //主动停止
        private boolean isStop = false;

        public ClickThread() {
            setName("ClickThread");
        }

        @Override
        public void run() {
            Action action;
            //07073 插件
            Plug07073 plug07073 = new Plug07073();
            PlugAoyou plugAoyou = new PlugAoyou();

            ActionRun actionRun = ActionRunFile.read();
            cancelRestart();

            while (!actions.isEmpty()) {
                if (isStop) {
                    LogManager.newInstance().writeMessage("running next click stop");
                    break;
                }

                action = actions.poll();
                actionName = action.getName();
                ClickTool.ClientType currentType = ClickTypeMap.getClientType(actionName);
                if (currentType != null) {
                    clientType = currentType;
                    PlugDesktop.runClick(ClickService.this);
                    LogManager.newInstance().writeMessage("running click sleep，mode:" + actionRun.getModeType());

                }
                //无法进入游戏则退出，不在运行该客户端
                if (actionName.contains("结束")) {
                    isError = false;
                } else {
                    if (isError) {
                        LogManager.newInstance().writeMessage("running click error," + action.getName());
                        continue;
                    }
                }

                handler.sendEmptyMessage(WAIT_LOADING_RESOURCE);
                LogManager.newInstance().writeMessage("running click sleep");
                if (actionName.contains("血战矿洞")){
                    PlugMiBrowser.run(clickTool, clientType);
                }
                if (actionName.contains("熔炼")/** || actionName.contains("竞技")*/) {
                    screencap(clientType);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                LogManager.newInstance().writeMessage("running click sleep，name:" + action.getName());

                List<Coordinate> coordinates = action.getCoordinates();
                long currentTime = 0;
                long sleep = 0;
                for (Coordinate coordinate : coordinates) {
                    if (isStop) {
                        LogManager.newInstance().writeMessage("running click stop");
                        break;
                    }
                    //无法进入游戏则退出，不在运行该客户端的点击事件
                    if (isError) {
                        LogManager.newInstance().writeMessage("running click error," + action.getName());
                        break;
                    }

                    //运行07073的插件
                    long runTime07073 = plug07073.runPlug(ClickService.this, clientType, coordinate);

                    if (currentTime != 0) {
                        sleep = (int) (coordinate.getTime() - currentTime);
                        if (runTime07073 != 0) {
                            sleep = Math.max(sleep - runTime07073, 5000);
                        }
                    }
                    currentTime = coordinate.getTime();

                    PlugQQ.autoLogin(ClickService.this, clientType, coordinate);

//                    Plug1758Client.run(clickTool, clientType, coordinate);
                    plugAoyou.runClick(ClickService.this, clientType, coordinate);

                    runClick(sleep, coordinate);

                    PlugQQ.runClick(ClickService.this, clientType, coordinate);
                    for (int i = 0; i < 3; i++) {
                        //检查是否能成功登陆
                        PlugRelogin.runClick(ClickService.this, clientType,coordinate);
                    }
                }
                actions.remove(action);
                runTimeMap.remove(0);

            }
            if (!isStop) {
                restart();
            }
            //            stopSelf();
            stopRunnable();
        }

        public void stopRunnable() {
            isStop = true;
            clickThread = null;
            interrupt();
        }
    }

    public void runClick(long sleep, Coordinate coordinate) {
//        Log.e(TAG, "running click sleep，coordinate:" + coordinate.getX() + "," + coordinate.getY());

        try {
            Thread.sleep(Math.max(sleep, 200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.sendMessage(handler.obtainMessage(AUTO_CLICK, coordinate.getX(), coordinate.getY()));
        clickTool.click(coordinate.getX(), coordinate.getY());
    }

    public static Intent getClickService(Context context, Action action, int runTime) {
        Intent intent = new Intent(context, ClickService.class);
        intent.putExtra(ACTION_FLAG, action);
        intent.putExtra(ACTION_RUNTIME_FLAG, runTime);
        return intent;
    }

    private Queue<Action> actions = new LinkedList<Action>();
    public ClickTool clickTool = new ClickTool();
    private ScreenView screenView;
    private TextView textView;
    private String content = "自动运行点击";
    //加载资源
    private final int WAIT_LOADING_RESOURCE = 1;
    //自动点击
    private final int AUTO_CLICK = 2;
    //滑动屏幕
    private final int MOVE_SCREEN = 3;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        public void handleMessage(android.os.Message msg) {
            String s = "";
            if (!runTimeMap.isEmpty()) {
                try {
                    s = "," + runTimeMap.get(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            switch (msg.what) {
                case WAIT_LOADING_RESOURCE:
                    if (ClickService.clientType != null) {
                        textView.setText("等待加载资源， " + ClickService.clientType.name() + FLAG
                                + actionName + s);
                    } else {
                        textView.setText("等待加载资源， " + actionName + s);
                    }
                    break;
                case AUTO_CLICK:
                    if (ClickService.clientType != null) {
                        textView.setText("自动运行点击, " + ClickService.clientType.name() + FLAG
                                + actionName + s + ",x:" + msg.arg1 + ",y:" + msg.arg2);
                    } else {
                        textView.setText("自动运行点击, " + actionName + s + ",x:" + msg.arg1 + ",y:" + msg.arg2);
                    }
                    break;
                case MOVE_SCREEN:
                    textView.setText("正在滑动屏幕");
                    break;
                default:
                    break;
            }
        }
    };

    @SuppressLint("CheckResult")
    private void screencap(final ClickTool.ClientType clientType) {
        Observable.just(0).observeOn(Schedulers.newThread())
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        //保存截图
                        String path = ScreencapPathUtil.getPath(clientType.name());
                        clickTool.screencap(path);
                            return Observable.just(path);
                    }
                }).delay(5, TimeUnit.SECONDS)
                .map(new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(String s) throws Exception {
                        //对比图片的相似度
                        boolean result = SimilarPicture.isEquals(s, clientType);
                        if (!result) {
                            isError = true;
                        }
                        return isError;
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean error) throws Exception {
                        ActionRun actionRun = ActionRunFile.read();
                        actionRun.setActionStates(clientType, error);
                        ActionRunFile.write(actionRun);
                    }
                });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        screenView = new ScreenView(this,false);
        if (clickThread != null) {
            clickThread.stopRunnable();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        run(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    private synchronized void run(Intent intent) {
        View view = screenView.getView();
        if (content != null && !content.equals("")) {
            if (view != null) {
                if (view instanceof LinearLayout) {
                    if (ClickService.clientType != null) {
                        ((TextView) ((LinearLayout) view).getChildAt(0)).setText(content + ", " + ClickService.clientType.name());
                    } else {
                        ((TextView) ((LinearLayout) view).getChildAt(0)).setText(content);
                    }
                }
            } else {
                textView = new TextView(this);
                textView.setText(content);
                textView.setTextSize(15);
                textView.setTextColor(Color.BLUE);
                textView.setPadding(10, 0, 10, 0);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, 50));

                screenView.showScreenshot(linearLayout);
            }
        }

        if (intent != null && intent.getSerializableExtra(ACTION_FLAG) != null) {
            Action action = (Action) intent.getSerializableExtra(ACTION_FLAG);
            int time = intent.getIntExtra(ACTION_RUNTIME_FLAG, 0);
            runTimeMap.add(TimeUtil.getFormatTime(time));
            LogManager.newInstance().writeMessage("running click onStartCommand，name：" + action.getName() + ",waiting");
            actions.add(action);
            if (clickThread == null) {
                clickThread = new ClickThread();
                clickThread.start();
            }
        }
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        screenView.hideScreenshot();
        if (clickThread != null) {
            clickThread.stopRunnable();
        }
    }

    public static void stopService(Context context) {
        Intent intent = new Intent(context, ClickService.class);
        context.stopService(intent);
    }

    private Disposable restartDisposable;

    @SuppressLint("CheckResult")
    public void restart() {
        LogManager.newInstance().writeMessage("running click error, restart");
        restartDisposable = Observable.just(1)
                .delay(30, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        LogManager.newInstance().writeMessage("running click error, restart doing");

                        if (!NetUtils.ping()){
                            LogManager.newInstance().writeMessage("running click error, net err");

                            WifiUtils.getInstance().set(false);
                            Thread.sleep(5000);
                            WifiUtils.getInstance().set(true);
                            Thread.sleep(5000);
                        }

                        AliveService.stopService(getApplicationContext());
                        ClickService.stopService(getApplicationContext());

                        ActionRun actionRun = ActionRunFile.read();
                        Log.e("test", "running click error, actionRun:" + actionRun);
                        if (actionRun.getModeType() == ActionRun.ModeType.NIGHT) {
                            actionRun.setModeType(ActionRun.ModeType.TASK);
                        }
                        List<ActionRun.ActionState> actionStates = actionRun.getActionStates();
                        int repeatTask = actionRun.getRepeatTask();
                        if (/**actionRun.isAuto() && **/isRunningFinish(actionStates) || repeatTask > 3){
                            ActionRun.ModeType[] modeTypes = new ActionRun.ModeType[]{
                                        ActionRun.ModeType.TASK,
                                        ActionRun.ModeType.DAILY_TASK
                                };
                            ActionRun.ModeType currentMode = actionRun.getModeType();
                            ActionRun.ModeType nextMode = null;
                            for (int i = 0; i < modeTypes.length; i++) {
                                if (modeTypes[i] == currentMode){
                                    if (i + 1 < modeTypes.length){
                                        nextMode = modeTypes[i+1];
                                        break;
                                    }
                                }
                            }
                            if (nextMode == null){
                                if (getLastSecondInDay(System.currentTimeMillis()) - System.currentTimeMillis() < 6*60*60*1000){
                                    nextMode = ActionRun.ModeType.NIGHT;
                                } else {
                                    nextMode = ActionRun.ModeType.TASK;
                                }
                            }
                            if (nextMode != null){
                                boolean auto = actionRun.isAuto();
                                boolean checkPoint = actionRun.isAutoCheckPoint();
                                actionRun = new ActionRun(nextMode);
                                actionRun.setAuto(auto);
                                actionRun.setAutoCheckPoint(checkPoint);
                            }
                        } else {
                            actionRun.setRepeatTask(++repeatTask);
                            LogManager.newInstance().writeMessage("running click error, send email");
                            //发送邮件
                            EmailManager.getInstance().sendSync();
                        }
                        ActionRunFile.write(actionRun);
                        return 1;
                    }
                })
                .delay(10, TimeUnit.SECONDS)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        restartDisposable = null;

                        AliveService.openAliveService(getApplicationContext());
                    }
                });
    }

    private boolean isRunningFinish(List<ActionRun.ActionState> actionStates){
        boolean result = true;
        for (ActionRun.ActionState state: actionStates) {
            if (state.isRun()){
                result &= false;
                break;
            }
        }
        return result;
    }

    public void cancelRestart() {
        LogManager.newInstance().writeMessage("running click error, restart cancel，restartDisposable：" + restartDisposable);
        if (restartDisposable != null) {
            if (!restartDisposable.isDisposed()) {
                restartDisposable.dispose();
            }
            restartDisposable = null;
        }
    }
}
