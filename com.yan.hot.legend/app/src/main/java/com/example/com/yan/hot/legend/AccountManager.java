package com.example.com.yan.hot.legend;

import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
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
        accountMap.put(ClickTool.ClientType.牛刀qq浏览器, "低调上帝");
        accountMap.put(ClickTool.ClientType.火树qq浏览器双开, "亡灵冥王");
        accountMap.put(ClickTool.ClientType.玩蛋qq浏览器双开, "魂残月");
        accountMap.put(ClickTool.ClientType.火树猎豹浏览器, "恶魔执着");
        accountMap.put(ClickTool.ClientType.玩蛋猎豹浏览器, "战魂巅峰");
        accountMap.put(ClickTool.ClientType.趣头条qq浏览器双开, "时光石头");
        accountMap.put(ClickTool.ClientType.趣头条uc浏览器, "蓝色流星");
        accountMap.put(ClickTool.ClientType.趣头条qq浏览器, "魔神疯子");
        accountMap.put(ClickTool.ClientType.火树360浏览器, "神龙狂人");
        accountMap.put(ClickTool.ClientType.趣头条360浏览器, "无名傻瓜");
        accountMap.put(ClickTool.ClientType.玩蛋360浏览器, "梦魇大帝");
        accountMap.put(ClickTool.ClientType.游戏1758浏览器360, "弑神剑舞");
        accountMap.put(ClickTool.ClientType.乐趣360浏览器, "天外鱼儿");
        accountMap.put(ClickTool.ClientType.游戏07073浏览器360, "无名妖孽");
        accountMap.put(ClickTool.ClientType.牛刀浏览器360, "水流夕阳");
        accountMap.put(ClickTool.ClientType.游戏1758猎豹浏览器, "甲士媚儿");
        accountMap.put(ClickTool.ClientType.趣头条猎豹, "黑夜谎言");
        accountMap.put(ClickTool.ClientType.牛刀猎豹, "蚂蚁清风");
        accountMap.put(ClickTool.ClientType.火树遨游, "寒冰依然");
        accountMap.put(ClickTool.ClientType.趣头条遨游, "雨天百合");
        accountMap.put(ClickTool.ClientType.玩蛋遨游, "天空独行");
        accountMap.put(ClickTool.ClientType.火树360极速, "花香雨落");
        accountMap.put(ClickTool.ClientType.趣头条360极速, "苍穹落叶");
        accountMap.put(ClickTool.ClientType.玩蛋360极速, "风清青春");
    }

    public static String getAccountName(ClickTool.ClientType clientType) {
        return accountMap.get(clientType);
    }
}
