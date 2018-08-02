package com.zsctc.remote.touch.bytes;

import android.util.Log;

public class TouchUpEndByte extends TouchByteInface {

	protected void log(String msg){
		if (false) {
			Log.e("TouchUpEndByte", msg);
		}
	}
	public TouchUpEndByte() {
		super();
	}
	public TouchUpEndByte(byte[] point, byte x[], byte y[]) {
		super(point, x, y);
	}

	@Override
	protected void init(byte[] point, byte[] x, byte[] y) {
		eventBytes = new byte[4][];
		
		for (int i = 0; i < point.length; i++) {
			TouchVlaue.touchPoint[point.length + i] = 
					point[i];	
		}
		eventBytes[0] = TouchVlaue.time;
		eventBytes[1] = TouchVlaue.touchEnd;
		
		eventBytes[2] = TouchVlaue.time;
		eventBytes[3] = TouchVlaue.touchEvent;
		
		toByte();
	}
	
}
