package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 异常捕获
 */
public class CrashHandler implements UncaughtExceptionHandler {

    private UncaughtExceptionHandler handler;
    private Context context;

    private static CrashHandler crashHandler;

    public static CrashHandler init(Context context) {
        if (crashHandler == null) {
            crashHandler = new CrashHandler(context);
        }
        return crashHandler;
    }

    private CrashHandler(Context context) {

        handler = Thread.getDefaultUncaughtExceptionHandler();
        this.context = context;

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    SimpleDateFormat simpledateformat = new SimpleDateFormat(
            "dd-MM-yyyy hh:mm:ss");

    @SuppressLint("SimpleDateFormat")
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {


        // 日期、app版本信息
        StringBuilder buff = new StringBuilder();
        buff.append("Date: ").append(simpledateformat.format(new Date()))
                .append("\n");
        buff.append("========MODEL:" + Build.MODEL + " \n");
        // 崩溃的堆栈信息
        buff.append("Stacktrace:\n\n");
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        throwable.printStackTrace(printwriter);
        buff.append(stringwriter.toString());
        buff.append("===========\n");
        printwriter.close();

        write2ErrorLog(buff.toString());

        if (handler != null) {
            // 交给还给系统处理
            handler.uncaughtException(thread, throwable);
        }
//        System.exit(0);
    }

//    // 到SD卡目录
//    private final static String DISK_CACHE_PATH = "/LSSport/";
//
//    /**
//     * 创建总文件夹
//     */
//    public String getFilePath() {
//        String cachePath;
//        // /mnt/sdcard判断有无SD卡
//        if (Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED)) {
//            cachePath = Environment.getExternalStorageDirectory()
//                    + DISK_CACHE_PATH;
//        } else {
//            // 没有就创建到手机内存
//            cachePath = ApplicationHolder.getmApplication().getCacheDir() + DISK_CACHE_PATH;
//        }
//        File file = new File(cachePath);
//        if (!file.exists()) {
//            // 创建文件夹
//            file.mkdirs();
//        }
//        return cachePath;
//    }

    private void write2ErrorLog(String content) {

        File file = new File(Environment.getExternalStorageDirectory().getPath()
                + File.separator + "hot" + File.separator
                + "crash.txt");
        FileOutputStream fos = null;
        try {
        	file.getParentFile().mkdirs();
            if (file.exists()) {
                // 清空之前的记录
                file.delete();
            } else {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            fos = new FileOutputStream(file);
            fos.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // public static String getLogs() {
    //
    // // 取得文本文件
    // File file = new File(getFilePath + "/crash.txt");
    // // 存储内容的文本对象
    // StringBuilder text = new StringBuilder();
    // BufferedReader br = null;
    // FileInputStream fileIS = null;
    // try {
    // fileIS = new FileInputStream(file);
    // br = new BufferedReader(new InputStreamReader(fileIS));
    // String line;
    //
    // while ((line = br.readLine()) != null) {
    // text.append(line);
    // text.append('\n');
    // }
    // br.close();
    // } catch (IOException e) {
    //
    // } finally {
    // if (fileIS != null) {
    // try {
    // fileIS.close();
    // } catch (IOException e) {
    // }
    // fileIS = null;
    // }
    // if (br != null) {
    // try {
    // br.close();
    // } catch (IOException e1) {
    // }
    // }
    // }
    //
    // return text.toString();
    // }

    // private static String a(Throwable throwable) {
    // String s = (new StringBuilder()).append("Cause:\n").append("\n")
    // .toString();
    // StringWriter stringwriter = new StringWriter();
    // PrintWriter printwriter = new PrintWriter(stringwriter);
    // for (Throwable throwable1 = throwable.getCause(); throwable1 != null;
    // throwable1 = throwable1
    // .getCause()) {
    // throwable1.printStackTrace(printwriter);
    // String s3 = (new StringBuilder()).append(s)
    // .append(stringwriter.toString()).toString();
    // s = (new StringBuilder()).append(s3).append("\n").toString();
    // }
    //
    // String s1 = (new StringBuilder()).append(s)
    // .append(stringwriter.toString()).toString();
    // String s2 = (new StringBuilder()).append(s1).append("===========\n")
    // .toString();
    // printwriter.close();
    // return s2;
    // }

}
