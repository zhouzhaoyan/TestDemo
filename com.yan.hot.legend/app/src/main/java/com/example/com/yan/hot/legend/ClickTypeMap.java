package com.example.com.yan.hot.legend;

import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by on 2018/10/21.
 */
public class ClickTypeMap {

    private static Map<ClickTool.ClientType, String> actionNameMap = new HashMap<>();

    static {
        actionNameMap.put(ClickTool.ClientType.火树,"火树new");
        actionNameMap.put(ClickTool.ClientType.游戏07073网页,"07073游戏盒子-网页");
        actionNameMap.put(ClickTool.ClientType.乐趣网页,"乐趣网页");
        actionNameMap.put(ClickTool.ClientType.核弹头网页,"核弹头网页new");
        actionNameMap.put(ClickTool.ClientType.游戏1758网页,"1758微游戏-网页");
        actionNameMap.put(ClickTool.ClientType.牛刀,"牛刀");
        actionNameMap.put(ClickTool.ClientType.牛刀网页,"牛刀网页");
        actionNameMap.put(ClickTool.ClientType.玩蛋,"玩蛋");
        actionNameMap.put(ClickTool.ClientType.客娱,"客娱");
        actionNameMap.put(ClickTool.ClientType.热血单机,"热血单机-new");
        actionNameMap.put(ClickTool.ClientType.游戏07073,"07073游戏-new");
        actionNameMap.put(ClickTool.ClientType.游戏1758,"1758微游戏");
        actionNameMap.put(ClickTool.ClientType.乐趣,"乐趣-new");
        actionNameMap.put(ClickTool.ClientType.核弹头,"核弹头-new");
        actionNameMap.put(ClickTool.ClientType.热血单机h5,"热血单机h5-new");
        actionNameMap.put(ClickTool.ClientType.热血单机双开,"热血单机双开-new");
        actionNameMap.put(ClickTool.ClientType.凹凸果,"凹凸果");
        actionNameMap.put(ClickTool.ClientType.乐趣双开,"乐趣双开new");
        actionNameMap.put(ClickTool.ClientType.乐趣网页双开,"乐趣网页双开");
        actionNameMap.put(ClickTool.ClientType.火树网页双开,"火树网页双开");
        actionNameMap.put(ClickTool.ClientType.玩蛋双开,"玩蛋双开");
        actionNameMap.put(ClickTool.ClientType.牛刀网页双开,"牛刀网页双开-new");
        actionNameMap.put(ClickTool.ClientType.游戏1758网页双开,"1758网页双开");
        actionNameMap.put(ClickTool.ClientType.核弹头双开,"核弹头双开");
        actionNameMap.put(ClickTool.ClientType.热血单机h5双开,"热血单机h5双开-new");
        actionNameMap.put(ClickTool.ClientType.火树qq浏览器,"火树qq浏览器");
        actionNameMap.put(ClickTool.ClientType.玩蛋qq浏览器,"玩蛋qq浏览器");
        actionNameMap.put(ClickTool.ClientType.乐趣qq浏览器,"乐趣qq浏览器");
        actionNameMap.put(ClickTool.ClientType.游戏1758qq浏览器,"1758qq浏览器");
        actionNameMap.put(ClickTool.ClientType.牛刀qq浏览器,"牛刀qq浏览器");
    }

    public static ClickTool.ClientType getClientType(String actionName) {
        ClickTool.ClientType type = null;
        Iterator<Map.Entry<ClickTool.ClientType, String>> iterator = actionNameMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<ClickTool.ClientType, String> next = iterator.next();
            if (next.getValue().equals(actionName)){
                type = next.getKey();
                break;
            }
        }
        return type;
    }

    public static String getActionName(ClickTool.ClientType clientType){
            return actionNameMap.get(clientType);
    }
}
