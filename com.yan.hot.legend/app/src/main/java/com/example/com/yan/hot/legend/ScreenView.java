package com.example.com.yan.hot.legend;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class ScreenView{
	private void log(String msg) {
		if (true) {
			Log.i("ScreenView", msg);
		}
	}

	private Context context;
	private WindowManager mWM;
	private View view = null;
	private int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;;
	
	public ScreenView(Context context) {
		this(context, true);
	}
	
	public ScreenView(Context context, boolean touch) {
		this.context = context;
		if (touch) {
			this.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		}else{
			this.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
					| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE 
					| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;// 这句设置桌面可控;
		}
	}

	public void showScreenshot(View view){
		mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		this.view = view;
		
		WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
		wmParams.type = LayoutParams.TYPE_SYSTEM_ALERT; // type是关键，这里的2002表示系统级窗口，你也可以试试2003。
		wmParams.flags= flags;

		int width = mWM.getDefaultDisplay().getWidth();
		int height = mWM.getDefaultDisplay().getHeight();
		
		wmParams.x = -width;
		wmParams.y = -height;

		log("wmParams.x:" + wmParams.x + "------wmParams.y:" + wmParams.y);

		wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
		wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		wmParams.format = -3; // 透明

		mWM.addView(view, wmParams);
	}
	
	public View getView(){
		return view;
	}
	
	//显示截屏控件
	public void showScreenshot(int layout) {
		view = LayoutInflater.from(context).inflate(layout, null);
		showScreenshot(view);
	}

	//隐藏截屏控件
	public void hideScreenshot() {
		if (mWM != null) {
			mWM.removeView(view);
		}
	}
	
}
