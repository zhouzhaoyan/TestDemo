package com.example.com.yan.hot.legend;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.yan.hot.legend.action.Coordinate;
import com.yan.hot.legend.action.CoordinateParse;
import com.zsctc.remote.touch.bytes.LinuxShell;
import com.zsctc.remote.touch.bytes.TimeUtil;

import android.R.bool;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 脚本录制
 * @author zhouzhaoyan
 *
 */
public class RecordingScriptService extends GrayService {

	private ScreenView screenView;
	private boolean isRun = true;
	private String cmd = "";
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		isRun = true;
		screenView = new ScreenView(this);
		thread.start();
	}
	
	Thread thread = new Thread(){
		public void run() {
			Log.e("test", "--run--");
			
			String devicePath = "/dev/input/event2";
			InputStream inputStream = null;
			try {
				Process process = Runtime.getRuntime().exec("/system/xbin/su");
				OutputStream outputStream = process.getOutputStream();
				outputStream.write(("getevent -t " + devicePath + "\n").getBytes());
				outputStream.flush();
				inputStream = process.getInputStream();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			LinuxShell shell = new LinuxShell();
//			InputStream inputStream = null;
//			try {
//				String devicePath = "/dev/input/event2";
//				shell.root_cmd("getevent -t " + devicePath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}

			while (isRun) {
				byte[] data = new byte[1024];
				try {
					if (inputStream.read(data) > 0) {
						String str = new String(data).trim();
						cmd += str;
						Log.e("test", "data:" + str);
					}
					handler.sendEmptyMessage(0);
				} catch (IOException e) {
					e.printStackTrace();
				};
//				Log.e("test", "cmd:" + cmd);
			}
		};
	};
	
	private TextView textView;
	private String content = "录制点击";
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			textView.setText(content + "," + TimeUtil.getFormatTime(System.currentTimeMillis()));
		};
	};
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
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
				textView.setTextColor(Color.BLACK);
				textView.setPadding(10, 20, 10, 10);
				textView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "onclick", 1000).show();
//						try {
//							shell.root_cmd2("exit");
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//						shell.get_respond_state();
//						String cmd = shell.get_respond_info();
//						Log.e("test", "cmd:" + cmd);
						List<Coordinate> coordinatess = CoordinateParse.getCoordinate(cmd);
						Log.e("test", "coordinatess:" + coordinatess);
						MainActivity.open(getApplicationContext(), coordinatess);
						screenView.hideScreenshot();
						stopSelf();
					}
				});
				LinearLayout linearLayout = new LinearLayout(this);
				linearLayout.addView(textView,new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
				
				screenView.showScreenshot(linearLayout);
			}
		}
		
		return super.onStartCommand(intent, Service.START_REDELIVER_INTENT, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		isRun = false;
	}
}
