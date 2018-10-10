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
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ClickService extends GrayService {
		
	private static final String ACTION_FLAG = "ACTION_FLAG";
	private static final String ACTION_RUNTIME_FLAG = "ACTION_RUNTIME_FLAG";
	private String actionName = "";
	private List<String> runTimeMap = new ArrayList<String>();
	private ClickThread clickThread;
	public static ClickTool.ClientType clientType = null;
	//无法登陆客户端
	private boolean isError = false;

	class ClickThread extends Thread{
		//主动停止
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
				//无法进入游戏则退出，不在运行该客户端
				if (actionName.contains("结束")){
					isError = false;
				} else {
					if (isError){
						LogManager.newInstance().writeMessage("running click error," + action.getName());
						continue;
					}
				}

				handler.sendEmptyMessage(WAIT_LOADING_RESOURCE);
				LogManager.newInstance().writeMessage("running click sleep");
				if (actionName.contains("熔炼")){
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
					//无法进入游戏则退出，不在运行该客户端的点击事件
					if (isError){
						LogManager.newInstance().writeMessage("running click error," + action.getName());
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
				Observable.just(0).observeOn(Schedulers.newThread())
						.flatMap(new Function<Integer, ObservableSource<String>>() {
							@Override
							public ObservableSource<String> apply(Integer integer) throws Exception {
								//保存截图
								String path = ScreencapPathUtil.getPath(ClickService.clientType.name());
								clickTool.screencap(path);
								return Observable.just(path);
							}
						}).delay(2, TimeUnit.SECONDS)
						.map(new Function<String, Boolean>() {
							@Override
							public Boolean apply(String s) throws Exception {
								//对比图片的相似度
								boolean result = SimilarPicture.isEquals(s);
								if (!result) {
									isError = true;
								}
								return isError;
							}
						}).observeOn(Schedulers.newThread())
						.subscribe(new Consumer<Boolean>() {
							@Override
							public void accept(Boolean aBoolean) throws Exception {
								//不相似则更新界面
								if (aBoolean){
									MainActivity.mainActivity.setClientColor(ClickService.clientType, Color.RED);
								}
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
		run(intent);
		return super.onStartCommand(intent, flags, startId);
	}

	private synchronized void run(Intent intent) {
		View view = screenView.getView();
		if (content != null && !content.equals("")) {
			if (view != null) {
				if (view instanceof LinearLayout) {
					if (ClickService.clientType != null){
						((TextView)((LinearLayout)view).getChildAt(0)).setText(content + ", " + ClickService.clientType.name());
					} else {
						((TextView)((LinearLayout)view).getChildAt(0)).setText(content);
					}
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

	public static void stopService(Context context){
		Intent intent = new Intent(context, ClickService.class);
		context.stopService(intent);
	}
}
