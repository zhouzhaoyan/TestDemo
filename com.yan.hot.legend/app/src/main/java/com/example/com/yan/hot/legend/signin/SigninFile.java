package com.example.com.yan.hot.legend.signin;

import android.os.Environment;

import com.alibaba.fastjson.JSON;
import com.example.com.yan.hot.legend.devote.DevoteObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SigninFile {
    private final static String path = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "hot" + File.separator + "signin.txt";

    public static void write(List<SigninObject> signinObjects){
        FileOutputStream fos = null;
        new File(path).getParentFile().mkdirs();
        new File(path).delete();
        try {
            fos = new FileOutputStream(path);
            fos.write(JSON.toJSONString(signinObjects).getBytes());
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

    public static List<SigninObject> read(){
        FileInputStream fis = null;
        List<SigninObject> p = null;
        try {
            fis = new FileInputStream(path);
            byte[] date = new byte[fis.available()];
            fis.read(date);
            String tmp = new String(date);
//            Log.e("test", "read: tmp:" + tmp );
            p = JSON.parseArray(tmp,SigninObject.class);
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
