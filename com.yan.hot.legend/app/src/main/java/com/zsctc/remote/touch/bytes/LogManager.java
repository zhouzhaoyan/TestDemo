package com.zsctc.remote.touch.bytes;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;

import java.io.File;

public class LogManager {

    private static String pathParent =
            Environment.getExternalStorageDirectory().getPath()
                    + File.separator + "hot";
    private static String formatPath =
            pathParent
                    + File.separator
                    + "log.txt";
    public static File logFile = null;

    private static LogManager logManager;
    public static LogManager newInstance(){
        if (logManager == null) {
            logManager = new LogManager();
            logFile.delete();
        }
        return logManager;
    }

    public synchronized static void init(Context context){
        TelephonyManager TelephonyMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String time = TimeUtil.getFormatTimeAll(System.currentTimeMillis());
        init(time);
        System.err.println("init--logFile:" + logFile);
    }

    private static void init(String time){
        File[] files = new File(pathParent).listFiles();
        String path = formatPath;
        logFile = new File(path);
    }

    private Handler handler ;
    public LogManager() {
        HandlerThread handlerThread = new HandlerThread("write File");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                System.err.println((String) msg.obj);
                FileUtils.writeFileMessage(logFile, (String) msg.obj);
            }
        };
        String time = TimeUtil.getFormatTimeAll(System.currentTimeMillis());
        init(time);
    }

    public void removeMessage(){
        handler.removeCallbacksAndMessages(null);
        handler.getLooper().quit();
        logManager = null;
    }

    public void writeMessage(String msg){
        Message message = new Message();
        message.arg1 = 0;
        message.obj = TimeUtil.getFormatTime(System.currentTimeMillis()) + "  " + msg;
        handler.sendMessage(message);
    }


    public void writeMessageCall(String msg){
        System.err.println(msg);
        FileUtils.writeFileMessage(logFile, msg);
    }

}
