package com.zsctc.remote.touch.bytes;

import android.util.Log;

import com.example.com.yan.hot.legend.ClickTypeMap;
import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;

import java.util.ArrayList;
import java.util.Calendar;
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

    public void swipe(int x1, int y1, int x2, int y2) {
        try {
            LinuxShell.write("input swipe " + x1 + " " + y1 + " "
                    + x2 + " " + y2);
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
    public static ActionRun actionRun;

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
        ClientType[] allClientTypes = ClientType.values();
        for (ClientType clientType : allClientTypes) {
            if (tmp.contains(clientType) && actionRun.isRun(clientType)) {
                clientTypes.add(clientType);
            }
        }
        Log.e(TAG, "initClient: " + clientTypes);
    }

    private static List<ClientType> clientTypes;

    public enum ClientType {
        玩蛋搜狗,趣头条搜狗,火树搜狗,
        玩蛋uc极速,趣头条uc极速,火树uc极速,
        玩蛋360极速, 趣头条360极速, 火树360极速, 玩蛋遨游, 趣头条遨游, 火树遨游, 牛刀猎豹, 趣头条猎豹, 游戏1758猎豹浏览器,
        游戏07073浏览器360, 乐趣360浏览器, 游戏1758浏览器360, 玩蛋360浏览器, 趣头条360浏览器, 火树360浏览器,牛刀浏览器360,
        趣头条qq浏览器, 趣头条uc浏览器, 趣头条qq浏览器双开,
        玩蛋猎豹浏览器, 玩蛋qq浏览器双开, 火树猎豹浏览器, 火树qq浏览器双开,
        火树, 游戏07073网页, 乐趣网页, 玩蛋, 游戏1758网页, 牛刀, 牛刀网页, 核弹头网页, 客娱,
        热血单机, 游戏07073, 游戏1758, 乐趣, 核弹头, 热血单机h5, 热血单机双开, 凹凸果,
        乐趣双开, 乐趣网页双开, 火树网页双开, 玩蛋双开,
        牛刀网页双开, 游戏1758网页双开, 核弹头双开, 热血单机h5双开,
        火树qq浏览器, 玩蛋qq浏览器, 乐趣qq浏览器, 游戏1758qq浏览器, 牛刀qq浏览器,
    }

    public static List<Long> getClickTime(long time, Action action) {
        List<Long> clickTimes = new ArrayList<>();
        int runHour = TimeUtil.getCurrentHour();
        int currentMin = TimeUtil.getCurrentMin();
        long secondTime = TimeUtil.getLastSecondInDay(time) + 2000;
        String name = action.getName();

        RunNameList<String> runNames = new RunNameList<String>();
        Log.e(TAG, "getClickTime,clientTypes: " + clientTypes);
        int index = 0;
        for (ClientType clientType : clientTypes) {

            runNames.add(ClickTypeMap.getActionName(clientType));

            switch (actionRun.getModeType()) {
                case DAILY:
                    //日常模式，9分
                    runNames.add("血战矿洞");
                    runNames.add("熔炼new");
                    runNames.add(getMiJingBoss(index));
                    runNames.add("野外boss快速sample");
                    runNames.add("竞技sample");
                    break;
                case DAILY_TASK:
                    //日常任务模式，12分
                    runNames.add("血战矿洞");
                    runNames.add("熔炼new");
//                    runNames.add("王者争霸");
                    if (isRunKing(actionRun.getModeType())) {
                        runNames.add("王者争霸sample");
                    }
                    runNames.add(getMiJingBoss(index));
                    runNames.add("野外boss快速sample");
                    if (is8Turn(clientType)){
                        runNames.add("竞技sample-8转");
                    } else {
                        runNames.add("竞技sample");
                    }
                    break;
                case SIMPLE:
                    //简单模式，6分钟30秒
                    runNames.add("血战矿洞");
                    runNames.add("熔炼new");
                    runNames.add(getMiJingBoss(index));
                    runNames.add("竞技sample");
//                    runNames.add("签到");
                    break;
                case NIGHT:
                case TASK:
                    //任务模式，20分
                    runNames.add("血战矿洞");
                    runNames.add("熔炼new");
//                    runNames.add("签到");
                    runNames.add("通天塔sample");

                    if (isFastest(clientType)) {
                        runNames.add("材料副本快速");
                    } else {
                        runNames.add("材料副本");
                    }

                    if (is8Turn(clientType) || is7Turn(clientType)) {
                        runNames.add("经验副本sample");
                    } else {
                        runNames.add("经验副本");
                    }

                    if (isZhuansheng(actionRun.getModeType())) {
                        runNames.add("转生");
                    }

                    if (isSlowest(clientType)) {
                        runNames.add("个人boss");
                    } else {
                        runNames.add("个人boss快速");
                    }

                    if (actionRun.isAutoCheckPoint()) {
                        runNames.add("自动关卡-sample");
                    }
                    runNames.add(getMiJingBoss(index));
                    runNames.add("野外boss快速sample");
                    runNames.add("竞技sample");
                    if (isRunKing(actionRun.getModeType())) {
                        runNames.add("王者争霸sample");
                    }
                    break;
            }

            switch (clientType) {
                case 火树:
                case 乐趣网页:
                case 游戏1758网页:
                case 牛刀:
                case 玩蛋:
                case 热血单机:
                case 游戏07073:
                case 热血单机双开:
                case 凹凸果:
                case 乐趣双开:
                case 乐趣网页双开:
                case 火树网页双开:
                case 玩蛋双开:
                case 牛刀网页双开:
                case 游戏1758网页双开:
                case 核弹头双开:
                case 热血单机h5双开:
                case 火树qq浏览器:
                case 玩蛋qq浏览器:
                case 乐趣qq浏览器:
                case 游戏1758qq浏览器:
                case 牛刀qq浏览器:
                case 火树qq浏览器双开:
                case 游戏1758:
                case 玩蛋qq浏览器双开:
                case 趣头条qq浏览器双开:
                case 趣头条uc浏览器:
                case 趣头条qq浏览器:
                case 火树360浏览器:
                case 趣头条360浏览器:
                case 玩蛋360浏览器:
                case 游戏1758浏览器360:
                case 乐趣360浏览器:
                case 游戏07073浏览器360:
                case 牛刀浏览器360:
                case 火树遨游:
                case 趣头条遨游:
                case 玩蛋遨游:
                case 火树360极速:
                case 趣头条360极速:
                case 玩蛋360极速:
                case 火树uc极速:
                case 趣头条uc极速:
                case 玩蛋uc极速:
                case 火树搜狗:
                case 趣头条搜狗:
                case 玩蛋搜狗:
                    runNames.add("游戏-结束");
                    break;
                case 游戏07073网页:
                case 牛刀网页:
                case 客娱:
                case 核弹头网页:
                    runNames.add("游戏-登录结束");
                    break;
                case 乐趣:
                case 核弹头:
                case 热血单机h5:
                case 牛刀猎豹:
                case 游戏1758猎豹浏览器:
                case 趣头条猎豹:
                case 火树猎豹浏览器:
                case 玩蛋猎豹浏览器:
                    runNames.add("游戏猎豹-结束");
                    break;
//                case 游戏1758:
//                    runNames.add("1758微游戏-结束");
//                    break;
            }

            index++;
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
            case 乐趣双开:
            case 乐趣网页双开:
            case 火树网页双开:
            case 玩蛋双开:
            case 牛刀网页双开:
            case 游戏1758网页双开:
            case 核弹头双开:
            case 热血单机h5双开:
            case 火树qq浏览器:
            case 玩蛋qq浏览器:
            case 乐趣qq浏览器:
            case 游戏1758qq浏览器:
            case 牛刀qq浏览器:
            case 火树qq浏览器双开:
            case 玩蛋qq浏览器双开:
            case 火树猎豹浏览器:
            case 玩蛋猎豹浏览器:
            case 趣头条qq浏览器双开:
            case 趣头条uc浏览器:
            case 趣头条qq浏览器:
            case 火树360浏览器:
            case 趣头条360浏览器:
            case 玩蛋360浏览器:
            case 游戏1758浏览器360:
            case 乐趣360浏览器:
            case 游戏07073浏览器360:
            case 牛刀浏览器360:
            case 游戏1758猎豹浏览器:
            case 趣头条猎豹:
            case 牛刀猎豹:
            case 火树遨游:
            case 趣头条遨游:
            case 玩蛋遨游:
            case 火树360极速:
            case 趣头条360极速:
            case 玩蛋360极速:
                result = true;
                break;
        }

        return result;
    }

    private static boolean isSlowest(ClientType clientType) {
        boolean result = false;
//        switch (clientType) {
//            case 趣头条qq浏览器双开:
//                result = true;
//                break;
//        }
        return result;
    }

    public static String getMiJingBoss(int index) {
        int value = 2;
        switch (actionRun.getModeType()) {
            case NIGHT:
            case TASK:
                value = 2;
                break;
            case DAILY:
                value = 4;
                break;
            case DAILY_TASK:
                value = 3;
                break;
            case SIMPLE:
                value = 5;
                break;
        }
        if (index / value % 2 == 0) {
            return "秘境boss快速sample1";
        } else {
            return "秘境boss快速sample2";
        }
    }

    //王者争霸
    private static boolean isRunKing(ActionRun.ModeType modeType) {
        boolean result = false;
        int week;
        switch (modeType) {
            case NIGHT:
                week = TimeUtil.dateToWeek(TimeUtil.getLastSecondInDay(System.currentTimeMillis()) + 2000);
                result = week != Calendar.MONDAY;
                break;
            case TASK:
                week = TimeUtil.dateToWeek(System.currentTimeMillis());
                result = week != Calendar.MONDAY;
                break;
            case DAILY_TASK:
                week = TimeUtil.dateToWeek(System.currentTimeMillis());
                result = week == Calendar.MONDAY;
                break;
        }
        return result;
    }

    //8转
    private static boolean is8Turn(ClientType clientType) {
        boolean result = false;
        switch (clientType) {
            case 火树:
            case 乐趣网页:
            case 牛刀网页:
            case 玩蛋:
            case 游戏07073网页:
            case 游戏1758网页:
            case 核弹头网页:
            case 热血单机h5:
            case 乐趣:
            case 核弹头:
            case 玩蛋猎豹浏览器:
            case 火树qq浏览器双开:
            case 玩蛋qq浏览器双开:
            case 游戏1758:
            case 牛刀:
            case 凹凸果:
            case 乐趣双开:
            case 乐趣网页双开:
            case 火树网页双开:
            case 玩蛋双开:
            case 牛刀网页双开:
            case 游戏1758网页双开:
            case 核弹头双开:
            case 牛刀qq浏览器:
            case 游戏07073:
            case 热血单机:
            case 火树猎豹浏览器:
            case 热血单机双开:
            case 热血单机h5双开:
            case 火树qq浏览器:
            case 玩蛋qq浏览器:
            case 乐趣qq浏览器:
            case 游戏1758qq浏览器:
            case 趣头条uc浏览器:
                result = true;
                break;
        }
        return result;
    }

    //7转
    private static boolean is7Turn(ClientType clientType) {
        boolean result = false;
        switch (clientType) {
            case 火树360浏览器:
            case 趣头条360浏览器:
            case 玩蛋360浏览器:
            case 游戏1758浏览器360:
            case 乐趣360浏览器:
            case 游戏07073浏览器360:
            case 牛刀浏览器360:
                result = true;
                break;
        }
        return result;
    }

    //转生
    private static boolean isZhuansheng(ActionRun.ModeType modeType) {
        boolean result;
        int week;
        switch (modeType) {
            case NIGHT:
                week = TimeUtil.dateToWeek(TimeUtil.getLastSecondInDay(System.currentTimeMillis()) + 2000);
                break;
            default:
                week = TimeUtil.dateToWeek(System.currentTimeMillis());
                break;
        }
        result = week == Calendar.MONDAY || week == Calendar.WEDNESDAY || week == Calendar.FRIDAY || week == Calendar.SUNDAY;
        return result;
    }
}
