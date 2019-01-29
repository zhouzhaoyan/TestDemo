package com.example.com.yan.hot.legend.runstate;

import android.os.Environment;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by on 2018/9/29.
 */
public class ActionRunFile {
    private final static String path = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "hot" + File.separator + "actionRun.txt";

    public static void write(ActionRun actionRun){
        FileOutputStream fos = null;
        new File(path).getParentFile().mkdirs();
        new File(path).delete();
        try {
            fos = new FileOutputStream(path);
            fos.write(JSON.toJSONString(actionRun).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ActionRun read(){
        FileInputStream fis = null;
        ActionRun p = new ActionRun(ActionRun.ModeType.TASK);
        try {
            fis = new FileInputStream(path);
            byte[] date = new byte[fis.available()];
            fis.read(date);
            String tmp = new String(date);
//            Log.e("test", "read: tmp:" + tmp );
            p = JSON.parseObject(tmp,ActionRun.class);
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return p;
    }

    public static void delete(){
        new File(path).delete();
    }
}
