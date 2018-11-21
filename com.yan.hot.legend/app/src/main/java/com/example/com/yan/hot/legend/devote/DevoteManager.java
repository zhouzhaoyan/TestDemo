package com.example.com.yan.hot.legend.devote;


import android.annotation.SuppressLint;

import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by on 2018/9/29.
 */
public class DevoteManager {

    private static Map<ClickTool.ClientType, String> accountMap = new HashMap<>();

    static {
        accountMap.put(ClickTool.ClientType.牛刀, "宿命落花");
        accountMap.put(ClickTool.ClientType.火树, "上官众生");
        accountMap.put(ClickTool.ClientType.乐趣网页, "天地冥王");
        accountMap.put(ClickTool.ClientType.游戏07073网页, "灵魂瞬间");
        accountMap.put(ClickTool.ClientType.核弹头网页, "嗜血无极");
        accountMap.put(ClickTool.ClientType.游戏1758网页, "黑暗地域");
        accountMap.put(ClickTool.ClientType.牛刀网页, "独行杀神");
        accountMap.put(ClickTool.ClientType.玩蛋, "街角魅惑");
        accountMap.put(ClickTool.ClientType.客娱, "沉沦上帝");
        accountMap.put(ClickTool.ClientType.热血单机, "刹那噬魂");
        accountMap.put(ClickTool.ClientType.游戏07073, "习惯扯淡");
        accountMap.put(ClickTool.ClientType.游戏1758, "召唤此生");
        accountMap.put(ClickTool.ClientType.乐趣, "星辰冥界");
        accountMap.put(ClickTool.ClientType.核弹头, "遗忘逝去");
        accountMap.put(ClickTool.ClientType.热血单机h5, "战神指尖");
        accountMap.put(ClickTool.ClientType.乐趣双开, "剑客轮回");
        accountMap.put(ClickTool.ClientType.热血单机双开, "孤魂补丁");
        accountMap.put(ClickTool.ClientType.凹凸果, "星星飘零");
        accountMap.put(ClickTool.ClientType.乐趣网页双开, "传说奈何");
        accountMap.put(ClickTool.ClientType.火树网页双开, "约定杀神");
        accountMap.put(ClickTool.ClientType.玩蛋双开, "战魂幻影");
        accountMap.put(ClickTool.ClientType.牛刀网页双开, "霸气孤星");
        accountMap.put(ClickTool.ClientType.游戏1758网页双开, "神之如初");
        accountMap.put(ClickTool.ClientType.核弹头双开, "杀神花落");
        accountMap.put(ClickTool.ClientType.热血单机h5双开, "亡灵菩提");
        accountMap.put(ClickTool.ClientType.火树qq浏览器, "大漠魔鬼");
        accountMap.put(ClickTool.ClientType.玩蛋qq浏览器, "蜗牛骑士");
        accountMap.put(ClickTool.ClientType.乐趣qq浏览器, "杀手无痕");
        accountMap.put(ClickTool.ClientType.游戏1758qq浏览器, "幽冥绝对");
    }

    public static String getAccountName(ClickTool.ClientType clientType){
        return accountMap.get(clientType);
    }

    @SuppressLint("CheckResult")
    public static void init() {
        Observable.just(1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                List<DevoteObject> list = getDevoteNew(DevoteFile.read());
                if (list != null) {
                    long currentTime = getCurrentTime();
                    for (DevoteObject devoteObject : list) {
                        if (devoteObject.getDate() < currentTime) {
                            devoteObject.setDate(currentTime);
                            devoteObject.setValue(devoteObject.getValue() + devoteObject.getOffset());
                        }
                    }
                    DevoteFile.write(list);
                }
            }
        });
    }

    public static List<DevoteObject> getDevoteNew(List<DevoteObject> devoteObjectsOld){
        List<DevoteObject> defaults = getDefault();
        if (devoteObjectsOld == null || devoteObjectsOld.isEmpty()){
            return defaults;
        }
        List<DevoteObject> devoteObjectsNews = new ArrayList<>(devoteObjectsOld);
        for (DevoteObject devoteObject: defaults) {
            if (!devoteObjectsOld.contains(devoteObject)){
                devoteObjectsNews.add(devoteObject);
            }
        }

        for (DevoteObject devoteObject: defaults) {
            for (DevoteObject devoteObjectNew: devoteObjectsNews){
                if (devoteObjectNew.equals(devoteObject)){
                    devoteObjectNew.setClientType(devoteObject.getClientType());
                    break;
                }
            }
        }
        return devoteObjectsNews;
    }

    public static List<DevoteObject> getDefault() {
        List<DevoteObject> devoteObjects = new ArrayList<>();
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        for (ClickTool.ClientType clientType : clientTypes) {
            devoteObjects.add(new DevoteObject(clientType.name(), getCurrentTime(), 0, 0, clientType));
        }
        return devoteObjects;
    }

    public static void updateTime(DevoteObject devoteObject) {
        devoteObject.setDate(getCurrentTime());
    }

    private static long getCurrentTime() {
        return TimeUtil.getFirstSecondInDay(System.currentTimeMillis());
    }
}
