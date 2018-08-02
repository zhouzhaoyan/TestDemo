package com.zsctc.remote.touch.bytes;

/*
 *
 2015.3.30
 linux修改版
 *
 */

import java.io.IOException;
import java.io.OutputStream;

public class LinuxShell {
	private static Process process;
	private static OutputStream outputStream;
	static {
		try {
			process = Runtime.getRuntime().exec("/system/xbin/su");
			outputStream = process.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write(String cmd){
		try {
			outputStream.write((cmd + " \n").getBytes());
			outputStream.flush();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
