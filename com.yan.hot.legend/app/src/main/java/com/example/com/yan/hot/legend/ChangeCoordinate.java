package com.example.com.yan.hot.legend;

import android.util.Log;

import com.annimon.stream.function.Predicate;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.Coordinate;

import java.util.ArrayList;
import java.util.List;

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
        show("热血单机h5");

//        ActionFile.write(actions);
    }

    private static void show(String...names) {
        for (String name: names) {
            Action tmp = getAction(name);
            if (tmp != null) {
                List<Coordinate> coordinates = tmp.getCoordinates();
                for (int i = 0; i < coordinates.size(); i++) {
                    Log.e("test", "tmp: " + coordinates.get(i) + "\n");
                }
                Log.e("test", "tmp: " + tmp);
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
        if (actions != null){
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
            List<Coordinate> coordinates = tmp.getCoordinates();
            Action actionCopy = copy(tmp, newName);
            for (int i = 0; i < coordinates.size(); i++) {
                Log.e("test", "tmp: " + coordinates.get(i) + "\n");
            }

            actions.add(actionCopy);
            //            ActionFile.write(actions);
            Log.e("test", "tmp: " + actionCopy);
        }
    }

    private static void deletePostionsIndex(String name, int startIndex, int endIndex) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            List<Coordinate> delete = new ArrayList<Coordinate>();
            for (int i = startIndex; i <= Math.min(endIndex,coordinates.size()-1); i++) {
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
