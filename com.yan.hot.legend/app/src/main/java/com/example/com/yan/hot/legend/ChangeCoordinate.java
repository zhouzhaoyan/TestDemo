package com.example.com.yan.hot.legend;

import android.util.Log;

import com.annimon.stream.function.Predicate;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.Coordinate;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by on 2018/8/2.
 * 改变坐标
 */
public class ChangeCoordinate {
    private static List<Action> actions = null;

    public static void change(List<Action> actions) {
        Log.e(TAG, "---------change------------");
        ChangeCoordinate.actions = actions;

//        addNew("暗之秘境-修罗","暗之秘境-魔窟");
//        setCoordinate("暗之秘境-魔窟",941,1351,882,1463);

//        addNew("跨服boss-苍月岛","跨服boss-埋骨之地");
//        addCoordinate("跨服boss-埋骨之地",6,660,1653,5000);
//        setCoordinate("跨服boss-埋骨之地",516, 823,293,1131);

//        addNew("血战比奇", "血战比奇MAX");
//        delete("血战比奇MAX",9);
//        for (int i = 0; i < 132; i++) {
//            addCoordinateEnd("血战比奇MAX",100,678,1000);
//            addCoordinateEnd("血战比奇MAX",100,863,1000);
//            addCoordinateEnd("血战比奇MAX",100,1051,1000);
//            addCoordinateEnd("血战比奇MAX",100,1210,1000);
//            addCoordinateEnd("血战比奇MAX",100,1380,1000);
//            addCoordinateEnd("血战比奇MAX",1000,1800,1000);
//            addCoordinateEnd("血战比奇MAX",926,1554,1000);
//
//        }
//        addCoordinateEnd("血战比奇MAX",545, 662,1000);
//        addCoordinateEnd("血战比奇MAX",1002, 1487,1000);
//        for (int i = 0; i < 2; i++) {
//            addCoordinateEnd("血战比奇MAX",1000, 1800,1000);
//        }
//        addCoordinateEnd("血战比奇MAX",538, 1492,1000);


//        setCoordinate("打开wifi",860, 989,567, 1238);
//        delete("打开wifi",1);
//        for (int i = 0; i < 30; i++) {
//            addCoordinateEnd("打开wifi",567, 1238,2000);
//        }

//        addNew("打开wifi","关闭wifi");
//        delete("关闭wifi",2);
//        setCoordinate("关闭wifi",567, 1238,1000, 1800);

//        delete("打开wifi",1);
//        for (int i = 0; i < 9; i++) {
//            addCoordinateEnd("打开wifi",567, 1238,10000);
//        }

//        addDouble("王者争霸","王者争霸double");
//        addNew("熔炼","熔炼-自定义");

//        addNew("神域boss","野外神域boss");
//        delete("野外神域boss",1);
//
//        for (int j = 0; j < 6; j++) {
//
//            addCoordinateEnd("野外神域boss",1053, 1299,1000);
//            for (int i = 0; i < 2; i++) {
//                addCoordinateEnd("野外神域boss",336,1672,1000);
//                addCoordinateEnd("野外神域boss",904, 606,1000);
//                addCoordinateEnd("野外神域boss",743, 1671,1000);
//                addCoordinateEnd("野外神域boss",904, 606,1000);
//            }
//
//            addCoordinateEnd("野外神域boss",1029, 1837,1000);
//        }
//

//        addNew("魔界入侵","魔界入侵-吸血");
//        setCoordinate("魔界入侵-吸血",216,1589,852,1599);
//
//        addNew("魔界入侵","魔界入侵-烛龙");
//        setCoordinate("魔界入侵-烛龙",216,1589,653,1593);

//        addNew("魔界入侵-烛龙","魔界入侵-烛龙new");
//        setCoordinate("魔界入侵-烛龙new",397, 1547,329,1564);
//        setTime("魔界入侵-烛龙new",11,1000);
//        setTime("魔界入侵-烛龙new",12,1000);
//        for (int i = 0; i < 420; i++) {
//            addCoordinate("魔界入侵-烛龙new",12,329,1564,1000);
//        }

//        addNew("魔界入侵-烛龙","暗殿boss");
//        setCoordinateIndex("暗殿boss",0,0, 1013, 1829);
//		delete("暗殿boss", 1);
//		addCoordinateEnd("暗殿boss",1013, 1829,1000);
//
//        for (int i = 0; i < 56; i++) {
//
//            if (i % 7 == 0){
//                addCoordinateEnd("暗殿boss",1013, 1829,1000);
//                addCoordinateEnd("暗殿boss",555,576,1000);
//                addCoordinateEnd("暗殿boss",351,1326,1000);
//            }
//
//            addCoordinateEnd("暗殿boss",554,1664,1000);
//            addCoordinateEnd("暗殿boss",1053, 1299,1000);
//            addCoordinateEnd("暗殿boss",365, 1549,1000);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            addCoordinateEnd("暗殿boss",1013, 1829,1000);
//        }

//        delete("跨服boss-迷离境");
//        delete("跨服boss-迷离境-自定义");

//        addNew("跨服boss-埋骨之地","跨服boss-迷离境");
//        setCoordinate("跨服boss-迷离境",293, 1131,554,556);
//
//        deletePostionsIndex("跨服boss-迷离境",10,1210);
//        setTime("跨服boss-迷离境",10,1000);
//        for (int i = 0; i < 3608; i++) {
//            addCoordinate("跨服boss-迷离境",10 + i,309, 1540,1000);
//        }
//
//        addNew("跨服boss-迷离境","跨服boss-迷离境-自定义");

//        addNew("跨服boss-迷离境","打开wifi");
//        setCoordinateIndex("打开wifi",0,0,1000, 1800);
//        delete("打开wifi",1);
//        for (int i = 0; i < 30; i++) {
//            addCoordinateEnd("打开wifi",1000, 1800,2000);
//        }
//
//        addNew("打开wifi","关闭wifi");
//        delete("关闭wifi",2);

//        setCoordinate("打开wifi",1000, 1800,309, 1540);
//        setCoordinate("关闭wifi",1000, 1800,309, 1540);

//        addNew("个人boss","个人boss-new");
//        deletePostionsIndex("个人boss-new",7,18);
//        for (int i = 0; i < 120; i++) {
//            addCoordinate("个人boss-new",7,446, 1561,1000);
//        }

//        setCoordinate("跨服boss-迷离境",660, 1653,603,1680);
//        deletePostionsIndex("跨服boss-迷离境",9,9);
//        addCoordinate("跨服boss-迷离境",7,603,1680,3000);
//
//        setCoordinate("跨服boss-迷离境-自定义",660, 1653,603,1680);
//        deletePostionsIndex("跨服boss-迷离境-自定义",9,9);
//        addCoordinate("跨服boss-迷离境-自定义",7,603,1680,3000);
//        setTime("跨服boss-迷离境",10,1000);
//        setTime("跨服boss-迷离境-自定义",10,1000);

//        deletePostionsIndex("熔炼",5,43);
//        setTime("熔炼",4,3000);
//        addCoordinate("熔炼",5,600, 1646,3000);
//        for (int i = 0; i < 35; i++) {
//            addCoordinate("熔炼",6,600, 1646,1000);
//        }
//        for (int i = 0; i < 4; i++) {
//            addCoordinate("熔炼",41,1013, 1821,1000);
//        }

//        setCoordinate("熔炼",600, 1646,434 ,1570);
//        addCoordinate("熔炼",2,1053, 1299,1000);
//        for (int i = 0; i < 3; i++) {
//            addCoordinate("熔炼",3,1029, 1837,1000);
//        }

//        deletePostionsIndex("主宰boss",0,5);
//        setCoordinate("主宰boss",541, 576,522,1456);
//        deletePostionsIndex("主宰boss",2,5);
//        setTime("主宰boss",1,2000);
//        for (int i = 0; i < 3; i++) {
//            addCoordinate("主宰boss",2,1029, 1837,1000);
//        }
//        addCoordinate("主宰boss",2,420,1550,3000);
//        for (int i = 0; i < 292; i++) {
//            addCoordinate("主宰boss",3,420,1550,1000);
//        }

//        addNew("魔界入侵-烛龙","魔界入侵-深渊");
//        setCoordinate("魔界入侵-深渊",653, 1593,216,1589);
//
//        addNew("魔界入侵-烛龙","魔界入侵-鬼眼");
//        setCoordinate("魔界入侵-鬼眼",653, 1593,404,1599);
//
//        addNew("魔界入侵-烛龙","魔界入侵-吸血");
//        setCoordinate("魔界入侵-吸血",653, 1593,852,1599);

//        setTime("魔界入侵-深渊",1,8000);
//        setTime("魔界入侵-鬼眼",1,8000);
//        setTime("魔界入侵-吸血",1,8000);
//        setTime("魔界入侵-烛龙",1,8000);

        show("魔界入侵-深渊");

//        ActionFile.write(actions);
    }

    private static void show(String...names) {
        for (String name: names) {
            Action tmp = getAction(name);
            if (tmp != null) {
                List<Coordinate> coordinates = tmp.getCoordinates();
//                Log.e("test", "tmp: size:" + coordinates.size() + "\n");
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
            Action actionCopy = copy(tmp, newName);
            actions.add(actionCopy);
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

    private static void delete(String name) {
        Action tmp = getAction(name);
        actions.remove(tmp);
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
