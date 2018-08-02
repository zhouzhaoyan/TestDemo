package com.example.com.yan.hot.legend;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

public class GrayService extends Service {

    private final static int GRAY_SERVICE_ID = 1001;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (Build.VERSION.SDK_INT < 18) {
            startForeground(GRAY_SERVICE_ID, new Notification());//API < 18 ，此方法能有效隐藏Notification上的图标
        } else {
            Intent innerIntent = new Intent(this, GrayInnerService.class);
            try {
                startService(innerIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }

            startForeground(GRAY_SERVICE_ID, new Notification());
        }

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 给 API >= 18 的平台上用的灰色保活手段
     */
    public static class GrayInnerService extends Service {
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(GRAY_SERVICE_ID, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public IBinder onBind(Intent intent) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}