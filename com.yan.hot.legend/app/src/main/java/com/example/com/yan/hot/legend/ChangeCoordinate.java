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

        //        addTime("核弹头", getSize("核弹头")-1, 20000);
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

        show("秘境boss快速");

//                ActionFile.write(actions);
    }

    private static void show(String name) {
        Action tmp = getAction(name);
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            for (int i = 0; i < coordinates.size(); i++) {
                Log.e("test", "tmp: " + coordinates.get(i) + "\n");
            }
            Log.e("test", "tmp: " + tmp);
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
        for (Action action : actions) {
            if (action.getName().equals(name)) {
                tmp = action;
                break;
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
        for (int i = 0; i < size; i++) {
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
                        coordinates.get(position).getTime() - coordinates.get(position - 1).getTime());
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
