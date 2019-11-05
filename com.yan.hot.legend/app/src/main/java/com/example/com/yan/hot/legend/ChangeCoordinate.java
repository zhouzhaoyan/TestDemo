package com.example.com.yan.hot.legend;

import android.util.Log;

import com.annimon.stream.function.Predicate;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by on 2018/8/2.
 * 改变坐标
 */
public class ChangeCoordinate {
    private static List<Action> actions = null;

    public static void change(List<Action> actions) {
        ChangeCoordinate.actions = actions;

        //        setCoordinate("熔炼", 1013, 1821, 1013, 2021);
        //        setCoordinate("熔炼", 860, 1811, 856, 2007);
        //        setCoordinate("熔炼", 850, 1548, 851, 1742);
        //        setCoordinateIndex("熔炼", 5, 40, 550, 1674);

        //        setCoordinateIndex("竞技", 6, 7, 1013, 2021);
        //        setCoordinateIndex("竞技", 9, 10, 1013, 2021);
        //        setCoordinate("竞技", 1027, 1081, 971, 1233);
        //        setCoordinateIndex("竞技", 2, 5, 922, 829);
        //        setCoordinate("竞技", 426, 1170, 394, 1203);

        //        setCoordinate("野外boss", 995, 1821, 1013, 2021);
        //        setCoordinate("野外boss", 1053, 1299, 1004,1490);
        //        setCoordinate("野外boss", 904, 606, 864,507);
        //        setCoordinate("野外boss", 917, 888, 844,806);
        //        setCoordinate("野外boss", 886, 1150, 817,1074);
        //        setCoordinate("野外boss", 836, 1415, 801,1378);
        //        addCoordinate("野外boss", new Predicate<Coordinate>() {
        //            @Override
        //            public boolean test(Coordinate value) {
        //                return value.getX() == 1004 &&  value.getY() == 1490;
        //            }
        //        },325, 1843, 1000);

        //        setCoordinate("神域boss", 1053, 1299, 1004,1490);
        //        setCoordinate("神域boss", 743, 1671, 759,1853);
        //        setCoordinate("神域boss", 904, 606, 864,507);
        //        setCoordinate("神域boss", 917, 888, 844,806);
        //        setCoordinate("神域boss", 886, 1150, 817,1074);
        //        setCoordinate("神域boss", 836, 1415, 801,1378);
        //        setCoordinate("神域boss", 1029, 1837, 1013, 2021);

        //        setCoordinateIndex("王者争霸", 1, 3, 1013, 2021);
        //        setCoordinate("王者争霸", 1009, 1065, 971, 1233);
        //        setCoordinate("王者争霸", 338, 1691, 422, 1864);
        //        setCoordinate("王者争霸", 592, 1572, 557,1723);
        //        setCoordinateIndex("王者争霸", 7, 15, 1013, 2021);

        //        setCoordinateIndex("个人boss", 1, 2, 1013, 2021);
        //        setCoordinate("个人boss", 1020, 1327, 1004,1490);
        //        setCoordinate("个人boss", 185, 1679, 185, 1879);
        //        setCoordinate("个人boss", 154, 1678, 154, 1878);
        //        setCoordinate("个人boss", 446, 1561, 426,1726);
        //        setCoordinateIndex("个人boss", 7, 21, 1013, 2021);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);
        //        addCoordinate("个人boss", 7, 426, 1726, 500);

        //        setCoordinateIndex("神兵幻境", 1, 2, 1013, 2021);
        //        setCoordinate("神兵幻境", 719, 595, 717,489);
        //        setCoordinate("神兵幻境", 447, 1686, 428,1866);
        //        setCoordinate("神兵幻境", 610, 1464, 583,1633);
        //        setCoordinateIndex("神兵幻境", 6, 33, 1013, 2021);
        //        setCoordinateIndex("神兵幻境", 21, 21, 375,1449);

        //        setCoordinate("秘境boss", 1015, 1327, 1004,1490);
        //        setCoordinate("秘境boss", 572, 1658, 562,1866);
        //        setCoordinate("秘境boss", 965, 660, 917,443);
        //        setCoordinate("秘境boss", 899, 529, 933,563);
        //        setCoordinate("秘境boss", 471, 1543, 449,1746);
        //        setCoordinate("秘境boss", 734, 1347,  742,1560);
        //        setCoordinate("秘境boss", 1010, 1820,  1013, 2021);

        //        setCoordinate("材料副本", 1023, 1201, 1017,1368);
        //        setCoordinateIndex("材料副本", 3, 5, 1017,1368);
        //        setCoordinateIndex("材料副本", 7, 9, 1013, 2021);
        //        setCoordinateIndex("材料副本", 10, 10, 1017,1368);
        //        setCoordinateIndex("材料副本", 12, 12, 1017,1368);
        //        setCoordinateIndex("材料副本", 14, 14, 1017,1368);
        //        setCoordinateIndex("材料副本", 16, 23, 1013, 2021);
        //        addTime("材料副本",3, 20000);
        //        addTime("材料副本",7, 20000);
        //        addTime("材料副本",12, 20000);
        //        addTime("材料副本",14, 20000);
        //        addTime("材料副本",16, 20000);
        //        setCoordinate("材料副本", 906, 467, 848,352);
        //        setCoordinate("材料副本", 910, 732, 850,607);
        //        setCoordinate("材料副本", 949, 964, 854,874);
        //        setCoordinate("材料副本", 921, 1222, 814,1154);
        //        setCoordinate("材料副本", 919, 1495, 866,1373);

        //        setCoordinateIndex("守护神剑", 1, 3, 1013, 2021);
        //        setCoordinate("守护神剑", 1041, 1192, 1017,1368);
        //        setCoordinate("守护神剑", 348, 1654, 372,1871);
        //        setCoordinate("守护神剑", 497, 1528, 538,1713);
        //        setCoordinate("守护神剑", 574, 1339, 504,1497);
        //        setCoordinate("守护神剑", 385, 1082, 385, 1182);
        //        setCoordinate("守护神剑", 547, 1272, 547, 1372);
        //        setCoordinateIndex("守护神剑", 15, 17, 1013, 2021);
        //        addTime("守护神剑",15,360000);

        //        setCoordinateIndex("特戒副本", 1, 4, 1013, 2021);
        //        setCoordinate("特戒副本", 287, 1838, 266,2012);
        //        setCoordinate("特戒副本", 126, 1557, 127,1726);
        //        setCoordinate("特戒副本", 706, 1685, 642,1871);
        //        setCoordinate("特戒副本", 560, 1496, 503,1677);
        //        setCoordinate("特戒副本", 232, 1084, 151,1143);
        //        setCoordinateIndex("特戒副本", 10, 15, 1013, 2021);

        //        setCoordinateIndex("血战矿洞", 1, 2, 1013, 2021);
        //        setCoordinate("血战矿洞", 1040, 1069, 971, 1233);
        //        setCoordinate("血战矿洞", 576, 1681, 681,1872);
        //        setCoordinate("血战矿洞", 541, 1519, 551,1689);
        //        setCoordinate("血战矿洞", 398, 1358, 369,1394);
        //        setCoordinate("血战矿洞", 979, 1492, 964,1680);
        //        setCoordinate("血战矿洞", 341, 1616, 323,1793);
        //        setCoordinate("血战矿洞", 825, 1596, 798,1776);
        //        setCoordinate("血战矿洞", 691, 1269, 711,1298);
        //        setCoordinate("血战矿洞", 75, 1600, 81,1806);
        //        setCoordinate("血战矿洞", 1019, 1822, 1013, 2021);
        //        setCoordinate("血战矿洞", 996, 1813, 1013, 2021);
        //        addCoordinateTop("血战矿洞",811,894, 2000);
        //        addCoordinate("血战矿洞", 9, 1013, 2021,2000);

        //        setCoordinateIndex("经验副本", 1, 4, 1013, 2021);
        //        setCoordinate("经验副本", 1016, 1188, 1017,1368);
        //        setCoordinate("经验副本", 349, 1661, 415,1851);
        //        setCoordinate("经验副本", 352, 1662, 415,1851);
        //        setCoordinate("经验副本", 212, 1510, 277,1733);
        //        setCoordinate("经验副本", 530, 1310, 563,1526);
        //        setCoordinate("经验副本", 214, 1011, 210,1054);
        //        setCoordinateIndex("经验副本", 11, 13, 1013, 2021);


        //        setCoordinate("自动关卡", 1008, 1842, 1013, 2021);
        //        setCoordinate("自动关卡", 986, 1482, 986, 1682);
        //        setCoordinate("自动关卡", 541, 1423, 1013, 1523);
        //        setCoordinate("自动关卡", 1013, 1523, 541, 1523);


        //        setCoordinateIndex("转生", 1, 2, 1013, 2021);
        //        setCoordinate("转生", 298, 1832, 266,2012);
        //        setCoordinateIndex("转生", 4, 6, 683,1851);
        //        setCoordinate("转生", 854, 1557, 854,1749);
        //        setCoordinateIndex("转生", 8, 11, 843,889);
        //        setCoordinateIndex("转生", 12, 19, 1013, 2021);


        //        delete("07073游戏盒子-开始", 6);

        //        delete("07073游戏盒子-结束", 1);
        //        setCoordinateIndex("07073游戏盒子-结束", 0, 0, 779, 2212);
        //        addCoordinateEndRepeate("07073游戏盒子-结束", 779, 2212, 1000, 12);
        //        addCoordinateEnd("07073游戏盒子-结束", 708,1200, 1000);
        //        addCoordinateEndRepeate("07073游戏盒子-结束", 779, 2212, 1000, 3);
        //        setCoordinate("07073游戏盒子-结束", 708,1200, 547,2208);

        //        addTime("07073游戏盒子", 2,15000);
        //        addTime("07073游戏盒子", 4,10000);
        //        addTime("07073游戏盒子", 5,10000);

        //        delete("火树", 7);
        //        addTime("火树", 1,3000);
        //        addTime("火树", 4,5000);
        //        addTime("火树", 6,19000);
        //        setCoordinate("火树",586, 1184,561, 1369);
        //        deletePostion("火树", 5);
        //        addTime("火树", 5,20000);
        //        addTime("火树", 4,10000);

        //        deletePostion("火树-结束", 0);
        //        delete("游戏-结束", 1);
        //        addCoordinateEndRepeate("游戏-结束",794, 2210, 300,15);

        //        addNew("火树", "乐趣");
        //        setCoordinate("乐趣",858, 332,680, 687);
        //        addTime("乐趣", 4,10000);

        //        delete("核弹头", 4);
        //        addTime("核弹头", 2,5000);
        //        addTime("核弹头", 3,5000);
        //        addTime("核弹头", 4,5000);
        //        addCoordinateEnd("核弹头",561, 1369,20000);

        //        setCoordinate("血战矿洞-收取",88, 2019,95,1798);
        //        deletePostion("血战矿洞-收取",7);

        //        delete("1758微游戏", 9);
        //        addTime("1758微游戏", 2,10000);
        //        addTime("1758微游戏", 4,20000);
        //        addTime("1758微游戏", 8,20000);
        //        addCoordinate("1758微游戏", 6, 937,372, 4000);
        //        addTime("1758微游戏",2,5000);
        //        setCoordinateIndex("1758微游戏",5,5,470, 1852);
        //        deletePostion("1758微游戏", 7);
        //        addCoordinate("1758微游戏", 3,907, 2051,2000);
        //        addNew("游戏-结束","1758微游戏-结束");
        //        addCoordinate("1758微游戏-结束", 3,377,1170,1000);

        //        delete("牛刀", 5);
        //        addCoordinate("牛刀", 2, 990,198, 20000);
        //        addCoordinate("牛刀", 3, 772,1202, 5000);
        //        addCoordinate("牛刀", 4, 632, 1434, 5000);
        //        addTime("牛刀", 6, 20000);
        //        addTime("牛刀", 7, 15000);
        //        addTime("牛刀", 5, 5000);
        //        addTime("牛刀", 2, 10000);

        //        deletePostion("通天塔",0);
        //        deletePostion("通天塔",0);
        //        setCoordinate("通天塔",571, 1563,547, 1579);
        //        addCoordinate("通天塔",12,547, 1579, 1000);
        //        addCoordinate("通天塔",12,547, 1579, 1000);
        //        delete("通天塔", 19);
        //        addTime("通天塔", 15, 10000);

        //        delete("牛刀网页", 19);
        //        addTime("牛刀网页",17, 10000);
        //        addTime("牛刀网页",18, 30000);
        //        addTime("牛刀网页",4,10000);
        //        setCoordinate("牛刀网页",545, 746, 545, 800);

        //        addNew("火树", "玩蛋");
        //        setCoordinate("玩蛋",858, 332,809, 996);

        //        addNew("牛刀网页", "客娱");
        //        setCoordinate("客娱",663, 822,711, 1159);
        //        setCoordinate("客娱",540, 1366,528,1541);

        //        String[] names = new String[]{"火树","07073游戏盒子","乐趣","核弹头","1758微游戏","牛刀","牛刀网页","玩蛋","客娱"};
        //        for (String name: names) {
        //            addTime(name, getSize(name)-1, 10000);
        //            addTime(name, getSize(name)-2, 20000);
        //        }
        //        addTime("1758微游戏", getSize("1758微游戏")-2, 10000);

        //        addNew("秘境boss", "秘境boss快速");
        //        delete("秘境boss快速",17);
        //        addCoordinate("秘境boss快速", new Predicate<Coordinate>() {
        //            @Override
        //            public boolean test(Coordinate value) {
        //                return value.getX() == 1013 && value.getY() ==2021;
        //            }
        //        },81,1824, 5000);
        //        addCoordinateEndRepeate("秘境boss快速",1013, 2021,1000,3);
        //        addTime("秘境boss快速", 10, 70000);

        //                addNew("火树", "07073游戏盒子-网页");
        //                        setCoordinate("07073游戏盒子-网页",858, 332,542,1321);
        //
        //                addNew("火树", "1758微游戏-网页");
        //                        setCoordinate("1758微游戏-网页",858, 332,530,1510);

        //        addTime("热血单机", 2,30000);
        //        addTime("热血单机", 3,20000);
        //        addTime("热血单机", 4,40000);
        //        delete("热血单机",5);

        //        addTime("核弹头网页", getSize("核弹头网页")-1, 20000);
        //        addTime("熔炼", 3, 2000);
        //        addTime("熔炼", 4, 4000);

        //        addNew("材料副本","材料副本快速");

        //        deletePostions("材料副本快速", 3, 4, 5, 7, 8, 9, 10, 12, 14);
        //        delete("材料副本快速", 10);
        //        addCoordinate("材料副本快速", new Predicate<Coordinate>() {
        //            @Override
        //            public boolean test(Coordinate value) {
        //                return isSame(value,848, 352)
        //                        || isSame(value,850, 607)
        //                        || isSame(value,854, 874)
        //                        || isSame(value,814, 1154);
        //            }
        //        }, 1017, 1368, 3000);
        //        addTime("材料副本快速", new Predicate<Coordinate>() {
        //            @Override
        //            public boolean test(Coordinate value) {
        //                return isSame(value,850, 607)
        //                        || isSame(value,854, 874)
        //                        || isSame(value,814, 1154)
        //                        || isSame(value,866, 1373);
        //            }
        //        }, -20000);
        //        addTime("材料副本快速", 11, -22000);

        //        deletePostion("竞技",8);
        //        addCoordinate("竞技",6, 922, 829, 35000);
        //        addCoordinate("竞技",7, 922, 829, 35000);

        //        setTime("材料副本", 3, 35000);
        //        setTime("材料副本", 4, 35000);
        //        setTime("材料副本", 5, 35000);
        //        setTime("材料副本", 6, 35000);
        //        setTime("材料副本", 7, 35000);

        //        delete("王者争霸",10);
        //        addCoordinate("王者争霸",6,422, 1864,2000);
        //        setTime("王者争霸",8,20000);
        //        setTime("王者争霸",9,2000);
        //        setTime("王者争霸",10,2000);
        //        for (int i = 0; i < 60; i++) {
        //            addCoordinate("王者争霸",8+i*2,511, 1534,1000);
        //            addCoordinate("王者争霸",9+i*2,557, 1723,1000);
        //        }

//        delete("个人boss", 18);
//        for (int i = 0; i <= 7; i++) {
//            deletePostion("个人boss", 7);
//        }
//        setTime("个人boss",7,30000);
//
//        for (int i = 0; i < 120; i++) {
//            addCoordinate("个人boss",7,426, 1726,1000);
//        }

//        delete("转生",16);
//        addCoordinate("转生",12,843, 889,2000);

//        addTime("经验副本",10,10000);

//        setCoordinateIndex("秘境boss快速",8,8,81, 1824);
//        setCoordinateIndex("秘境boss快速",9,9,1013, 2021);
//        setCoordinateIndex("秘境boss快速",17,17,81, 1824);
//        setCoordinateIndex("秘境boss快速",18,18,1013, 2021);
//        addTime("秘境boss快速",8, 4000);
//        addTime("秘境boss快速",9, -4000);
//        addTime("秘境boss快速",17, 4000);
//        addTime("秘境boss快速",18, -4000);

//        setCoordinate("竞技",922, 829,845 ,843);
//        deletePostions("1758微游戏",5,6,7);

//        setCoordinate("乐趣",93, 2055,118, 2058);
//        addTime("乐趣",2,30000);
//        addTime("乐趣",6,40000);
//        addTime("乐趣",7,40000);
//        addTime("乐趣",5,40000);
//        delete("乐趣",7);

//        addNew("火树", "核弹头网页");
//        setCoordinate("核弹头网页",858, 332,216,1639);

//        addTime("1758微游戏", getSize("1758微游戏")-2, 10000);
//        addTime("07073游戏盒子", getSize("07073游戏盒子")-2, 10000);

//        setCoordinateIndexOffset("07073游戏盒子",1,1,0, -202);
//        setCoordinateIndexOffset("乐趣",1,1,0, -202);
//        setCoordinateIndexOffset("核弹头",1,1,0, -202);
//
//        setCoordinateIndexOffset("1758微游戏",1,1,0, -183);
//        setCoordinateIndexOffset("牛刀",1,1,0, -183);
//        setCoordinateIndexOffset("热血单机",1,1,0, -183);

//        deletePostions("竞技",3,4,5,6,7,8);
//        setTime("竞技",3,35000);
//        for (int i = 3; i < 120; i++) {
//            addCoordinate("竞技",i,845, 843,1000);
//        }

//        delete("热血单机h5",3);
//        addCoordinate("热血单机h5",3,526, 1526, 60000);
//        addTime("热血单机h5",2,30000);

//        deletePostions("熔炼",41);
//        for (int i = 6; i < 41; i++) {
//            setTime("熔炼",i,500);
//        }

//        delete("野外boss",1);
//        for (int i = 0; i < 15*4; i++) {
//            addCoordinateEnd("野外boss",1004, 1490,1000);
//            addCoordinateEnd("野外boss",325, 1843,1000);
//            addCoordinateEnd("野外boss",864, 507,1000);
//            addCoordinateEnd("野外boss",1013, 2021,1000);
//        }

//        addTime("核弹头",2,10000);
//        setCoordinateIndex("竞技",120,120,410,1216);

//        addNew("热血单机","热血单机双开");
//        setCoordinate("热血单机双开",830, 1008,541,1330);

//        delete("凹凸果",5);
//        addTime("凹凸果",4,30000);
//        addCoordinateEnd("凹凸果",526, 1526,60000);

//        setCoordinate("血战矿洞",681, 1872,519,1869);

//        addCoordinate("核弹头",3,288,416,2000);
//        setCoordinate("核弹头",948, 322,935,2026);
//        setCoordinate("核弹头",288,416,935,2026);
//        addCoordinate("核弹头",4,934,854,10000);

//        deletePostions("07073游戏盒子",2);

//        addNew("客娱","核弹头网页new");

//        setCoordinate("核弹头网页new",711, 1159,375,1643);

//        addNew("野外boss","野外boss快速");
//        delete("野外boss快速",1);
//        for (int i = 0; i < 15*3; i++) {
//            addCoordinateEnd("野外boss快速",1004, 1490,1000);
//            addCoordinateEnd("野外boss快速",325, 1843,1000);
//            addCoordinateEnd("野外boss快速",864, 507,1000);
//            addCoordinateEnd("野外boss快速",1013, 2021,1000);
//        }
//
//        addNew("秘境boss快速","秘境boss快速sample");
//        setTime("秘境boss快速sample",10,2000);

//        addCoordinateEnd("1758微游戏",128, 538,40000);
//        addCoordinateEnd("1758微游戏",569, 1817,50000);
//        addCoordinateEnd("1758微游戏",561, 1369,40000);

//        addTime("核弹头网页new",5,5000);

//        addNew("乐趣","乐趣双开");
//        setCoordinateIndex("乐趣双开",0,0,666,855);
//        setCoordinateIndex("乐趣双开",1,1,291,1033);

//        setCoordinate("乐趣双开",291, 1033,251,794);

//        delete("乐趣网页双开",4);
//        setTime("乐趣网页双开",1,5000);
//        setTime("乐趣网页双开",2,50000);
//        setTime("乐趣网页双开",3,60000);

//        addNew("乐趣网页双开", "火树网页双开");
//        setCoordinate("火树网页双开",547, 805,799,792);


//        deletePostion("材料副本",6);

//        addNew("竞技","竞技new");
//        delete("竞技new",2);
//        for (int i = 0; i < 70; i++) {
//            addCoordinateEnd("竞技new",845, 843,1000);
//            addCoordinateEnd("竞技new",971, 1233,1000);
//        }
//        addCoordinateEnd("竞技new",845, 843,1000);
//        addCoordinateEnd("竞技new",410, 1216,15000);
//        addCoordinateEnd("竞技new",1013, 2021,1000);
//        addCoordinateEnd("竞技new",1013, 2021,1000);

//        addNew("熔炼","熔炼new");
//        setCoordinateIndex("熔炼new", 4,4,924,1734);
//        delete("熔炼new", 6);
//        for (int i = 0; i < 60; i++) {
//            addCoordinateEnd("熔炼new", 550, 1674,300);
//        }
//        addCoordinateEnd("熔炼new",1013, 2021,1000);
//        addCoordinateEnd("熔炼new",1013, 2021,1000);

//        addNew("野外boss快速","野外boss快速end");
//        delete("野外boss快速end",getSize("野外boss快速end") - 20);
//        addCoordinateEnd("野外boss快速end",1004, 1490,20000);
//        addCoordinateEnd("野外boss快速end",1013, 2021,1000);
//        addCoordinateEnd("野外boss快速end",1013, 2021,1000);

//        delete("个人boss",101);
//        addCoordinateEnd("个人boss",1013, 2021,34000);
//        addCoordinateEnd("个人boss",1013, 2021,1000);
//        addCoordinateEnd("个人boss",1013, 2021,1000);

//        String[] names = new String[]{
//                "火树","乐趣网页","牛刀网页","玩蛋","客娱","07073游戏盒子-网页","1758微游戏-网页","核弹头网页new"
//        };
//        for (String name: names) {
//            setTime(name,1,8000);
//        }

//        addNew("火树网页双开","玩蛋双开");
//        setCoordinateIndex("玩蛋双开",1,1,292,1056);
//        setTime("牛刀",3,5000);
//        setTime("牛刀",4,5000);
//        setCoordinate("牛刀",990, 198,983,151);
//        addCoordinate("牛刀",3,983,151,5000);
//        setCoordinateIndex("牛刀",3,3,772, 1202);

//        addNew("自动关卡", "自动关卡sample");
//        int size = getSize("自动关卡");
//        delete("自动关卡sample",size-1-180);
//        addCoordinateEnd("自动关卡sample",1013, 2021,30000);

//        addNew("牛刀网页", "牛刀网页双开");
//        setCoordinateIndex("牛刀网页双开",0,0,666,855);
//        setCoordinateIndex("牛刀网页双开",1,1,550,1033);
//        deletePostions("牛刀网页双开",2,3);

//        deletePostions("牛刀网页双开",3,4,5,6,7,8,9,10,11,12,13);

//        addNew("乐趣网页双开", "1758网页双开");
//        setCoordinate("1758网页双开",547, 805,789,1049);

//        addNew("核弹头","核弹头双开");
//        setCoordinateIndex("核弹头双开",0,0,701,796);
//        setCoordinateIndex("核弹头双开",1,1,275,1305);

//        String[] names = new String[]{"07073游戏盒子-网页","07073游戏盒子","热血单机h5"};
//        for (String tmp : names) {
//            setCoordinateIndex(tmp, getSize(tmp) - 2, getSize(tmp) - 2,587, 1811);
//            setCoordinateIndex(tmp, getSize(tmp) - 1, getSize(tmp) - 1,561, 1369);
//        }

//        addNew("热血单机h5","07073插件");
//        delete("07073插件",1);
//        addCoordinateEnd("07073插件",739, 2064,500);

//        addNew("野外boss快速end","野外boss快速sample");
//        delete("野外boss快速sample",getSize("野外boss快速sample") - 34);
//        addCoordinateEnd("野外boss快速sample",1004, 1490,20000);
//        addCoordinateEnd("野外boss快速sample",1013, 2021,1000);
//        addCoordinateEnd("野外boss快速sample",1013, 2021,1000);

//        int size = getSize("个人boss");
//        delete("个人boss",size -1 - 16);
//        addCoordinateEnd("个人boss",1013, 2021,30000);
//        addCoordinateEnd("个人boss",1013, 2021,1000);
//        addCoordinateEnd("个人boss",1013, 2021,1000);
//        setCoordinateIndex("07073插件",0,0, 547,1695);
//        delete("07073插件",1);

//        deletePostion("牛刀new",2);
//        deletePostion("牛刀new",3);
//        setCoordinate("牛刀new",143, 1879,134,1823);
//        setCoordinate("牛刀new",158, 1859,134,1823);
//        delete("牛刀new",getSize("牛刀new")-7);
//        addTimeAll("牛刀new",2000);
//        addTime("牛刀new",2,7000);
//        addTime("牛刀new",8,5000);
//        addTime("牛刀new",9,30000);
//        addTime("牛刀new",10,30000);

//        deletePostions("牛刀网页双开new",6,7);
//        for (int i = 0; i < 6; i++) {
//            addCoordinate("牛刀网页双开new",6,134, 1823,1000);
//        }

//        setCoordinateIndex("牛刀网页双开new",2,2,986,220);
//        addTime("牛刀网页双开new",2,5);


//        addTime("核弹头网页new",4,10000);
//        setCoordinate("核弹头网页new",232,547,123,624);
//        deletePostion("核弹头网页new",16);
//        addCoordinate("核弹头网页new",17,760,2016,3000);
//        addCoordinate("核弹头网页new",18,511,1455,5000);

//        addNew("热血单机h5","热血单机h5双开");
//
//        setCoordinateIndex("热血单机h5双开",0,0,695,806);
//        setCoordinateIndex("热血单机h5双开",1, 1,550,1313);
//        addNew("游戏-结束", "游戏-登录结束");
//        addCoordinateEnd("游戏-登录结束",666 ,2018,3000);
//        addCoordinateEnd("游戏-登录结束",794, 2210,3000);
//        addCoordinateEndRepeate("游戏-登录结束",794, 2210,500,4);

//        addTime("牛刀网页",4,10000);
//        setCoordinate("牛刀网页",232,547,123,624);
//        addCoordinate("牛刀网页",17,760,2016,3000);
//        addCoordinate("牛刀网页",18,511,1455,5000);

//        addTime("客娱",4,10000);
//        setCoordinate("客娱",232,547,123,624);
//        addCoordinate("客娱",17,760,2016,3000);
//        addCoordinate("客娱",18,511,1455,5000);

//        addCoordinateEndRepeate("游戏-登录结束",794, 2210,500,4);
//
//        addCoordinate("牛刀网页双开",4,557,1455,5000);

//        delete("牛刀网页双开new",29);
//        deletePostion("牛刀网页双开new",0);
//        addTime("牛刀网页双开new",1,10000);
//        addTime("牛刀网页双开new",2,20000);
//        addTime("牛刀网页双开new",4,10000);
//        addTime("牛刀网页双开new",26,40000);
//        addTime("牛刀网页双开new",27,50000);
//        setCoordinate("牛刀网页双开new",497, 1640,599 ,1668);
//        deletePostion("牛刀网页双开new",24);

//        addCoordinate("牛刀网页双开new",19,472,1496,1000);

//        addNew("牛刀网页双开new","热血单机双开new");
//        setCoordinateIndex("热血单机双开new",0,0,420,821);
//        setCoordinateIndex("热血单机双开new",1,1,509,1346);
//        setCoordinateIndex("热血单机双开new",2,2,502,1528);

//        addCoordinate("热血单机双开new",2,543,1413,15000);
//        addTime("热血单机双开new",3,-10000);

//        deletePostion("核弹头-new",25);
//        delete("核弹头-new",28);
//        setCoordinate("核弹头-new",496, 1666,599 ,1668);
//        addCoordinate("核弹头-new",20,472,1496,1000);
//
//        addTime("核弹头-new",1,10000);
//        addTime("核弹头-new",2,20000);
//        addTime("核弹头-new",4,10000);
//        addTime("核弹头-new",27,40000);
//        addTime("核弹头-new",28,50000);

//        addTime("核弹头-new",1,-20000);
//        addTime("核弹头-new",2,-40000);
//        addTime("核弹头-new",4,-20000);
//        addTime("核弹头-new",27,-80000);
//        addTime("核弹头-new",28,-100000);
//
//        deletePostions("核弹头-new",21,22);
//        addCoordinate("核弹头-new",24,384, 1532,1000);
//        addCoordinate("核弹头-new",24,384, 1532,1000);

//        delete("07073游戏-new",28);
//        setCoordinate("07073游戏-new",708, 1524,472,1496);

//        setCoordinate("07073游戏-new",617, 1679,497, 1640);
//        addCoordinate("07073游戏-new",19,472,1496,1000);
//        deletePostion("07073游戏-new",24);

//        setCoordinate("07073游戏-new",472, 1496,401, 1515);
//        setCoordinate("07073游戏-new",502, 1528,580, 1655);

//        setCoordinate("07073游戏-new",401, 1515,491, 1530);
//        setCoordinateIndex("07073游戏-new",23,24,401, 1515);

//        setCoordinate("07073游戏-new",544, 1834,587, 1811);
//        setCoordinate("07073游戏-new",565, 1706,537,1654);

//        addTime("07073游戏-new",1,10000);
//        addTime("07073游戏-new",2,20000);
//        addTime("07073游戏-new",4,10000);
//        addTime("07073游戏-new",26,40000);
//        addTime("07073游戏-new",27,50000);

//        addNew("07073游戏-登录","07073游戏-new");
//        deletePostionsIndex("07073游戏-new",2,25);
//        addTime("07073游戏-new",1,-8000);
//        addTime("07073游戏-new",2,-80000);

//        setCoordinateIndex("热血单机h5-new",1,1,301, 1349);

//        addCoordinate("07073游戏-new",2,939,2034,20000);
//        addCoordinate("07073游戏-new",3,929 ,385,5000);
//        addTime("07073游戏-new",4,-15000);

//        setCoordinateIndex("07073游戏-new",5,5,466,
//                1240
//        );

//        addCoordinate("07073游戏-new",28,125,
//                545,15000
//        );

//        delete("核弹头双开-new",30);

//        addCoordinate("核弹头双开-new",27,609,
//                1514,1000
//        );

//            addTime("核弹头双开-new",1,10000);
//            addTime("核弹头双开-new",2,20000);
//            addTime("核弹头双开-new",4,10000);
//            addTime("核弹头双开-new",29,30000);
//            addTime("核弹头双开-new",30,40000);

//        delete("热血单机h5-new",6);
//        setCoordinate("热血单机h5-new",89, 362,252, 818);

//        deletePostions("热血单机h5-new",0,1);
//        setCoordinate("热血单机h5-new",279, 1038,252, 818);
        //        addCoordinate("热血单机h5-new",0,897,767);

//        delete("热血单机h5-new",3);
//        setCoordinate("热血单机h5-new",546, 1806,587,1811);
//        addCoordinateEnd("热血单机h5-new",544, 1573,50000);
//        setTime("热血单机h5-new",1,3000);
//        setTime("热血单机h5-new",2,40000);

//        delete("热血单机双开-new",5);
//        setTime("热血单机双开-new",1,3000);
//        setTime("热血单机双开-new",2,15000);
//        setTime("热血单机双开-new",3,40000);
//        setTime("热血单机双开-new",4,50000);

//        delete("热血单机-new",8);
//        setTime("热血单机-new",1,3000);
//        setTime("热血单机-new",2,10000);
//        setTime("热血单机-new",3,3000);
//        setTime("热血单机-new",4,3000);
//        setTime("热血单机-new",5,10000);
//        setTime("热血单机-new",6,40000);
//        setTime("热血单机-new",7,50000);

//        delete("07073游戏-new",7);
//        setTime("07073游戏-new",1,3000);
//        setTime("07073游戏-new",2,10000);
//        setTime("07073游戏-new",3,3000);
//        setTime("07073游戏-new",4,3000);
//        setTime("07073游戏-new",5,40000);
//        setTime("07073游戏-new",6,50000);

//        delete("核弹头双开-new",7);
//        setTime("核弹头双开-new",1,3000);
//        setTime("核弹头双开-new",2,10000);
//        setTime("核弹头双开-new",3,3000);
//        setTime("核弹头双开-new",4,3000);
//        setTime("核弹头双开-new",5,40000);
//        setTime("核弹头双开-new",6,50000);

//        delete("热血单机h5双开-new",4);
//        setTime("热血单机h5双开-new",1,3000);
//        setTime("热血单机h5双开-new",2,40000);
//        setTime("热血单机h5双开-new",3,50000);

//        setCoordinate("核弹头双开-new",559, 1053,816,
//                1049
//        );

//        delete("热血单机双开-new",8);
//        deletePostion("热血单机双开-new",5);
//        setTime("热血单机双开-new",1,3000);
//        setTime("热血单机双开-new",2,10000);
//        setTime("热血单机双开-new",3,5000);
//        setTime("热血单机双开-new",4,5000);
//        setTime("热血单机双开-new",5,40000);
//        setTime("热血单机双开-new",6,50000);

//        setTime("核弹头-new",5,15000);

//        setCoordinate("通天塔",1021,1996,1013, 2021);
//        deletePostions("通天塔",0,1,2);
//        setCoordinateIndex("通天塔",12,getSize("通天塔")-1,1013, 2021);

//        setCoordinate("熔炼new",924, 1734,966, 1734);

//        deletePostionsIndex("核弹头网页new",5,15);
//        setTime("核弹头网页new",1,10000);
//        setTime("核弹头网页new",2,3000);
//        setTime("核弹头网页new",3,3000);
//        setTime("核弹头网页new",4,30000);
//        setTime("核弹头网页new",5,20000);
//        setTime("核弹头网页new",6,3000);
//        setTime("核弹头网页new",7,5000);
//        setTime("核弹头网页new",8,40000);
//        setTime("核弹头网页new",9,50000);

//        deletePostionsIndex("牛刀网页",5,15);
//        setTime("牛刀网页",1,10000);
//        setTime("牛刀网页",2,3000);
//        setTime("牛刀网页",3,3000);
//        setTime("牛刀网页",4,30000);
//        setTime("牛刀网页",5,20000);
//        setTime("牛刀网页",6,3000);
//        setTime("牛刀网页",7,5000);
//        setTime("牛刀网页",8,40000);
//        setTime("牛刀网页",9,50000);

//        deletePostionsIndex("客娱",5,15);
//        setTime("客娱",1,10000);
//        setTime("客娱",2,3000);
//        setTime("客娱",3,3000);
//        setTime("客娱",4,30000);
//        setTime("客娱",5,20000);
//        setTime("客娱",6,3000);
//        setTime("客娱",7,5000);
//        setTime("客娱",8,40000);
//        setTime("客娱",9,50000);

//        deletePostionsIndex("牛刀网页双开-new",4,24);
//        setCoordinate("牛刀网页双开-new",543, 883,942,1161);
//        setTime("牛刀网页双开-new",1,3000);
//        setTime("牛刀网页双开-new",2,15000);
//        setTime("牛刀网页双开-new",3,10000);
//        setTime("牛刀网页双开-new",4,5000);
//        setTime("牛刀网页双开-new",5,40000);
//        setTime("牛刀网页双开-new",6,50000);

//        setCoordinateIndex("07073插件",0,0,964,869);

//        setCoordinate("热血单机h5双开-new",639, 1829,587,1811);
//        delete("桌面纠错插件",1);
//        addCoordinateEndRepeate("桌面纠错插件",773 ,2219,500,6);

//        setCoordinate("热血单机h5-new",576,1813,587,1811);
//        setTime("热血单机双开-new",2,30000);

//        addNew("个人boss","个人boss快速");
//        deletePostions("个人boss快速",0,1,2,3);
//        deletePostionsIndex("个人boss快速",29,82);
//        setTime("个人boss快速",29,30000);

//        delete("个人boss快速");
//        addNew("个人boss","个人boss快速");
//        deletePostionsIndex("个人boss快速",14,87);
//        addCoordinateEnd("个人boss快速",1013, 2021,1000);
//        setTime("个人boss快速",14,1000);

//        delete("火树qq浏览器");
//        addNew("07073游戏-new","火树qq浏览器");
//        setCoordinateIndex("火树qq浏览器",1,1,824,1006);
//
//        delete("玩蛋qq浏览器");
//        addNew("07073游戏-new","玩蛋qq浏览器");
//        setCoordinateIndex("玩蛋qq浏览器",1,1,222,1313);
//
//        delete("乐趣qq浏览器");
//        addNew("07073游戏-new","乐趣qq浏览器");
//        setCoordinateIndex("乐趣qq浏览器",1,1,556,1309);

//        addCoordinateEnd("07073插件",514,
//                1608,3000);

//        addNew("竞技new", "竞技sample");
//        deletePostionsIndex("竞技sample",101,140);
//        setTime("竞技sample",101,1000);
//        setTime("竞技sample",103,30000);
//        setCoordinate("核弹头网页new",545, 800,566,1244);

//        setCoordinate("牛刀网页",545, 800,566,1244);
//        deletePostionsIndex("07073qq插件",0,2);
//        deletePostionsIndex("07073qq插件",3,7);
//        setCoordinateIndex("07073qq插件",2,2,942,1161);

//        setTime("07073qq插件",1,5000);
//        setTime("07073qq插件",2,5000);
//        deletePostions("核弹头qq插件",0,1);
//        delete("核弹头qq插件",4);
//        setTime("核弹头qq插件",1,10000);
//        setTime("核弹头qq插件",2,10000);
//        setTime("核弹头qq插件",3,10000);
//        setCoordinateIndex("核弹头qq插件",3,3,942,1161);

//        setCoordinate("热血单机-new",583, 1806,587,1811);
//        setCoordinate("核弹头-new",570, 1832,587,1811);

//        addCoordinate("07073qq插件",1,713,1249,5000);
//        setTime("07073qq插件",1,10000);
//        setTime("07073qq插件",2,10000);
//        setTime("07073qq插件",3,10000);

//        addCoordinate("07073qq插件",2,760, 2016,2000);
//        setCoordinateIndex("牛刀网页双开-new",3,3,682,1195);

//        setCoordinate("核弹头-new",569, 1301,607,1249);
//        addCoordinate("07073qq插件",2,760, 2016,2000);
//        addCoordinate("核弹头qq插件",3,804, 957,10000);

//        addNew("竞技new", "竞技sample");
//        deletePostionsIndex("竞技sample",119,142);
//        setTime("竞技sample",119,30000);
//        setCoordinate("竞技sample",875, 976,845, 843);
//        setTime("竞技sample",1,1000);

//        addNew("07073游戏-new","1758qq浏览器");
//        setCoordinateIndex("1758qq浏览器",1,1,785,1335);

//        addNew("牛刀网页双开-new","牛刀qq浏览器");
//        setCoordinate("牛刀qq浏览器",562, 1056,548,1356);
//        setCoordinate("牛刀qq浏览器",682, 1195,554,934);

//        delete("核弹头手机登录插件",getSize("核弹头手机登录插件") - 4);
//        deletePostions("核弹头手机登录插件",0,1);
//        setCoordinateIndex("核弹头双开",2,2,936, 2026);
//        addCoordinate("核弹头手机登录插件",17,493, 1512,1000);
//        setTime("核弹头手机登录插件",1,4000);
//        for (int i = 2; i <= 12; i++) {
//            setTime("核弹头手机登录插件",i,1000);
//        }
//        setTime("核弹头手机登录插件",13,2000);
//        for (int i = 14; i <= 22; i++) {
//            setTime("核弹头手机登录插件",i,1000);
//        }
//        setTime("核弹头手机登录插件",23,2000);
//        setTime("核弹头手机登录插件",24,10000);
//        setTime("核弹头手机登录插件",25,2000);
//        setTime("核弹头手机登录插件",26,2000);
//        setCoordinateIndex("核弹头手机登录插件",24, 26,959, 2067);

//        setCoordinate("王者争霸",971, 1233,895,1276);

//        delete("牛刀qq浏览器刷新插件",4);
//        deletePostionsIndex("牛刀qq浏览器刷新插件",0,1);
//        setTime("牛刀qq浏览器刷新插件",1,4000);
//        setCoordinate("牛刀qq浏览器",530,1818,587, 1811);

//        setCoordinate("野外boss快速sample",1004, 1490,900,1520);
//        setCoordinate("秘境boss快速sample",1004, 1490,900,1520);
//        setCoordinate("个人boss",1004, 1490,900,1520);
//        setCoordinate("个人boss快速",1004, 1490,900,1520);
//        setCoordinate("材料副本快速",1017, 1368,879,1388);
//        setCoordinate("材料副本",1017, 1368,879,1388);
//        setCoordinate("经验副本",1017, 1368,879,1388);
//        setCoordinate("通天塔",1041, 1377,879,1388);

//        deletePostionsIndex("乐趣new",11,18);
//        setCoordinateIndex("乐趣new",7,7,942,1161);
//        deletePostion("乐趣new",8);
//        setTime("乐趣new",1,5000);
//        setTime("乐趣new",2,10000);
//        setTime("乐趣new",3,5000);
//        setTime("乐趣new",4,5000);
//        setTime("乐趣new",5,15000);
//        setTime("乐趣new",6,5000);
//        setTime("乐趣new",7,5000);
//        setTime("乐趣new",8,40000);
//        setTime("乐趣new",9,40000);

//        setTime("核弹头-new",2,15000);
//        setTime("热血单机h5-new",2,15000);
//        setTime("乐趣new",2,15000);

//        addCoordinateEndRepeate("游戏-结束",794, 2210,300,6);

//        addCoordinate("热血单机-new",2,478, 1410,20000);

//        setCoordinate("核弹头手机登录插件",202, 1950,202, 1872);
//        setCoordinate("核弹头手机登录插件",220, 1938,202, 1872);
//        setCoordinate("核弹头手机登录插件",583, 1669,583, 1521);
//        setCoordinate("核弹头手机登录插件",493, 1512,493, 1364);
//        setCoordinate("核弹头手机登录插件",48, 1515,48, 1364);
//        setCoordinate("核弹头手机登录插件",493, 1512,493, 1364);
//        setCoordinate("核弹头手机登录插件",63, 1529,48, 1364);
//        setCoordinate("核弹头手机登录插件",381, 1527,381, 1364);
//        setCoordinate("核弹头手机登录插件",410, 1530,381, 1364);

//        setCoordinate("核弹头-new",930, 938,930,1372);

//        addNew("乐趣双开","乐趣双开new");
//        addCoordinate("乐趣双开new",2,666, 855,2000);
//        addCoordinate("乐趣双开new",3,251, 794,2000);
//        for (int i = 0; i < 3; i++) {
//            addCoordinate("乐趣双开new",2,794, 2210,1000);
//        }

//        setTime("乐趣双开new",2,10000);
//        for (int i = 0; i < 3; i++) {
//            addCoordinate("乐趣双开new",5,794, 2210,1000);
//        }

//        addNew("火树","火树new");
//        addCoordinate("火树new",4,794, 2210,10000);
//        for (int i = 0; i < 5; i++) {
//            addCoordinate("火树new",5,794, 2210,1000);
//        }
//        addCoordinate("火树new",10,688, 2051,2000);
//        addCoordinate("火树new",11,739, 2064,12000);
//        addCoordinate("火树new",12,353, 1639,2000);
//        addCoordinate("火树new",13,858, 332,2000);

//        addNew("乐趣new","乐趣-new");
//        addTime("乐趣-new",6,30000);
//        addCoordinate("乐趣-new",6,794, 2210,10000);
//        for (int i = 0; i < 5; i++) {
//            addCoordinate("乐趣-new",7,794, 2210,1000);
//        }
//        addCoordinate("乐趣-new",12,930, 802,2000);
//        addCoordinate("乐趣-new",13,845, 803,2000);
//        addCoordinate("乐趣-new",14,533, 2043,15000);
//        addCoordinate("乐趣-new",15,320, 1628,5000);
//        addCoordinate("乐趣-new",16,831, 1273,5000);
//        addCoordinate("乐趣-new",17,271, 1380,5000);

//        addNew("牛刀","牛刀new");
//        addCoordinate("牛刀new",7,98,820,15000);
//        addCoordinate("牛刀new",8,974,530,3000);
//        setCoordinate("牛刀new",632, 1434,540,1414);

//        setTime("牛刀new",10,45000);

//        addNew("凹凸果","凹凸果new");
//        addCoordinate("凹凸果new",4,26,445,15000);
//        addCoordinate("凹凸果new",5,986,883,2000);

//        addNew("1758微游戏","1758微游戏new");
//        addCoordinate("1758微游戏new",6,76,237,15000);
//        addCoordinate("1758微游戏new",7,518,205,2000);
//        addCoordinate("1758微游戏new",1,76,237,2000);
//        deletePostion("1758微游戏new",1);
//        addCoordinate("1758微游戏new",7,76,237,2000);
//        deletePostion("1758微游戏new",5);
//        setCoordinate("1758微游戏new",76,237,92, 272);
//        deletePostion("1758微游戏new",6);
//        setTime("1758微游戏new",6,4000);

//        setCoordinate("1758微游戏new",518,205,527,210);
//        for (int i = 0; i < 2; i++) {
//            addCoordinate("1758微游戏new",7,527,210,1000);
//        }
//        setTime("1758微游戏new",5,30000);
//        deletePostions("1758微游戏new",7,8);

//        setTime("1758微游戏new",4,10000);

//        deletePostionsIndex("乐趣-new",0,11);
//
//        addCoordinate("乐趣-new",8,1062,860,30000);
//        addCoordinate("乐趣-new",9,120,174,5000);
//        addCoordinate("乐趣-new",10,89,2037,5000);
//        addCoordinate("乐趣-new",11,89,2037,5000);
//        addCoordinate("乐趣-new",12,86,753,5000);

//        deletePostionsIndex("1758微游戏new",2,6);
//        setTime("1758微游戏new",2,40000);

//        addCoordinate("07073qq插件",4,283,1755,5000);

//        deletePostionsIndex("凹凸果new",2,5);
//        setTime("凹凸果new",2,40000);
//        setTime("凹凸果new",3,40000);

//        addNew("07073qq插件","07073qq插件double");
//        setCoordinate("07073qq插件double",283,1755,745,1755);

//        setCoordinate("凹凸果new",575, 1812,587, 1811);

//        deletePostionsIndex("07073qq插件double",4,4);
//        addCoordinate("07073qq插件double",5,745,1755,5000);
//
//        deletePostionsIndex("07073qq插件",4,4);
//        addCoordinate("07073qq插件",5,283,1755,5000);

//        addCoordinate("热血单机双开-new",6,283,1755,5000);

//        addNew("凹凸果new","火树qq浏览器双开");
//        setCoordinate("火树qq浏览器双开",826, 1344,268 ,786);

//        addNew("凹凸果new", "小米浏览器刷新插件");
//        delete("小米浏览器刷新插件", 1);
//        addCoordinate("小米浏览器刷新插件", 1, 50, 2000, 2000);
//        addCoordinate("小米浏览器刷新插件", 2, 714, 2053, 2000);
//        addCoordinate("小米浏览器刷新插件", 3, 722, 1868, 2000);
//        addCoordinate("小米浏览器刷新插件", 4, 529, 1885, 2000);
//        deletePostion("小米浏览器刷新插件",0);
//        addCoordinate("小米浏览器刷新插件", 1, 50, 2000, 20000);

//        setCoordinate("乐趣网页", 495, 1820, 587, 1811);

//        addNew("火树qq浏览器双开","玩蛋qq浏览器双开");
//        setCoordinate("玩蛋qq浏览器双开",268, 786,
//                522,794);

//        addCoordinate("牛刀qq浏览器",6,283,1755,5000);

//        delete("乐趣双开new");
//        addNew("火树qq浏览器双开","乐趣双开new");
//        setCoordinate("乐趣双开new",268, 786, 249,761);
//        setCoordinate("乐趣双开new",426, 843, 661,799);

//        addNew("07073qq插件double","玩蛋qq插件");
//        setCoordinate("玩蛋qq插件",280, 1317, 550,1100);

//        addNew("07073qq插件double","玩蛋qq插件");
//        setCoordinate("玩蛋qq插件",280, 1317, 550,1100);

//        addNew("玩蛋qq插件","玩蛋qq双开插件");
//        setCoordinate("玩蛋qq双开插件",745, 1755, 745,1755);

//        setCoordinate("玩蛋qq插件",745, 1755, 283,1755);

//        addNew("玩蛋qq插件","1758qq插件");
//        setCoordinate("1758qq插件",550,1100,280,1100);
//
//        addNew("玩蛋qq双开插件","1758qq双开插件");
//        setCoordinate("1758qq双开插件",550,1100,280,1100);

//        addNew("玩蛋qq插件","乐趣qq插件");
//        setCoordinate("乐趣qq插件",550,1100,300,1400);
//
//        addNew("玩蛋qq双开插件","乐趣qq双开插件");
//        setCoordinate("乐趣qq双开插件",550,1100,300,1400);

//        deletePostionsIndex("乐趣-new",5,12);
//        addCoordinate("乐趣-new",5,114,763,20000);
//        setCoordinate("乐趣-new",523, 1793,587, 1811);
//        setTime("乐趣-new",6,35000);

//        deletePostionsIndex("火树new",0,9);
//        setCoordinate("火树new",495, 1820,587, 1811);
//        setCoordinate("玩蛋",495, 1820,587, 1811);
//        setCoordinate("1758微游戏new",569, 1817,587, 1811);
//        deletePostionsIndex("07073插件",0,0);
//        setCoordinate("07073插件",514, 1608,538,1711);

//        setCoordinate("凹凸果",575, 1812,587,1811);

//        addNew("秘境boss快速sample", "秘境boss快速sample1");
//        deletePostionsIndex("秘境boss快速sample1", 10, 21);
//        deletePostionsIndex("秘境boss快速sample1", 0, 0);
//        addNew("秘境boss快速sample", "秘境boss快速sample2");
//        deletePostionsIndex("秘境boss快速sample2", 0, 9);
//        deletePostionsIndex("秘境boss快速sample2", 9, 11);

//        addNew("热血单机h5-new","火树猎豹浏览器");
//        setCoordinate("火树猎豹浏览器",930, 1105,469,1603);

//        addNew("王者争霸","王者争霸sample");

//        deletePostionsIndex("王者争霸sample",4,36);
//
//        for (int i = 0; i < 6; i++) {
//            addCoordinateEnd("王者争霸sample",895, 1276, 1000);
//            addCoordinateEnd("王者争霸sample",422, 1864, 2000);
//            addCoordinateEnd("王者争霸sample",422, 1864, 1000);
//            addCoordinateEnd("王者争霸sample",557, 1723, 1000);
//            addCoordinateEnd("王者争霸sample",71, 1812, 10000);
//            for (int j = 0; j < 3; j++) {
//                addCoordinateEnd("王者争霸sample",511, 1534, 1000);
//            }
//        }
//        addCoordinateEnd("王者争霸sample",895, 1276, 2000);
//        for (int i = 0; i < 2; i++) {
//            addCoordinateEnd("王者争霸sample",1013, 2021,1000);
//        }

//        setTime("秘境boss快速sample1",7,2000);
//        setTime("秘境boss快速sample2",7,2000);

//        addNew("热血单机h5-new","玩蛋猎豹浏览器");
//        setCoordinate("玩蛋猎豹浏览器",930, 1105,390,1772);
//        setCoordinate("热血单机h5-new",930, 1105, 930, 1018);

//        addNew("自动关卡sample","自动关卡-sample");
//        deletePostionsIndex("自动关卡-sample",50,90);
//        setTime("自动关卡-sample",50,11000);
//        addNew("玩蛋qq浏览器双开","趣头条搜狗浏览器");
//        setCoordinate("趣头条搜狗浏览器",522, 794,757,784);
//        addCoordinate("趣头条搜狗浏览器",2,949 ,2055, 10000);
//        addCoordinate("趣头条搜狗浏览器",3,137,1637, 3000);
//        addCoordinate("趣头条搜狗浏览器",4,142,349, 3000);

//        setCoordinate("牛刀网页",511, 1455,423,977);
//        setCoordinate("核弹头网页new",511, 1455,423,977);
//        setCoordinate("牛刀new",540, 1414,423,977);
//        setCoordinate("1758qq插件",942, 1161, 279,613);
//        setCoordinate("1758qq双开插件",942, 1161, 279,613);
//        setCoordinate("07073qq插件",942, 1161, 279,613);
//        setCoordinate("07073qq插件double",942, 1161, 279,613);
//        setCoordinate("07073qq插件",942, 1161, 279,613);
//        setCoordinate("乐趣qq双开插件",942, 1161, 279,613);
//        setCoordinate("乐趣qq插件",942, 1161, 279,613);
//        setCoordinate("玩蛋qq插件",942, 1161, 279,613);
//        setCoordinate("玩蛋qq双开插件",942, 1161, 279,613);
//        setCoordinate("核弹头qq插件",942, 1161, 279,613);
//         setCoordinate("牛刀网页双开-new",942, 1161, 279,613);
//        setCoordinate("牛刀qq浏览器",942, 1161, 279,613);
//          setCoordinate("热血单机双开-new",942, 1161, 279,613);

//        addCoordinate("乐趣网页双开",2,114, 763,20000);
//        setCoordinate("牛刀网页双开-new",682, 1195,804, 957);
//        setCoordinate("牛刀网页",566, 1244,804, 957);

//        addNew("趣头条搜狗浏览器","趣头条qq浏览器双开");
//        deletePostionsIndex("趣头条qq浏览器双开",2,4);
//        setTime("趣头条qq浏览器双开",2,40000);
//        addNew("通天塔","通天塔sample");
//        addCoordinate("通天塔sample",12,92,1812, 3000);
//        setTime("通天塔sample",13,1000);
//        setTime("通天塔sample",14,1000);
//        setTime("通天塔sample",15,1000);
//        setTime("通天塔sample",16,1000);
//        deletePostionsIndex("通天塔sample",0,0);
//        setTime("通天塔sample",1,3000);
//        setTime("通天塔sample",2,1000);
//        setTime("通天塔sample",3,1000);
//        setCoordinate("通天塔sample",649, 1863,644, 1876);
//        setCoordinate("通天塔sample",651, 1869,644, 1876);
//        setTime("通天塔sample",4,1000);
//        setTime("通天塔sample",5,1000);
//        setTime("通天塔sample",6,1000);
//        setTime("通天塔sample",7,1000);
//        setTime("通天塔sample",8,1000);
//        setTime("通天塔sample",9,1000);
//        setTime("通天塔sample",10,1000);

//        addNew("火树网页双开","趣头条uc浏览器");
//        setCoordinate("趣头条uc浏览器",799, 792, 779,1358);

//        setTime("牛刀qq浏览器",6,10000);

//        addNew("牛刀qq浏览器", "牛刀qq浏览器relogin");
//        deletePostions("牛刀qq浏览器relogin",7,8);
//        deletePostions("牛刀qq浏览器relogin",0,1);

//        setTime("热血单机双开-new",6,10000);
//        addNew("热血单机双开-new","热血单机双开relogin");
//        deletePostions("热血单机双开relogin",7,8);
//        deletePostions("热血单机双开relogin",0,1);

//        addNew("趣头条qq浏览器双开","趣头条qq浏览器");
//        setCoordinate("趣头条qq浏览器",757, 784,802,1050);

//        addNew("牛刀new","牛刀relogin");
//        deletePostions("牛刀relogin",9,10);
//        deletePostions("牛刀relogin",0,1);
//        deletePostions("牛刀relogin",4,5,6);
//        setCoordinate("牛刀relogin",423, 977,535,1106);
//        setCoordinate("牛刀new",423, 977,535,1106);
//
//        addNew("核弹头双开","核弹头客户端");
//        setCoordinate("核弹头客户端",701, 796,416,777);

//        addNew("转生","签到");
//        deletePostion("签到",0);

//        delete("签到",2);
//        addCoordinateEnd("签到",399,298,2000);
//
//        addCoordinateEnd("签到",150,320,3000);
//        addCoordinateEnd("签到",150,520,1000);
//        addCoordinateEnd("签到",150,720,1000);
//        addCoordinateEnd("签到",150,920,1000);
//        addCoordinateEnd("签到",150,1120,1000);
//        addCoordinateEnd("签到",150,1320,1000);
//
//        addCoordinateEnd("签到",350,320,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",350,520,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",350,720,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",350,920,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",350,1120,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",350,1320,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",550,320,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",550,520,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",550,720,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",550,920,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",550,1120,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",550,1320,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",750,320,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",750,520,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",750,720,1000);
//        addCoordinateEnd("签到",750,920,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",750,1120,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",750,1320,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",950,320,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",950,520,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",950,720,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",950,920,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",950,1120,1000);
//        addCoordinateEnd("签到",700,1500,1000);
//        addCoordinateEnd("签到",950,1320,1000);
//        addCoordinateEnd("签到",700,1300,2000);
//        addCoordinateEnd("签到",700,1500,1000);
//
//        addCoordinateEnd("签到",900,1600,2000);
//
//        addCoordinateEndRepeate("签到",1013, 2021,1000,3);
//        setCoordinate("签到",700,1500,1000,1500);

//        addCoordinate("乐趣-new",6,1015, 2021,35000);
//        addCoordinate("乐趣-new",7,89,2026,5000);
//        setCoordinate("乐趣-new",320, 1628,324, 1614);
//        setCoordinate("乐趣-new",533, 2043,563, 2063);
//        deletePostion("乐趣-new",5);
//        setTime("乐趣-new",5,20000);
//        addCoordinate("乐趣-new",7,114, 763,20000);

        //        setCoordinate("乐趣-new",533, 2043,563, 2063);

//        addNew("玩蛋qq插件","火树qq插件");
//        setCoordinate("火树qq插件",550, 1100,520,1240);

//        addNew("凹凸果new","火树360浏览器");
//        addCoordinate("火树360浏览器",2,528,1339,10000);
//        addCoordinate("火树360浏览器",3,542,2006,3000);
//        addCoordinate("火树360浏览器",4,159,1424,3000);
//        addCoordinate("火树360浏览器",5,142,686,3000);

//        deletePostion("火树360浏览器",1);
//        setTime("火树360浏览器",1,2000);
//        setTime("火树360浏览器",2,10000);

//        addNew("火树360浏览器","趣头条360浏览器");
//        setCoordinate("趣头条360浏览器",142, 686,164, 838);

//        addNew("火树360浏览器","玩蛋360浏览器");
//        setCoordinate("玩蛋360浏览器",142, 686,213,951);


//        addNew("火树360浏览器","游戏1758浏览器360");
//        setCoordinate("游戏1758浏览器360",142, 686,205,1084);

//        addNew("火树360浏览器","乐趣360浏览器");
//        setCoordinate("乐趣360浏览器",142, 686,274,1225);


//        addNew("火树360浏览器","游戏07073浏览器360");
//        setCoordinate("游戏07073浏览器360",142, 686,353,1345);

//        addNew("火树360浏览器","牛刀浏览器360");
//        setCoordinate("牛刀浏览器360",142, 686,357,1475);
//        addCoordinate("牛刀浏览器360",5,355,994,10000);

//        addNew("核弹头手机登录插件","牛刀手机登录插件");
//        deletePostionsIndex("牛刀手机登录插件",23,26);
//        deletePostion("牛刀手机登录插件",0);
//        setCoordinateIndex("牛刀手机登录插件",0,0,368, 672);
//        setCoordinate("牛刀手机登录插件",726, 525,434,831);

//        addCoordinate("牛刀手机登录插件",1,233, 2032,3000);

//        addCoordinate("乐趣网页双开",2,1015, 2021,35000);
//        addCoordinate("乐趣网页双开",3,89,2026,5000);
//        setCoordinate("乐趣网页双开",89,2026,155,2038);

//        addNew("火树猎豹浏览器","游戏1758猎豹浏览器");
//        setCoordinate("游戏1758猎豹浏览器",469,1603,359,1914);

//        addNew("火树网页双开","趣头条猎豹");
//        setCoordinateIndex("趣头条猎豹",0,0,147,841);
//        setCoordinateIndex("趣头条猎豹",1,1,799,1007);

//        addNew("趣头条猎豹","火树遨游");
//        setCoordinate("火树遨游",799, 1007,536,1350);
//        setTime("火树遨游",1,3000);
//        setTime("火树遨游",2,10000);
//        addCoordinate("火树遨游",2,749,2056,3000);
//        addCoordinate("火树遨游",3,264,421,3000);

//        setTime("趣头条360浏览器",2,10000);
//        setTime("玩蛋360浏览器",2,10000);
//        setTime("游戏1758浏览器360",2,10000);
//        setTime("乐趣360浏览器",2,10000);
//        setTime("游戏07073浏览器360",2,10000);
//        setTime("牛刀浏览器360",2,10000);
//        setTime("火树遨游",2,20000);

//        setCoordinate("通天塔sample",644, 1876,600, 1876);

//        addNew("遨游火树","火树遨游");
//        addNew("火树遨游","趣头条遨游");
//        setCoordinateIndex("趣头条遨游",3,3,195,537);
//
//        addNew("火树遨游","玩蛋遨游");
//        setCoordinateIndex("玩蛋遨游",3,3,241,699);

//        addNew("竞技sample","竞技sample-8转");
//        deletePostionsIndex("竞技sample-8转",0,99);
//        setTime("竞技sample-8转",6,30000);
//        setTime("竞技sample-8转",12,30000);

//        deletePostion("竞技sample",100);

//        delete("竞技sample-8转");
//        addCoordinate("竞技sample",110, 410, 1216,1000);
//        setTime("竞技sample",120, 29000);

//        addNew("经验副本", "经验副本sample");
//        setTime("经验副本sample",10,1000);
//        setTime("经验副本sample",11,1000);
//        setTime("经验副本sample",12,1000);
//        setTime("经验副本sample",13,1000);
//        setCoordinate("转生",683, 1851,600, 1851);
//        addNew("火树360浏览器","火树360极速");
//
//        setCoordinate("火树360极速",528, 1339,793,1392);
//        setCoordinate("火树360极速",159, 1424,173,1658);
//        setCoordinate("火树360极速",142, 686,299,276);

//        addNew("火树360极速","趣头条360极速");
//        setCoordinate("趣头条360极速",299,276,225,458);
//
//        addNew("火树360极速","玩蛋360极速");
//        setCoordinate("玩蛋360极速",299,276,250,617);

//        setCoordinate("火树360极速",426, 843,168,802);
//        setCoordinate("趣头条360极速",426, 843,168,802);
//        setCoordinate("玩蛋360极速",426, 843,168,802);

        show("趣头条360极速","玩蛋360极速");

//        ActionFile.write(actions);
    }

