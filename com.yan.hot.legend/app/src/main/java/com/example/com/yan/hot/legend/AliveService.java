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

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class AliveService extends NotificationListenerService {
	private ScreenView screenView;
	private Map<Action, List<Long>> clickTimesMap = new ArrayMap<Action, List<Long>>();
	private List<Action> actions;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		screenView = new ScreenView(this,false);
		alarmEveryDay();
	}
	
	public static void openAliveService(Context context){
		Intent intent = new Intent(context, AliveService.class);
		context.startService(intent);
	}

	public static void stopService(Context context){
		Intent intent = new Intent(context, AliveService.class);
		context.stopService(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (screenView != null){
			screenView.hideScreenshot();
		}
		if (handler != null){
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
					((TextView)((LinearLayout)view).getChildAt(0)).setText(content);
				}
			}else {
				textView = new TextView(this);
				textView.setText(content);
				textView.setTextSize(13);
				textView.setTextColor(Color.RED);
				textView.setPadding(10, 10, 10, 10);
				LinearLayout linearLayout = new LinearLayout(this);
				linearLayout.addView(textView,new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
				
				screenView.showScreenshot(linearLayout);
			}
		}
		if (handler != null){
			handler.removeMessages(0);
		}
		handler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				int time = msg.arg1 ;
				Log.e("test", "running click:" + (Action)msg.obj + ",time:" + time);
				startService(ClickService.getClickService(getApplicationContext(), (Action)msg.obj, time));
				updateUi();
			};
		};

		actions = ActionFile.read();

		if (actions != null){
			for (Action action : actions) {
				if (!action.getName().contains("野外boss") && !action.getName().equals("神域boss")){
					filerActions.add(action);
				}
			}
			for (Action action : actions) {
//				if (action.getName().contains("跨服boss-埋骨之地")){
					alarm(action);
//				}
			}
		}
		updateUi();
		return super.onStartCommand(intent, Service.START_REDELIVER_INTENT, startId);
	}
	
	private void alarm(Action action){
		if (action.getActionTime().getCount() == 0){
			return;
		}
		Log.e("test", "--alarm--action: " + action);
		List<Coordinate> coordinatesTmp = action.getCoordinates();
		long runTimeTmp = (coordinatesTmp.get(coordinatesTmp.size() - 1).getTime()
				- coordinatesTmp.get(0).getTime())/1000;
		String time = (runTimeTmp/60 + ":" + runTimeTmp%60);
		LogManager.newInstance().writeMessage(action.getName() + "  " + time);
		ActionTime actionTime = action.getActionTime();

		List<Long> clickTimes = ClickTool.getClickTime(System.currentTimeMillis(), actionTime);
		if (action.getName().contains("野外boss") || action.getName().equals("神域boss")){
			//以单双来刷boss
			List<Long> deleteClickTime = new ArrayList<Long>();
			for (long tmp: clickTimes) {
				int hour = TimeUtil.getHour(tmp);
				if ((action.getName().contains("野外boss") && hour%3 == 0)
					|| (action.getName().equals("神域boss") && (hour%3 == 1 || hour%3 == 2))){
					Log.e(TAG, "alarm hour：" + hour + "," + action.getName() + "," + TimeUtil.getFormatTime(tmp));
					deleteClickTime.add(tmp);
				}else {
					Log.e(TAG, "alarm hour else：" + hour + "," + action.getName() + "," + TimeUtil.getFormatTime(tmp));
				}
			}
			clickTimes.removeAll(deleteClickTime);

			Log.e(TAG, "alarm filer: " +  action.getName());
			Map<Long, Long> allClick = new HashMap<Long, Long>();

			for (Action filerAction: filerActions) {
				List<Long> filerTimes = ClickTool.getClickTime(System.currentTimeMillis(), filerAction.getActionTime());
				List<Coordinate> filerCoordinates = filerAction.getCoordinates();
				long filerRunTime = (int) (filerCoordinates.get(filerCoordinates.size() - 1).getTime()
						- filerCoordinates.get(0).getTime()) + 1000;

				for (long tmp: filerTimes) {
					if (isBreak(filerAction.getName(), tmp)) continue;

					Set<Long> key = allClick.keySet();
					boolean add = true;
					for (long tmpClickTime: key){
						if (tmp >= tmpClickTime && tmp <= tmpClickTime + allClick.get(tmpClickTime)){
							LogManager.newInstance().writeMessage("alarm:" +  filerAction.getName()
									+ " same Time:" + TimeUtil.getFormatTime(tmp) + "," + TimeUtil.getFormatTimeForRunTime(filerRunTime)
								+ ",key:" + TimeUtil.getFormatTime(tmpClickTime) + ",value:" + TimeUtil.getFormatTimeForRunTime(allClick.get(tmpClickTime) + filerRunTime));
							allClick.put(tmpClickTime, allClick.get(tmpClickTime) + filerRunTime);
							add = false;
							break;
						}else if ((tmp <= tmpClickTime && (tmp + filerRunTime) >= tmpClickTime)){
							LogManager.newInstance().writeMessage("alarm:" +  filerAction.getName()
									+ " same run Time:" + TimeUtil.getFormatTime(tmp) + "," + TimeUtil.getFormatTimeForRunTime(filerRunTime)
									+ ",key:" + TimeUtil.getFormatTime(tmpClickTime) + ",value:" + TimeUtil.getFormatTimeForRunTime(allClick.get(tmpClickTime) + filerRunTime));
							//								allClick.put(tmpClickTime, allClick.get(tmpClickTime) + filerRunTime);
							long tmpRunTime = allClick.get(tmpClickTime) + filerRunTime;
							allClick.put(tmp, tmpRunTime);
							allClick.remove(tmpClickTime);
							add = false;
							break;
						}
					}
					if (add){
						LogManager.newInstance().writeMessage("alarm:" +  filerAction.getName()
								+ " add Time:" + TimeUtil.getFormatTime(tmp) + "," + TimeUtil.getFormatTime(filerRunTime));
						allClick.put(tmp, filerRunTime);
					}

				}

			}

			List<Long> delete = new ArrayList<Long>();
			List<Coordinate> actionCoordinates = action.getCoordinates();
			long runTime = actionCoordinates.get(actionCoordinates.size() - 1).getTime() - actionCoordinates.get(0).getTime();
			Set<Long> filerClickTime = allClick.keySet();
			for (int i = 0; i < clickTimes.size(); i++) {
				for (long tmpClickTime: filerClickTime) {
					if (clickTimes.get(i) >= tmpClickTime && clickTimes.get(i) <= tmpClickTime + allClick.get(tmpClickTime)){
						Log.e(TAG, "alarm delete click  " + clickTimes.get(i));
						delete.add(clickTimes.get(i));
					} else if ((clickTimes.get(i) <= tmpClickTime && (clickTimes.get(i) + runTime) >= tmpClickTime)){
						Log.e(TAG, "alarm delete runTime " + clickTimes.get(i));
						delete.add(clickTimes.get(i));
					}
				}
			}

			clickTimes.removeAll(delete);

		}

		clickTimesMap.put(action, clickTimes);
		int offset = getTimeOffset(action);
		for (long clickTime: clickTimes) {
			Log.e("test", action.getName() + ",runningTime:" + TimeUtil.getFormatTime(clickTime + offset)
					+ ",clickTime：" + (clickTime + offset));
			LogManager.newInstance().writeMessage("clickTime:" + TimeUtil.getFormatTime(clickTime + offset));

			if (isBreak(action.getName(), clickTime)) continue;

			long delayMillis = clickTime - System.currentTimeMillis() + offset;
			int runTime = (int) ((clickTime + offset)/1000);
			Log.e(TAG, "alarm time: " + TimeUtil.getFormatTime(runTime) );
			handler.sendMessageDelayed(handler.obtainMessage(0, runTime, 0, action),
					delayMillis);
		}
	}

	private int getTimeOffset(Action action) {
		int offset = 0;
		if (action.getName().equals("世界boss")
				||action.getName().equals("血战比奇") || action.getName().contains("激情泡点")
				|| action.getName().equals("魔界入侵") || action.getName().equals("龙城争霸")){
			//世界boss提前1s进去
			offset = -1000;
		} else if (action.getName().equals("跨服竞技场")){
			offset = -2000;
		}
		return offset;
	}

	private void updateUi(){
		if (actions == null){
			return;
		}
		String ms = "";
		long currentTime = System.currentTimeMillis();
		int showCount = 0;
		for (Action action: actions) {
			if (action.getActionTime().getCount() == 0){
				continue;
			}
			List<Long> clickTimesTmp = clickTimesMap.get(action);
			if (clickTimesTmp == null){
				continue;
			}

			long[] clickTimes = new long[clickTimesTmp.size()];
			for (int i = 0; i < clickTimesTmp.size(); i++) {
				clickTimes[i] = clickTimesTmp.get(i);
			}
			if (clickTimes == null){
				return;
			}
			Arrays.sort(clickTimes);
			showCount = 0;
			int offset = getTimeOffset(action);
			boolean addContent = false;
			for (int i = 0; i < clickTimes.length; i++) {
				if (isBreak(action.getName(), clickTimes[i])) continue;

				boolean isCurrentDay = TimeUtil.getLastSecondInDay(System.currentTimeMillis()) == TimeUtil.getLastSecondInDay(clickTimes[i]);
				if (currentTime < clickTimes[i] && showCount < 1 && isCurrentDay){
					addContent = true;
					if (showCount == 0){
						ms += action.getName() + "\n";
					}
					ms += TimeUtil.getFormatTime(clickTimes[i] + offset) + "     ";
					showCount ++;
				}
			}

			if (addContent){
				List<Coordinate> coordinates = action.getCoordinates();
				long runTime = (coordinates.get(coordinates.size() - 1).getTime()
						- coordinates.get(0).getTime())/1000;
//				ms += (runTime/60 + ":" + runTime%60);
				ms += "\n";
			}
		}

		textView.setText(ms);
	}

	private boolean isBreak(String name, long clickTime) {
		int week;
		week = TimeUtil.dateToWeek(clickTime);
		if (name.equals("血战比奇")){
            if (!(week == Calendar.MONDAY || week == Calendar.WEDNESDAY || week == Calendar.FRIDAY)){
				return true;
            }
        }
		if (name.contains("激情泡点")){
            if (!(week == Calendar.TUESDAY || week == Calendar.THURSDAY)){
				return true;
            }
        }

		if (name.equals("龙城争霸")){
            if (!(week == Calendar.SATURDAY )){
				return true;
            }
        }

//		if (name.equals("跨服boss")){
//            if (!(week == Calendar.TUESDAY || week == Calendar.THURSDAY || week == Calendar.SATURDAY )){
//				return true;
//            }
//        }

		if (name.equals("跨服竞技场")){
            if (TimeUtil.getCurrentDay() > 28){
				return true;
            }
        }
		return false;
	}

	Handler handler;
	
	private void alarmEveryDay(){
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
