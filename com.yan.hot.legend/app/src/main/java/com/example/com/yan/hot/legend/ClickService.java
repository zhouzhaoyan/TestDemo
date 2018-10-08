package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ClickService extends GrayService {
		
	private static final String ACTION_FLAG = "ACTION_FLAG";
	private static final String ACTION_RUNTIME_FLAG = "ACTION_RUNTIME_FLAG";
	private String actionName = "";
	private List<String> runTimeMap = new ArrayList<String>();
	private ClickThread clickThread;
	public static ClickTool.ClientType clientType = null;

	class ClickThread extends Thread{
		private boolean isStop = false;
		@Override
		public void run() {
			Action action;
			while (!actions.isEmpty()) {
				if (isStop){
					LogManager.newInstance().writeMessage("running next click stop");
					break;
				}

				action = actions.poll();
				actionName = action.getName();
				ClickTool.ClientType currentType = ClickTool.getClientType(actionName);
				if (currentType != null) {
					clientType = currentType;
				}
				handler.sendEmptyMessage(WAIT_LOADING_RESOURCE);
				LogManager.newInstance().writeMessage("running click sleep");
				if (actionName.contains("竞技")){
					handler.sendEmptyMessage(SCREENCAP);
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
					if (isStop){
						LogManager.newInstance().writeMessage("running click stop");
						break;
					}

					if (currentTime != 0) {
						sleep = (int) (coordinate.getTime() - currentTime);
					}
					currentTime = coordinate.getTime();
					try {
						sleep = Math.max(sleep, 200);
						Log.e("test", "sleep:" + sleep);
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					handler.sendMessage(handler.obtainMessage(AUTO_CLICK, coordinate.getX(), coordinate.getY()));
					new ClickTool().click(coordinate.getX(), coordinate.getY());
				}
				actions.remove(action);
				runTimeMap.remove(0);

			}
			stopSelf();
		}

		public void stopRunnable(){
			isStop = true;
		}
	}
	
	public static Intent getClickService(Context context, Action action, int runTime){
		Intent intent = new Intent(context, ClickService.class);
		intent.putExtra(ACTION_FLAG, action);
		intent.putExtra(ACTION_RUNTIME_FLAG, runTime);
		return intent;
	}
	
	private Queue<Action> actions = new LinkedList<Action>();
	private ClickTool clickTool = new ClickTool();
	private ScreenView screenView;
	private TextView textView;
	private String content = "自动运行点击";
	//加载资源
	private final int WAIT_LOADING_RESOURCE = 1;
	//自动点击
	private final int AUTO_CLICK = 2;
	//滑动屏幕
	private final int MOVE_SCREEN = 3;
	//截屏
	private static final int SCREENCAP = 4;
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler(){
		@SuppressLint("SetTextI18n")
		public void handleMessage(android.os.Message msg) {
			String s = "";
			if (!runTimeMap.isEmpty()){
				try {
					s = "," + runTimeMap.get(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			switch (msg.what) {
			case WAIT_LOADING_RESOURCE:
				if (ClickService.clientType != null){
					textView.setText("等待加载资源， "  + ClickService.clientType.name() + "\n"
							+ actionName  + s);
				} else {
					textView.setText("等待加载资源， " + actionName  + s);
				}
				break;
			case AUTO_CLICK:
				if (ClickService.clientType != null){
					textView.setText("自动运行点击, " + ClickService.clientType.name() + "\n"
							+ actionName + s + ",x:" + msg.arg1 + ",y:" + msg.arg2);
				} else {
					textView.setText("自动运行点击, " + actionName + s + ",x:" + msg.arg1 + ",y:" + msg.arg2);
				}
				break;
			case MOVE_SCREEN:
				textView.setText("正在滑动屏幕");
				break;
			case SCREENCAP:
				Observable.just(0).observeOn(Schedulers.newThread()).subscribe(new Consumer<Integer>() {
					@Override
					public void accept(Integer integer) throws Exception {
						clickTool.screencap(ScreencapPathUtil.getPath(ClickService.clientType.name()));
					}
				});
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		screenView = new ScreenView(this);
		if (clickThread != null){
			clickThread.stopRunnable();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.e("test", "onStartCommand:" + intent.getSerializableExtra(ACTION_FLAG));
		run(intent);
		return super.onStartCommand(intent, flags, startId);
	}

	private synchronized void run(Intent intent) {
		View view = screenView.getView();
		if (content != null && !content.equals("")) {
			if (view != null) {
				if (view instanceof LinearLayout) {
					((TextView)((LinearLayout)view).getChildAt(0)).setText(content);
				}
			}else {
				textView = new TextView(this);
				textView.setText(content);
				textView.setTextSize(15);
				textView.setTextColor(Color.BLUE);
				textView.setPadding(10, 20, 10, 10);
				LinearLayout linearLayout = new LinearLayout(this);
				linearLayout.addView(textView,new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

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
				wakeUpAndUnlock();
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
		if (clickThread != null){
			clickThread.stopRunnable();
		}
	}
	
	/**
     * 唤醒手机屏幕并解锁
     */
    public void wakeUpAndUnlock() {
        // 获取电源管理器对象
        PowerManager pm = (PowerManager) getApplication()
                .getSystemService(Context.POWER_SERVICE);
        boolean screenOn = pm.isScreenOn();
        if (!screenOn) {
            // 获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
            PowerManager.WakeLock wl = pm.newWakeLock(
                    PowerManager.ACQUIRE_CAUSES_WAKEUP |
                            PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
            wl.acquire(10000); // 点亮屏幕
//            wl.acquire(coordinates.get(coordinates.size() - 1).getTime() - coordinates.get(0).getTime() + 10000); // 点亮屏幕
            wl.release(); // 释放
        }
        // 屏幕解锁
        KeyguardManager keyguardManager = (KeyguardManager) getApplication()
                .getSystemService(KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("unLock");
        // 屏幕锁定
        keyguardLock.reenableKeyguard();
        keyguardLock.disableKeyguard(); // 解锁
    }

	public static void stopService(Context context){
		Intent intent = new Intent(context, ClickService.class);
		context.stopService(intent);
	}
}
