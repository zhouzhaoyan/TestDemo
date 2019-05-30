package com.example.com.yan.hot.legend.pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.zsctc.remote.touch.bytes.ClickTool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import timber.log.Timber;

import static android.content.ContentValues.TAG;
import static com.yan.hot.legend.action.ActionFile.HOT_ROOT;

/**
 * Created by on 2018/10/8.
 */
public class SimilarPicture {

    public static boolean isEquals(String path1, ClickTool.ClientType clientType) {
        Timber.e("isEquals:" + path1);
        String path = HOT_ROOT + File.separator;
        switch (clientType){
            case 核弹头双开:
                path += "核弹头双开.png";
                break;
            case 牛刀:
                path += "牛刀.png";
                break;
            default:
                path += "0-火树.png";
                break;
        }
        return isEquals(path1, path);
    }

    public static boolean isEquals(String path1, String path2) {
        Bitmap bitmap1_1 = getBitmap(getBitmap(path1), 525, 305, 65, 65);
//        SimilarPicture.save(bitmap1_1, "path1-1.png");
        Bitmap bitmap1_2 = getBitmap(getBitmap(path2), 525, 305, 65, 65);
//        SimilarPicture.save(bitmap1_2, "path1-2.png");
        Bitmap bitmap2_1 = getBitmap(getBitmap(path1), 520, 2050, 90, 30);
        Bitmap bitmap2_2 = getBitmap(getBitmap(path2), 520, 2050, 90, 30);
        return isEquals(bitmap1_1, bitmap1_2)
                && isEquals(bitmap2_1,
                bitmap2_2);
    }

    public static Bitmap getBitmap(Bitmap bitmap, int x, int y,
                                    int width, int height) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bmp = Bitmap.createBitmap(bitmap, x, y, width, height, null,
                false);
        if (bitmap != null && !bitmap.equals(bmp)
                && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
        return bmp;
    }

    public static Bitmap getBitmap(String path) {
        return BitmapFactory.decodeFile(path);
    }

    public static boolean isEquals(Bitmap b1, Bitmap b2) {
        return isEqualsPer(b1, b2) >= 90;
    }

    public static float isEqualsPer(Bitmap b1, Bitmap b2) {
        if (b1 == null || b2 == null){
            return 0;
        }
        Log.e(TAG, "isEquals: width:" + b1.getWidth() + "," + b1.getWidth());
        //        save(b1,"1.png");
        //        save(b2,"2.png");
        //先判断宽高是否一致，不一致直接返回false
        if (b1.getWidth() == b2.getWidth()
                && b1.getHeight() == b2.getHeight()) {
            int xCount = b1.getWidth();
            int yCount = b1.getHeight();
            int difference = 0;
            for (int x = 0; x < xCount; x++) {
                for (int y = 0; y < yCount; y++) {
//                                        Log.e(TAG, "isEquals: " + b1.getPixel(x, y) + "," + b2.getPixel(x, y)
//                                                + ",x:" + x + ",y:" + y);
                    //比较每个像素点颜色
                    if (b1.getPixel(x, y) != b2.getPixel(x, y)) {
                        difference ++;
                    }
                }
            }
            float allValue = xCount*yCount*1.0f;
            float per =  (allValue-difference)/allValue*100.0f;
            Log.e(TAG, "isEquals: per:" + per + ",difference:" + difference );
            return per;
        } else {
            return 0;
        }
    }

    public static void save(Bitmap bitmap,String name) {
        File PHOTO_DIR = new File(Environment.getExternalStorageDirectory().getPath());//设置保存路径
        File avaterFile = new File(PHOTO_DIR, name);//设置文件名称
        if (avaterFile.exists()) {
            avaterFile.delete();
        }
        try {
            avaterFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(avaterFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void save(Bitmap bitmap,String dir, String name) {
        File PHOTO_DIR = new File(dir);//设置保存路径
        File avaterFile = new File(PHOTO_DIR, name);//设置文件名称
        if (avaterFile.exists()) {
            avaterFile.delete();
        }
        try {
            avaterFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(avaterFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}