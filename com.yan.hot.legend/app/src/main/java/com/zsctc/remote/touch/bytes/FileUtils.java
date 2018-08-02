package com.zsctc.remote.touch.bytes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
	public static void writeFileMessage(File reportFile,String message)
	{
		try
		{
			
			String msg = message+"\r\n";
			
			boolean result = reportFile.getParentFile().mkdirs();
			
			if(!(reportFile.exists() && reportFile.isFile())) 
			{
				reportFile.createNewFile();
				msg = getHandSetInfo() + "\r\n" + "\r\n" + msg;
			}
			
			FileWriter writer=new FileWriter(reportFile,true);
			writer.write(msg);
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	
	private static String getHandSetInfo(){ 
		String handSetInfo= 
				"手机品牌:" + android.os.Build.BRAND+ 
				",手机型号:" + android.os.Build.MODEL + 
				",SDK版本:" + android.os.Build.VERSION.SDK + 
				",系统版本:" + android.os.Build.VERSION.RELEASE;
		return handSetInfo; 
	} 
	
}
