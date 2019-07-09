package com.example.com.yan.hot.legend;

import android.app.Application;

import timber.log.Timber;

public class CrashApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.init(this);
		Timber.plant(new Timber.DebugTree());
		WifiUtils.getInstance().init(this);
	}
}
