package com.zsctc.remote.touch.bytes;

import android.util.Log;

import com.example.com.yan.hot.legend.ClickTypeMap;
import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
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
        LinuxShell.write("chmod 777 " + devicePath);
    }

    public void click(int x, int y) {
        Log.e("tet", "click,x:" + x + ",y:" + y);
        try {
            String donw = TouchVlaue.eventDown.replace("%3$s", devicePath);
            donw = donw.replace("%1$s", x + "");
            donw = donw.replace("%2$s", y + "");

            String up = TouchVlaue.eventUp.replace("%3$s", devicePath);

            LinuxShell.write(donw + up);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void screencap(String path) {
        try {
            LinuxShell.write("screencap -p " + path);
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
    private static ActionRun actionRun;

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
            ClientType clientType = ClickTypeMap.getClientType(name);
            if (clientType != null) {
                tmp.add(clientType);
            }
        }
        actionRun = ActionRunFile.read();
        Log.e(TAG, "initClient: tmp" + tmp);
        if (tmp.contains(ClientType.火树) && actionRun.isRun(ClientType.火树)) {
            clientTypes.add(ClientType.火树);
        }
        if (tmp.contains(ClientType.乐趣网页) && actionRun.isRun(ClientType.乐趣网页)) {
            clientTypes.add(ClientType.乐趣网页);
        }
        if (tmp.contains(ClientType.游戏07073网页) && actionRun.isRun(ClientType.游戏07073网页)) {
            clientTypes.add(ClientType.游戏07073网页);
        }
        if (tmp.contains(ClientType.核弹头网页) && actionRun.isRun(ClientType.核弹头网页)) {
            clientTypes.add(ClientType.核弹头网页);
        }
        if (tmp.contains(ClientType.游戏1758网页) && actionRun.isRun(ClientType.游戏1758网页)) {
            clientTypes.add(ClientType.游戏1758网页);
        }
        if (tmp.contains(ClientType.牛刀) && actionRun.isRun(ClientType.牛刀)) {
            clientTypes.add(ClientType.牛刀);
        }
        if (tmp.contains(ClientType.牛刀网页) && actionRun.isRun(ClientType.牛刀网页)) {
            clientTypes.add(ClientType.牛刀网页);
        }
        if (tmp.contains(ClientType.玩蛋) && actionRun.isRun(ClientType.玩蛋)) {
            clientTypes.add(ClientType.玩蛋);
        }
        if (tmp.contains(ClientType.客娱) && actionRun.isRun(ClientType.客娱)) {
            clientTypes.add(ClientType.客娱);
        }
        if (tmp.contains(ClientType.热血单机) && actionRun.isRun(ClientType.热血单机)) {
            clientTypes.add(ClientType.热血单机);
        }
        if (tmp.contains(ClientType.游戏07073) && actionRun.isRun(ClientType.游戏07073)) {
            clientTypes.add(ClientType.游戏07073);
        }
        if (tmp.contains(ClientType.游戏1758) && actionRun.isRun(ClientType.游戏1758)) {
            clientTypes.add(ClientType.游戏1758);
        }
        if (tmp.contains(ClientType.乐趣) && actionRun.isRun(ClientType.乐趣)) {
            clientTypes.add(ClientType.乐趣);
        }
        if (tmp.contains(ClientType.核弹头) && actionRun.isRun(ClientType.核弹头)) {
            clientTypes.add(ClientType.核弹头);
        }
        if (tmp.contains(ClientType.热血单机h5) && actionRun.isRun(ClientType.热血单机h5)) {
            clientTypes.add(ClientType.热血单机h5);
        }
        if (tmp.contains(ClientType.热血单机双开) && actionRun.isRun(ClientType.热血单机双开)) {
            clientTypes.add(ClientType.热血单机双开);
        }
        if (tmp.contains(ClientType.凹凸果) && actionRun.isRun(ClientType.凹凸果)) {
            clientTypes.add(ClientType.凹凸果);
        }
        if (tmp.contains(ClientType.乐趣双开) && actionRun.isRun(ClientType.乐趣双开)) {
            clientTypes.add(ClientType.乐趣双开);
        }
        if (tmp.contains(ClientType.乐趣网页双开) && actionRun.isRun(ClientType.乐趣网页双开)) {
            clientTypes.add(ClientType.乐趣网页双开);
        }
        if (tmp.contains(ClientType.火树网页双开) && actionRun.isRun(ClientType.火树网页双开)) {
            clientTypes.add(ClientType.火树网页双开);
        }
        if (tmp.contains(ClientType.玩蛋双开) && actionRun.isRun(ClientType.玩蛋双开)) {
            clientTypes.add(ClientType.玩蛋双开);
        }
        if (tmp.contains(ClientType.牛刀网页双开) && actionRun.isRun(ClientType.牛刀网页双开)) {
            clientTypes.add(ClientType.牛刀网页双开);
        }
        if (tmp.contains(ClientType.游戏1758网页双开) && actionRun.isRun(ClientType.游戏1758网页双开)) {
            clientTypes.add(ClientType.游戏1758网页双开);
        }

        if (tmp.contains(ClientType.核弹头双开) && actionRun.isRun(ClientType.核弹头双开)) {
            clientTypes.add(ClientType.核弹头双开);
        }

        if (tmp.contains(ClientType.热血单机h5双开) && actionRun.isRun(ClientType.热血单机h5双开)) {
            clientTypes.add(ClientType.热血单机h5双开);
        }
    }

    private static List<ClientType> clientTypes;

    public enum ClientType {
        火树, 游戏07073网页, 乐趣网页, 核弹头网页, 游戏1758网页, 牛刀, 牛刀网页, 玩蛋, 客娱,
        热血单机, 游戏07073, 游戏1758, 乐趣, 核弹头, 热血单机h5, 热血单机双开, 凹凸果,
        乐趣双开, 乐趣网页双开, 火树网页双开, 玩蛋双开,
        牛刀网页双开,游戏1758网页双开, 核弹头双开, 热血单机h5双开
    }

    public static List<Long> getClickTime(long time, Action action) {
        List<Long> clickTimes = new ArrayList<>();
        int runHour = TimeUtil.getCurrentHour();
        int currentMin = TimeUtil.getCurrentMin();
        long secondTime = TimeUtil.getLastSecondInDay(time) + 2000;
        String name = action.getName();

        RunNameList<String> runNames = new RunNameList<String>();
        Log.e(TAG, "getClickTime,clientTypes: " + clientTypes);
        for (ClientType clientType : clientTypes) {

            runNames.add(ClickTypeMap.getActionName(clientType));

            switch (actionRun.getModeType()){
                case DAILY:
                    //日常模式，10分
                    runNames.add("熔炼new");
                    runNames.add("竞技new");
                    runNames.add("血战矿洞");
                    runNames.add("秘境boss快速sample");
                    runNames.add("野外boss快速sample");
                    break;
                case DAILY_TASK:
                    //日常任务模式，13分
                    runNames.add("熔炼new");
                    runNames.add("竞技new");
                    runNames.add("血战矿洞");
                    runNames.add("王者争霸");
                    runNames.add("秘境boss快速sample");
                    runNames.add("野外boss快速sample");
                    break;
                case SIMPLE:
                    //简单模式，6分钟30秒
                    runNames.add("熔炼new");
                    runNames.add("竞技new");
                    runNames.add("血战矿洞");
                    runNames.add("秘境boss快速sample");
                    break;
                case NIGHT:
                case TASK:
                    //任务模式，20分
                    runNames.add("熔炼new");
                    runNames.add("竞技new");
                    runNames.add("血战矿洞");
                    runNames.add("通天塔");
                    if (isFastest(clientType)) {
                        runNames.add("材料副本快速");
                    } else {
                        runNames.add("材料副本");
                    }
                    runNames.add("经验副本");
                    runNames.add("转生");
                    runNames.add("个人boss");
                    runNames.add("自动关卡sample");
                    runNames.add("秘境boss快速sample");
                    runNames.add("野外boss快速sample");
                    break;
            }

            switch (clientType) {
                case 火树:
                case 游戏07073网页:
                case 乐趣网页:
                case 游戏1758网页:
                case 牛刀:
                case 玩蛋:
                case 热血单机:
                case 乐趣:
                case 核弹头:
                case 热血单机双开:
                case 凹凸果:
                case 乐趣双开:
                case 乐趣网页双开:
                case 火树网页双开:
                case 玩蛋双开:
                case 牛刀网页双开:
                case 游戏1758网页双开:
                case 核弹头双开:
                case 热血单机h5:
                    runNames.add("游戏-结束");
                    break;
                case 牛刀网页:
                case 客娱:
                case 核弹头网页:
                    runNames.add("游戏-登录结束");
                    break;
                case 游戏07073:
                case 热血单机h5双开:
                    runNames.add("07073游戏盒子-结束");
                    break;
                case 游戏1758:
                    runNames.add("1758微游戏-结束");
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

                if (actionRun.getModeType() == ActionRun.ModeType.NIGHT) {
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

        Log.e(TAG, "getClickTime  end: name:" + name
                + ",clickTimes:" + clickTimes);
        return clickTimes;
    }

    private static boolean isFastest(ClientType clientType) {
        boolean result = false;
        switch (clientType) {
            case 火树:
            case 游戏07073网页:
            case 乐趣网页:
            case 核弹头网页:
            case 游戏1758网页:
            case 牛刀:
            case 牛刀网页:
            case 玩蛋:
            case 客娱:
            case 热血单机:
            case 游戏07073:
            case 游戏1758:
            case 乐趣:
            case 核弹头:
            case 热血单机h5:
            case 热血单机双开:
            case 凹凸果:
                result = true;
                break;
        }
        return result;
    }
}
