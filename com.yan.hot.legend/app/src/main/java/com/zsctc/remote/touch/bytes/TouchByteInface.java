package com.zsctc.remote.touch.bytes;

public abstract class TouchByteInface {
	protected byte x[] = null;
	protected byte y[] = null;
	protected byte point[] = null; 
	protected byte[][] eventBytes = null;
	
	protected abstract void log(String msg);
	
	public TouchByteInface() {
	}
	
	public TouchByteInface(byte[] point, byte[] x, byte[] y) {
		initData(point, x, y);
	}
	
	//初始化x,y的数据
	public void initData(byte[] point, byte[] x, byte[] y){
		this.x = x;
		this.y = y;
		this.point = point;
		init(point, x, y);
	}
	
	protected abstract void init(byte[] point, byte[] x, byte[] y);

	protected void log(byte[] datas){
		StringBuilder stringBuilder = new StringBuilder("");
		for (int j = 0; j < datas.length; j++) {
			stringBuilder.append(Integer.toHexString(datas[j]&0xff) + ",");
			if (j % 8 == 7) {
				stringBuilder.append("\n");
			}
		}
		log("bytes:" + stringBuilder);
	}
	
	public byte[] toByte(){
		int col = eventBytes.length;
		int row = eventBytes[0].length;
		byte[] data = new byte[col*row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				data[i*row+j] = eventBytes[i][j];
			}
		}
		log(data);
		return data;
	}
}
