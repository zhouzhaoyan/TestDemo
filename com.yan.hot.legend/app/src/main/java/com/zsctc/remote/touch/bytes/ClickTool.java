package com.zsctc.remote.touch.bytes;

import android.util.Log;

import com.example.com.yan.hot.legend.MainActivity;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

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

    private static class RunNameList<E> extends ArrayList<E> {
        public void add(E value, int count) {
            for (int i = 0; i < count; i++) {
                add(value);
            }
        }
    }

    private static long allRunTime = 0;

    public static void initClient(List<Action> actions) {
        allRunTime = 0;
        clientTypes = new ArrayList<ClientType>();
        List<ClientType> tmp = new ArrayList<ClientType>();
        for (Action action : actions) {
            String name = action.getName();
            Log.e(TAG, "initClient: name:" + action.getName()
                    + "count:" + action.getActionTime().getCount());
            if (action.getActionTime().getCount() == 0) {
                continue;
            }
            if (name.equals("火树")) {
                tmp.add(ClientType.火树);
            } else if (name.equals("07073游戏盒子")) {
                tmp.add(ClientType.游戏07073);
            } else if (name.equals("乐趣")) {
                tmp.add(ClientType.乐趣);
            } else if (name.equals("核弹头")) {
                tmp.add(ClientType.核弹头);
            } else if (name.equals("1758微游戏")) {
                tmp.add(ClientType.游戏1758);
            } else if (name.equals("牛刀")) {
                tmp.add(ClientType.牛刀);
            } else if (name.equals("牛刀网页")) {
                tmp.add(ClientType.牛刀网页);
            } else if (name.equals("玩蛋")) {
                tmp.add(ClientType.玩蛋);
            } else if (name.equals("客娱")) {
                tmp.add(ClientType.客娱);
            }
        }
        Log.e(TAG, "initClient: tmp" + tmp);
        if (tmp.contains(ClientType.火树) && MainActivity.isGame1) {
            clientTypes.add(ClientType.火树);
        }
        if (tmp.contains(ClientType.乐趣) && MainActivity.isGame2) {
            clientTypes.add(ClientType.乐趣);
        }
        if (tmp.contains(ClientType.游戏07073) && MainActivity.isGame3) {
            clientTypes.add(ClientType.游戏07073);
        }
        if (tmp.contains(ClientType.核弹头) && MainActivity.isGame4) {
            clientTypes.add(ClientType.核弹头);
        }
        if (tmp.contains(ClientType.游戏1758) && MainActivity.isGame5) {
            clientTypes.add(ClientType.游戏1758);
        }
        if (tmp.contains(ClientType.牛刀) && MainActivity.isGame6) {
            clientTypes.add(ClientType.牛刀);
        }
        if (tmp.contains(ClientType.牛刀网页) && MainActivity.isGame7) {
            clientTypes.add(ClientType.牛刀网页);
        }
        if (tmp.contains(ClientType.玩蛋) && MainActivity.isGame8) {
            clientTypes.add(ClientType.玩蛋);
        }
        if (tmp.contains(ClientType.客娱) && MainActivity.isGame9) {
            clientTypes.add(ClientType.客娱);
        }
    }

    private static List<ClientType> clientTypes;

    private enum ClientType {
        火树, 游戏07073, 乐趣, 核弹头, 游戏1758, 牛刀, 牛刀网页, 玩蛋, 客娱
    }

    public static List<Long> getClickTime(long time, Action action) {
        List<Long> clickTimes = new ArrayList<Long>();
        int runHour = TimeUtil.getCurrentHour();
        int currentMin = TimeUtil.getCurrentMin();
        long secondTime = TimeUtil.getLastSecondInDay(time) + 2000;
        String name = action.getName();

        RunNameList<String> runNames = new RunNameList<String>();
        Log.e(TAG, "getClickTime,clientTypes: " + clientTypes);
        for (ClientType clientType : clientTypes) {
            switch (clientType) {
                case 火树:
                    runNames.add("火树");
                    break;
                case 游戏07073:
                    runNames.add("07073游戏盒子");
                    break;
                case 乐趣:
                    runNames.add("乐趣");
                    break;
                case 核弹头:
                    runNames.add("核弹头");
                    break;
                case 游戏1758:
                    runNames.add("1758微游戏");
                    break;
                case 牛刀:
                    runNames.add("牛刀");
                    break;
                case 牛刀网页:
                    runNames.add("牛刀网页");
                    break;
                case 玩蛋:
                    runNames.add("玩蛋");
                    break;
                case 客娱:
                    runNames.add("客娱");
                    break;
            }

            if (MainActivity.daily) {
                //日常模式，30分，5个小时
                runNames.add("熔炼");
                runNames.add("血战矿洞");
                runNames.add("熔炼",2);
                runNames.add("竞技");
                runNames.add("王者争霸", 5);
                runNames.add("秘境boss");
                runNames.add("竞技");
                //                runNames.add("神域boss");
                runNames.add("野外boss");
                //                runNames.add("血战矿洞");
            } else if (MainActivity.simple) {
                //简单模式，10分钟，1个小时30分钟
                runNames.add("熔炼");
                runNames.add("血战矿洞");
                runNames.add("熔炼");
                runNames.add("竞技", 2);
                //                runNames.add("野外boss");
            } else if (MainActivity.surplus) {
                //多余模式,15分钟，2个半小时
                //                runNames.add("熔炼");
                //                runNames.add("血战矿洞");
                //                runNames.add("熔炼");
                runNames.add("神兵幻境", 2);
                runNames.add("守护神剑");
            } else {
                //任务模式，56分30秒，10个小时
                runNames.add("熔炼", 2);
                runNames.add("竞技", 2);
                //                runNames.add("王者争霸", 5);
                runNames.add("通天塔");
                runNames.add("材料副本");
                runNames.add("经验副本");
                runNames.add("转生", 2);
                runNames.add("特戒副本");
                runNames.add("个人boss", 5);
                runNames.add("血战矿洞");
                runNames.add("自动关卡");
                //                runNames.add("神兵幻境", 2);
                //                runNames.add("守护神剑");
                runNames.add("秘境boss");
                runNames.add("野外boss", 2);
                runNames.add("熔炼", 2);
                runNames.add("竞技");
                runNames.add("血战矿洞");
            }

            switch (clientType) {
                case 火树:
                    runNames.add("游戏-结束");
                    break;
                case 游戏07073:
                    runNames.add("07073游戏盒子-结束");
                    break;
                case 乐趣:
                    runNames.add("游戏-结束");
                    break;
                case 核弹头:
                    runNames.add("游戏-结束");
                    break;
                case 游戏1758:
                    runNames.add("1758微游戏-结束");
                    break;
                case 牛刀:
                    runNames.add("游戏-结束");
                    break;
                case 牛刀网页:
                    runNames.add("游戏-结束");
                    break;
                case 玩蛋:
                    runNames.add("游戏-结束");
                    break;
                case 客娱:
                    runNames.add("游戏-结束");
                    break;
            }
        }

        long tmpRunningTime;
        int runMin;
        List<Coordinate> coordinatesTmp = action.getCoordinates();
        long runTimeTmp = (coordinatesTmp.get(coordinatesTmp.size() - 1).getTime()
                - coordinatesTmp.get(0).getTime()) / 1000;
        for (int i = 0; i < runNames.size(); i++) {
            if (name.equals(runNames.get(i))) {
                allRunTime = allRunTime + runTimeTmp;
                runMin = currentMin + 1;
                long addTime = i * 1000 * 20;
                tmpRunningTime = TimeUtil.getSpecifyTime(time,
                        runHour, runMin)
                        + addTime;

                if (runHour >= 22) {
                    tmpRunningTime = TimeUtil.getSpecifyTime(secondTime,
                            0, 0)
                            + addTime;
                }

                if (!clickTimes.contains(tmpRunningTime)) {
                    clickTimes.add(tmpRunningTime);
                }
            }
        }

        Log.e(TAG, "getClickTime---allRunTime,min:" + ((allRunTime / 60 / 60) + ":" + (allRunTime / 60 % 60) + ":" + (allRunTime % 60))
                + ",allRunTime:" + allRunTime);

        Log.e(TAG, "getClickTime: name:" + name
                + ",clickTimes:" + clickTimes);
        return clickTimes;
    }
}
