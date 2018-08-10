package com.zsctc.remote.touch.bytes;

import android.util.Log;

import com.example.com.yan.hot.legend.MainActivity;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionTime;

import java.util.ArrayList;
import java.util.List;

public class ClickTool {

    LinuxShell shell;
    String devicePath = "/dev/input/event3";

    public ClickTool() {
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

    public void click(int x, int y) {
        Log.e("tet", "click,x:" + x + ",y:" + y);
        try {
            String donw = TouchVlaue.eventDown.replace("%3$s", devicePath);
            donw = donw.replace("%1$s", x + "");
            donw = donw.replace("%2$s", y + "");

            String up = TouchVlaue.eventUp.replace("%3$s", devicePath);

            //			outputStream.write((donw + up + "\n").getBytes());
            //			outputStream.flush();
            LinuxShell.write(donw + up);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Long> getClickTime(long time, Action action) {
        ActionTime actionTime = action.getActionTime();
        List<Long> clickTimes = new ArrayList<Long>();
        //		int runHour = actionTime.getHour();
        //		int runMin = actionTime.getMin();
        int runHour = TimeUtil.getCurrentHour();
        int runMin = TimeUtil.getCurrentMin() + 1;
        long secondTime = TimeUtil.getLastSecondInDay(time) + 2000;
        String name = action.getName();

        if (MainActivity.filter) {
            if (name.equals("熔炼")) {
                runMin += 1;
            } else if (name.equals("竞技")) {
                runMin += 2;
            } else if (name.equals("血战矿洞")) {
                runMin += 3;
            } else if (name.equals("秘境boss")) {
                runMin += 4;
            } else if (name.equals("野外boss")) {
                runMin += 5;
            } else if (name.equals("神域boss")) {
                runMin += 6;
            } else {
                return clickTimes;
            }
        } else {
            if (name.equals("熔炼")) {
                runMin += 1;
            } else if (name.equals("竞技")) {
                runMin += 2;
            } else if (name.equals("血战矿洞")) {
                runMin += 3;
            } else if (name.equals("王者争霸")) {
                runMin += 4;
            } else if (name.equals("材料副本")) {
                runMin += 5;
            } else if (name.equals("经验副本")) {
                runMin += 6;
            } else if (name.equals("转生")) {
                runMin += 7;
            } else if (name.equals("特戒副本")) {
                runMin += 8;
            } else if (name.equals("个人boss")) {
                runMin += 9;
            } else if (name.equals("自动关卡")) {
                runMin += 10;
            } else if (name.equals("神兵幻境")) {
                runMin += 11;
            } else if (name.equals("守护神剑")) {
                runMin += 12;
            } else if (name.equals("秘境boss")) {
                runMin += 13;
            } else if (name.equals("野外boss")) {
                runMin += 14;
            } else if (name.equals("神域boss")) {
                runMin += 15;
            } else {
            }
        }

        long tmpRunningTime;
        for (int i = 0; i < actionTime.getCount(); i++) {
            int interval = actionTime.getInterval();
            if (!MainActivity.filter) {
                if (name.equals("熔炼") && i == 2) {
                    runMin += 16;
                    interval = 0;
                } else if (name.equals("竞技") && i >= 1 ) {
                    runMin += 17;
                    interval = 0;
                } else if (name.equals("血战矿洞") && i >= 1 ) {
                    runMin += 18;
                    interval = 0;
                }
            }

            long addTime = i * (Math.max(interval * 1000 * 60, 300));
            tmpRunningTime = TimeUtil.getSpecifyTime(time,
                    runHour, runMin)
                    + addTime;

            if (System.currentTimeMillis() > tmpRunningTime) {
                tmpRunningTime = TimeUtil.getSpecifyTime(secondTime,
                        runHour, runMin)
                        + addTime;
            }
            //			result[i] = tmpRunningTime;
            if (!clickTimes.contains(tmpRunningTime)) {
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
