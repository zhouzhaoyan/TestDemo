package com.example.com.yan.hot.legend;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by on 2018/9/23.
 */
class WifiUtils {
  private static final WifiUtils ourInstance = new WifiUtils();
  private static WifiManager wifiManager;

  static WifiUtils getInstance() {
    return ourInstance;
  }

  public void init(Context context){
    wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
  }

  public void set(boolean enable){
    if (wifiManager.isWifiEnabled() != enable){
      wifiManager.setWifiEnabled(enable);
    }
  }
}