    private static void show(String... names) {
        for (String name : names) {
            Action tmp = getAction(name);
            if (tmp != null) {
                List<Coordinate> coordinates = tmp.getCoordinates();
                for (int i = 0; i < coordinates.size(); i++) {
                    Timber.e("tmp: " + coordinates.get(i) + "\n");
                }
                Timber.e("tm" + "p: " + tmp);
            }
        }
    }

    private static void addTime(String name, int startIndex, long addTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            for (int i = startIndex; i < coordinates.size(); i++) {
                coordinate = coordinates.get(i);
                coordinate.setTime(coordinate.getTime() + addTime);
            }
        }
    }

    private static Action getAction(String name) {
        Action tmp = null;
        if (actions != null) {
            for (Action action : actions) {
                if (action.getName().equals(name)) {
                    tmp = action;
                    break;
                }
            }
        }
        return tmp;
    }

    private static void addTime(String name, Predicate<Coordinate> predicate, long addTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            for (int i = 0; i < coordinates.size(); i++) {
                coordinate = coordinates.get(i);
                if (predicate.test(coordinate)) {
                    addTime(name, i, addTime);
                }
            }
        }
    }

    private static void setTime(String name, int index, long delay) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            if (index > 0 && index < coordinates.size()) {
                Coordinate preCoordinate = coordinates.get(index - 1);
                Coordinate currentCoordinate = coordinates.get(index);
                addTime(name, index, delay - (currentCoordinate.getTime() - preCoordinate.getTime()));
            }
        }
    }

    private static void addTimeAll(String name, long addTime) {
        int size = getSize(name);
        for (int i = 1; i < size; i++) {
            addTime(name, i, addTime);
        }
    }

    private static void setCoordinate(String name,
                                      int oldX, int oldY, int newX, int newY) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            for (Coordinate coordinate : coordinates) {
                if (coordinate.getX() == oldX && coordinate.getY() == oldY) {
                    coordinate.setX(newX);
                    coordinate.setY(newY);
                }
            }
        }
    }

    private static void addCoordinateEndRepeate(String name, int newX, int newY, int offsetTime, int repeate) {
        for (int i = 0; i < repeate; i++) {
            addCoordinateEnd(name, newX, newY, offsetTime);
        }
    }

    private static void addCoordinateTop(String name, int newX, int newY, int offsetTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            coordinate = new Coordinate(newX, newY);
            coordinate.setTime(coordinates.get(0).getTime() - offsetTime);
            coordinates.add(0, coordinate);
        }
    }

    private static void addCoordinateEnd(String name, int newX, int newY, int offsetTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            coordinate = new Coordinate(newX, newY);
            coordinate.setTime(coordinates.get(coordinates.size() - 1).getTime() + offsetTime);
            coordinates.add(coordinate);
        }
    }

    private static void addCoordinate(String name, int index, int newX, int newY, int offsetTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            coordinate = new Coordinate(newX, newY);
            coordinate.setTime(coordinates.get(index - 1).getTime() + offsetTime);
            coordinates.add(index, coordinate);
            for (int i = index + 1; i < coordinates.size(); i++) {
                coordinates.get(i).setTime(coordinates.get(i).getTime() + offsetTime);
            }
        }
    }

    private static void addCoordinate(String name, Predicate<Coordinate> predicate, int newX, int newY, int offsetTime) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            List<Coordinate> tmpCoordinates = new ArrayList<Coordinate>(coordinates);
            Coordinate coordinate;
            int offset = 0;
            for (int i = 0; i < tmpCoordinates.size(); i++) {
                Coordinate value = tmpCoordinates.get(i);
                if (predicate.test(value)) {
                    offset += 1;
                    coordinate = new Coordinate(newX, newY);
                    coordinate.setTime(value.getTime() + offsetTime);
                    coordinates.add(i + offset, coordinate);

                    for (int j = i + offset + 1; j < coordinates.size(); j++) {
                        coordinates.get(j).setTime(coordinates.get(j).getTime() + offsetTime);
                    }
                }
            }


        }
    }

    private static int getSize(String name) {
        Action tmp = getAction(name);
        int size = 0;
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            size = coordinates.size();
        }
        return size;
    }

    private static void setCoordinateIndex(String name,
                                           int startIndex, int endIndex, int newX, int newY) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            for (int i = startIndex; i <= endIndex; i++) {
                coordinate = coordinates.get(i);
                coordinate.setX(newX);
                coordinate.setY(newY);
            }
        }
    }

    private static void setCoordinateIndexOffset(String name,
                                                 int startIndex, int endIndex, int offsetX, int offsetY) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            for (int i = startIndex; i <= endIndex; i++) {
                coordinate = coordinates.get(i);
                coordinate.setX(coordinate.getX() + offsetX);
                coordinate.setY(coordinate.getY() + offsetY);
            }
        }
    }

    private static void addNew(String oldName, String newName) {
        Action tmp = getAction(oldName);
        if (tmp != null) {
            Action actionCopy = copy(tmp, newName);
            actions.add(actionCopy);
        }
    }

    private static void deletePostionsIndex(String name, int startIndex, int endIndex) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            List<Coordinate> delete = new ArrayList<Coordinate>();
            for (int i = startIndex; i <= Math.min(endIndex, coordinates.size() - 1); i++) {
                delete.add(coordinates.get(i));
            }
            coordinates.removeAll(delete);
        }
    }

    private static void deletePostions(String name, int... positions) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            List<Coordinate> delete = new ArrayList<Coordinate>();
            for (int i = 0; i < coordinates.size(); i++) {
                for (int position : positions) {
                    if (position == i) {
                        delete.add(coordinates.get(i));
                        break;
                    }
                }
            }
            coordinates.removeAll(delete);
        }
    }

    private static void deletePostion(String name, int position) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            if (position != 0) {
                addTime(name, position,
                        -(coordinates.get(position).getTime() - coordinates.get(position - 1).getTime()));
            }
            coordinates.remove(position);
        }
    }

    private static void delete(String name) {
        Action tmp = getAction(name);
        actions.remove(tmp);
    }

    private static void delete(String name, int startIndex) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            List<Coordinate> delete = new ArrayList<Coordinate>();
            for (int i = startIndex; i < coordinates.size(); i++) {
                delete.add(coordinates.get(i));
            }
            coordinates.removeAll(delete);
        }
    }

    private static Action copy(Action source, String name) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        for (Coordinate coordinate : source.getCoordinates()) {
            Coordinate coordinate1;
            if (coordinate.getX() == 911 && coordinate.getY() == 1130) {
                coordinate1 = new Coordinate(909, 1018);
            } else {
                coordinate1 = new Coordinate(coordinate.getX(), coordinate.getY());
            }
            coordinate1.setTime(coordinate.getTime());
            coordinates.add(coordinate1);
        }
        Action action = new Action();
        action.setName(name);
        action.setCoordinates(coordinates);
        action.setActionTime(source.getActionTime());
        return action;
    }

    private static boolean isSame(Coordinate value, int x, int y) {
        return value.getX() == x && value.getY() == y;
    }
}
