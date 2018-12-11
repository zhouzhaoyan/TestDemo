package com.yan.hot.legend.action;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 坐标解析工具
 * @author zhouzhaoyan
 *
 */
public class CoordinateParse {
    public static List<Coordinate> getCoordinate(String cmd){
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String[] splits = cmd.split("\\[");
        Coordinate coordinate = new Coordinate();
        Log.e("test", "getCoordinate,splits:" + splits.length);
        for (String string : splits) {
            if (!string.contains("]")) {
                continue;
            }
            try {
                Log.e("test", "string:" + string + ",test:" + Integer.parseInt(string.substring(string.lastIndexOf(".")+1, string.lastIndexOf("] ")-3)));
                coordinate.setTime(Long.parseLong(string.substring(0, string.lastIndexOf("] ") - 7).replace(" ", "")) * 1000
                        + Integer.parseInt(string.substring(string.lastIndexOf(".")+1, string.lastIndexOf("] ")-3)));
                Log.e("test", "time:" + coordinate.getTime());
                string = string.substring(string.lastIndexOf("] ")+2);
                Log.e("test", "string2:" + string);
                if (string.startsWith("0003 0035 ")) {
                    coordinate.setX(Integer.parseInt(string.replace("0003 0035 ", "").split("\n")[0], 16));
                }

                if (string.startsWith("0003 0036 ")) {
                    coordinate.setY(Integer.parseInt(string.replace("0003 0036 ", "").split("\n")[0], 16));
                }

                if (coordinate.isFinish()) {
                    coordinates.add(coordinate);
                    coordinate = new Coordinate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return coordinates;
    }
}
