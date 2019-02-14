package com.yan.hot.legend.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

import android.os.Environment;

public class ActionFile {
	
	private final static String path = Environment.getExternalStorageDirectory().getPath()
			+ File.separator + "hot" + File.separator + "config.txt";

	private final static String pathTmp = Environment.getExternalStorageDirectory().getPath()
			+ File.separator + "hot" + File.separator + "config_tmp.txt";
	
	public static void write(List<Action> action){
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        new File(path).getParentFile().mkdirs();
        new File(pathTmp).delete();
        new File(path).renameTo(new File(pathTmp));
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(action);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static List<Action> read(){
		ObjectInputStream ois = null;
		List<Action> p = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			p = (List<Action>)ois.readObject();  
	        System.out.println(p);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
		        try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		}
		return p;
	}
}
