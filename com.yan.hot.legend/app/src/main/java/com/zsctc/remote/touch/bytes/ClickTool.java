package com.zsctc.remote.touch.bytes;

import android.util.Log;

import com.yan.hot.legend.action.ActionTime;

import java.util.ArrayList;
import java.util.List;

public class ClickTool {

	LinuxShell shell;
	String devicePath = "/dev/input/event2";

	public ClickTool(){
		shell = new LinuxShell();
//		try {
//			shell.root_cmd("chmod 777 " + devicePath + "\n");
			LinuxShell.write("chmod 777 " + devicePath);
//			Process process = Runtime.getRuntime().exec("/system/xbin/su");
//			OutputStream outputStream = process.getOutputStream();
//			outputStream.write(("getevent -t " + devicePath + "\n").getBytes());
//			outputStream.flush();
//			InputStream inputStream = process.getInputStream();
//			byte[] data = new byte[1024];
//			while (inputStream.read(data) > 0) {
//				Log.e("test", "data:" + new String(data));
//			};
//			if (process != null) {
//				process.destroy();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		shell.get_respond_state();
	}
	
//	public void click(int x, int y){
//		Log.e("tet", "click,x:" + x +",y:" + y);
//		try {
//			String donw = TouchVlaue.eventDown.replace("%3$s", devicePath);
//			donw = donw.replace("%1$s", x+"");
//			donw = donw.replace("%2$s", y+"");
//
//			String up = TouchVlaue.eventUp.replace("%3$s", devicePath);
//
////			shell.root_cmd(donw + up);
////			shell.get_respond_state();
//
//			Process process = Runtime.getRuntime().exec("/system/xbin/su");
//			OutputStream outputStream = process.getOutputStream();
//			outputStream.write((donw + up + "\n").getBytes());
//			outputStream.flush();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void click(int x, int y){
		Log.e("tet", "click,x:" + x +",y:" + y);
		try {
			String donw = TouchVlaue.eventDown.replace("%3$s", devicePath);
			donw = donw.replace("%1$s", x+"");
			donw = donw.replace("%2$s", y+"");

			String up = TouchVlaue.eventUp.replace("%3$s", devicePath);

//			outputStream.write((donw + up + "\n").getBytes());
//			outputStream.flush();
			LinuxShell.write(donw + up);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Long> getClickTime(long time, ActionTime actionTime){
		List<Long> clickTimes = new ArrayList<Long>();
		long secendTime = TimeUtil.getLastSecondInDay(time) + 2000;

		long tmpRunningTime;
		for (int i = 0; i < actionTime.getCount(); i++) {
			long addTime = i * (Math.max(actionTime.getInterval() * 1000 * 60, 300));
			tmpRunningTime = TimeUtil.getSpecifyTime(time,
					actionTime.getHour(), actionTime.getMin())
					+ addTime;

			if (System.currentTimeMillis() > tmpRunningTime) {
				tmpRunningTime = TimeUtil.getSpecifyTime(secendTime,
						actionTime.getHour(), actionTime.getMin())
						+ addTime;
			}
//			result[i] = tmpRunningTime;
            if (!clickTimes.contains(tmpRunningTime)){
                clickTimes.add(tmpRunningTime);
            }
		}
//        long[] result = new long[clickTimes.size()];
//        for (int i = 0; i < clickTimes.size(); i++) {
//            result[i] = clickTimes.get(i);
//        }
//        return result;
        return clickTimes;
	}
}
