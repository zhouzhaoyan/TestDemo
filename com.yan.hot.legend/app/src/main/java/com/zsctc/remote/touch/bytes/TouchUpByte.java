package com.zsctc.remote.touch.bytes;

import android.util.Log;

public class TouchUpByte extends TouchByteInface {

	protected void log(String msg){
		if (true) {
			Log.e("TouchUpByte", msg);
		}
	}
	public TouchUpByte() {
		super();
	}
	public TouchUpByte(byte[] point, byte x[], byte y[]) {
		super(point, x, y);
	}

	@Override
	protected void init(byte[] point, byte[] x, byte[] y) {
		eventBytes = new byte[3][];
		
		for (int i = 0; i < point.length; i++) {
			TouchVlaue.touchPoint[point.length + i] = 
					point[i];	
		}
		eventBytes[0] = TouchVlaue.touchEnd;
		
		eventBytes[1] = TouchVlaue.touchBinEventEnd;
				
		eventBytes[2] = TouchVlaue.touchEvent;
		
		toByte();
	}
	
}
