package com.zsctc.remote.touch.bytes;

import android.util.Log;

public class TouchDownByte extends TouchByteInface{
	
	protected void log(String msg){
		if (true) {
			Log.e("TouchDownByte", msg);
		}
	}
	public TouchDownByte() {
		super();
	}
	public TouchDownByte(byte[] point, byte x[], byte y[]) {
		super(point, x, y);
	}
	@Override
	protected void init(byte[] point, byte[] x, byte[] y) {
		eventBytes = new byte[6][];
		
		for (int i = 0; i < point.length; i++) {
			TouchVlaue.touchPoint[point.length + i] = 
					point[i];	
			TouchVlaue.touchStart[point.length + i] = 
					point[i];	
		}
		
		eventBytes[0] = TouchVlaue.touchPoint;
		
		eventBytes[1] = TouchVlaue.touchStart;
				
		for (int i = 0; i < x.length; i++) {
			TouchVlaue.touchX[TouchVlaue.touchX.length - (x.length - i)] 
					= x[i];
		}
		eventBytes[2] = TouchVlaue.touchX;
		log(TouchVlaue.touchX);
		
		for (int i = 0; i < y.length; i++) {
			TouchVlaue.touchY[TouchVlaue.touchX.length - (y.length - i)] 
					= y[i];
		}
		eventBytes[3] = TouchVlaue.touchY;
		log(TouchVlaue.touchY);
		
		eventBytes[4] = TouchVlaue.touchBinEventStart;
				
		eventBytes[5] = TouchVlaue.touchEvent;
		
		toByte();
	}
}
