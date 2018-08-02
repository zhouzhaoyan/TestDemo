package com.zsctc.remote.touch.bytes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.util.Log;

public class TouchEventUtil {
	private static void log(String msg){
		if (false) {
			Log.e("TouchEventUtil", msg);
		}
	}
	//写进touchEvent设备
	public static void write(String eventPath,byte[] touchEvent){
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(eventPath);
			fileOutputStream.write(touchEvent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
