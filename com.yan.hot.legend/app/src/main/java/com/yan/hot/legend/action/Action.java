package com.yan.hot.legend.action;

import java.io.Serializable;
import java.util.List;

public class Action  implements Serializable {
	//名称
	private String name;
	//运行时间
	private ActionTime actionTime;
	//坐标
	private List<Coordinate> coordinates;
	//名字
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ActionTime getActionTime() {
		return actionTime;
	}
	public void setActionTime(ActionTime actionTime) {
		this.actionTime = actionTime;
	}
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "Action [name=" + name + ", actionTime=" + actionTime
				+ ", coordinates=" + coordinates + "]";
	}
	
	
}
