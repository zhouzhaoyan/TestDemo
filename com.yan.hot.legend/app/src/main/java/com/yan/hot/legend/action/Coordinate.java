package com.yan.hot.legend.action;

import java.io.Serializable;

/**
 * 坐标
 * @author zhouzhaoyan
 *
 */
public class Coordinate implements Serializable {
    private long time;
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    private int x;
    private int y;
    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public Coordinate() {
        super();
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isFinish(){
        return x != 0 && y != 0;
    }
    @Override
    public String toString() {
        return "Coordinate [time=" + time + ", x=" + x + ", y=" + y + "]";
    }

}