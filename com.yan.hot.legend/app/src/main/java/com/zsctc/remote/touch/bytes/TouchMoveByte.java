package com.zsctc.remote.touch.bytes;

import android.util.Log;

public class TouchMoveByte extends TouchByteInface {

	protected void log(String msg){
		if (false) {
			Log.e("TouchMoveByte", msg);
		}
	}
	public TouchMoveByte() {
		super();
	}
	public TouchMoveByte(byte[] point, byte x[], byte y[]) {
		super(point, x, y);
	}

	@Override
	protected void init(byte[] point, byte[] x, byte[] y) {
		eventBytes = new byte[6][];
		
		for (int i = 0; i < point.length; i++) {
			TouchVlaue.touchPoint[point.length + i] = 
					point[i];	
		}
		eventBytes[0] = TouchVlaue.time;
		eventBytes[1] = TouchVlaue.touchPoint;
		
		for (int i = 0; i < x.length; i++) {
			TouchVlaue.touchX[TouchVlaue.touchX.length - (x.length - i)] 
					= x[i];
		}
		eventBytes[2] = TouchVlaue.time;
		eventBytes[3] = TouchVlaue.touchX;
		log(TouchVlaue.touchX);
		
		for (int i = 0; i < y.length; i++) {
			TouchVlaue.touchY[TouchVlaue.touchX.length - (y.length - i)] 
					= y[i];
		}
		eventBytes[4] = TouchVlaue.time;
		eventBytes[5] = TouchVlaue.touchY;
		log(TouchVlaue.touchY);
		
//		eventBytes[6] = TouchVlaue.time;
//		eventBytes[7] = TouchVlaue.touchZ;
		
		toByte();
	}
	
	public byte[] getTouchEnd(){
		byte[] endBytes = new byte[TouchVlaue.time.length
		                           + TouchVlaue.touchEvent.length];
		for (int i = 0; i < TouchVlaue.time.length; i++) {
			endBytes[i] = TouchVlaue.time[i];
		}
		for (int i = 0; i < TouchVlaue.touchEvent.length; i++) {
			endBytes[TouchVlaue.time.length + i] = TouchVlaue.touchEvent[i];
		}
		return endBytes;
	}

}
