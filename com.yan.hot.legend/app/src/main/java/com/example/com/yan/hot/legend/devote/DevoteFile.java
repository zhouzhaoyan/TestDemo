package com.example.com.yan.hot.legend.devote;

import android.os.Environment;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by on 2018/9/29.
 */
public class DevoteFile {
    private final static String path = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "hot" + File.separator + "devote.txt";

    public static void write(List<DevoteObject> devoteObjects){
        FileOutputStream fos = null;
        new File(path).getParentFile().mkdirs();
        new File(path).delete();
        try {
            fos = new FileOutputStream(path);
            fos.write(JSON.toJSONString(devoteObjects).getBytes());
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

    public static List<DevoteObject> read(){
        FileInputStream fis = null;
        List<DevoteObject> p = null;
        try {
            fis = new FileInputStream(path);
            byte[] date = new byte[fis.available()];
            fis.read(date);
            String tmp = new String(date);
            Log.e("test", "read: tmp:" + tmp );
            p = JSON.parseArray(tmp,DevoteObject.class);
            System.out.println(p);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return p;
    }
}
