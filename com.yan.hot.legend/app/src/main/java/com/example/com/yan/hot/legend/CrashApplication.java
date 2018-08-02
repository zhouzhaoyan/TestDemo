package com.example.com.yan.hot.legend;

import android.app.Application;

public class CrashApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.init(this);
	}
}
