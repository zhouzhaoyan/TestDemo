package com.example.com.yan.hot.legend;

import android.util.Log;

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

        show("转生");
//        ActionFile.write(actions);
    }

    private static void show(String name) {
        Action tmp = null;
        for (Action action : actions) {
            if (action.getName().equals(name)) {
                tmp = action;
                break;
            }
        }
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            for (int i = 0; i < coordinates.size(); i++) {
                Log.e("test", "tmp: " + coordinates.get(i) + "\n");
            }
            Log.e("test", "tmp: " + tmp);
        }
    }

    private static void addTime(String name, int startIndex, long addTime){
        Action tmp = null;
        for (Action action : actions) {
            if (action.getName().equals(name)) {
                tmp = action;
                break;
            }
        }
        if (tmp != null) {
            List<Coordinate> coordinates = tmp.getCoordinates();
            Coordinate coordinate;
            for (int i = startIndex; i < coordinates.size(); i++) {
                coordinate = coordinates.get(i);
                coordinate.setTime(coordinate.getTime() + addTime);
            }
        }
    }

    private static void setCoordinate(String name,
                               int oldX, int oldY, int newX, int newY) {
        Action tmp = null;
        for (Action action : actions) {
            if (action.getName().equals(name)) {
                tmp = action;
                break;
            }
        }
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

    private static void setCoordinateIndex(String name,
                                      int startIndex, int endIndex, int newX, int newY) {
        Action tmp = null;
        for (Action action : actions) {
            if (action.getName().equals(name)) {
                tmp = action;
                break;
            }
        }
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
        Action tmp = null;
        for (Action action : actions) {
            if (action.getName().equals(oldName)) {
                tmp = action;
                break;
            }
        }
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

    private static void delete(List<Coordinate> coordinates, int startIndex) {
        List<Coordinate> delete = new ArrayList<Coordinate>();
        for (int i = startIndex; i < coordinates.size(); i++) {
            delete.add(coordinates.get(i));
        }
        coordinates.removeAll(delete);
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
}
