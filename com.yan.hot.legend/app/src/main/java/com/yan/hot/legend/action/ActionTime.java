package com.yan.hot.legend.action;

import java.io.Serializable;

public class ActionTime implements Serializable{
	//运行时间
	private int hour;
	//运行分钟
	private int min;
	//时间间隔（分钟）
	private int interval;
	//运行次数
	private int count;
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ActionTime [hour=" + hour + ", min=" + min + ", interval="
				+ interval + ", count=" + count + "]";
	}
	
}
