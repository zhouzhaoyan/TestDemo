package com.zsctc.remote.touch.bytes;

public class TouchVlaue {
	
	public static String eventDown = 
			"sendevent %3$s 0003 0057 00001046 \n" +
			"sendevent %3$s 0001 0330 00000001 \n" +
//			"sendevent %3$s 0001 0325 00000001 \n" +
			
			"sendevent %3$s 0003 0053 %1$s \n" +
			"sendevent %3$s 0003 0054 %2$s \n" +
			
//			"sendevent %3$s 0003 0049 00000003 \n" +
//			"sendevent %3$s 0000 0000 00000000 \n" +
//
//			"sendevent %3$s 0003 0048 00000003 \n" +
			"sendevent %3$s 0000 0000 00000000 \n";
	
	public static String eventMove = 
			"sendevent %3$s 0003 0047 00000000 \n" +
			"sendevent %3$s 0003 0053 %1$s \n" +
			"sendevent %3$s 0003 0054 %2$s \n" +
			"sendevent %3$s 0000 0002 00000000 \n" + 
			"sendevent %3$s 0000 0000 00000000 \n" 
			;
	
	public static String eventUp = 
			"sendevent %3$s 0003 0057 4294967295 \n" +
			"sendevent %3$s 0001 0330 00000000 \n" +
			"sendevent %3$s 0001 0325 00000000 \n" +
			"sendevent %3$s 0000 0000 00000000 \n";
	
	public static String move =
			"sendevent /dev/input/event2 0003 0047 00000000 \n" +
			"sendevent /dev/input/event2 0003 0047 00000446 \n" +
					
			"sendevent /dev/input/event2 0001 0330 00000001 \n" +
			"sendevent /dev/input/event2 0003 0053 00000521 \n" +
			"sendevent /dev/input/event2 0003 0054 00001398 \n" +
			
			"sendevent /dev/input/event2 0003 0048 00000003 \n" +
			"sendevent /dev/input/event2 0003 0049 00000003 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			"sendevent /dev/input/event2 0003 0048 00000005 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0053 00000514 \n" +
			"sendevent /dev/input/event2 0003 0054 00001368 \n" +
			"sendevent /dev/input/event2 0003 0048 00000003 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0053 00000508 \n" +
			"sendevent /dev/input/event2 0003 0054 00001280 \n" +
			"sendevent /dev/input/event2 0003 0048 00000005 \n" +
			"sendevent /dev/input/event2 0003 0049 00000004 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0053 00000520 \n" +
			"sendevent /dev/input/event2 0003 0054 00001135 \n" +
			"sendevent /dev/input/event2 0003 0048 00000006 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0053 00000599 \n" +
			"sendevent /dev/input/event2 0003 0054 00000815 \n" +
			"sendevent /dev/input/event2 0003 0048 00000005 \n" +
			"sendevent /dev/input/event2 0003 0049 00000005 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0053 00000693 \n" +
			"sendevent /dev/input/event2 0003 0054 00000569 \n" +
			"sendevent /dev/input/event2 0003 0049 00000004 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000 \n" +
			
			"sendevent /dev/input/event2 0003 0057 4294967295 \n" +
			"sendevent /dev/input/event2 0001 0330 00000000 \n" +
			"sendevent /dev/input/event2 0001 0325 00000000 \n" +
			"sendevent /dev/input/event2 0000 0000 00000000";
	
	//可理解为多点时点的序号
	public static byte[] touchPoint = {
		0x03,0x00,
		0x2f,0x00,
		0x00,0x00,0x00,0x00
	};
	//可理解为一次touch的开始 
	public static byte[] touchStart = {
			0x03,0x00,
			0x39,0x00,
			0x00, 0x00,0x00,0x00};
	//可理解为点击开始 
	public static byte[] touchCickStart = {
			0x03,0x00,
			0x30,0x00,
			0x0a,0x00,0x00,0x00};
	//Minor axis
	public static byte[] touchCickMinorAxis = {
		0x03, 0x00, 
		0x31, 0x00, 
		0x03, 0x00, 0x00, 0x00};
	//可理解为触摸点大小 
	public static byte[] touchSize = {
			0x03,0x00,
			0x3a,0x00,
			0x46,0x00,0x00,0x00};
	//触摸点x坐标
	public static byte[] touchX = {
			//x的坐标
			0x03,0x00,
			0x35,0x00,
			0x00,0x00,0x00,0x00,//具体y的坐标
	};
	//触摸点y坐标 
	public static byte[] touchY = {
			//y的坐标
			0x03,0x00,
			0x36,0x00,
			0x00,0x00,0x00,0x00,//具体x的坐标
	};
	//触摸点z坐标 
	public static byte[] touchZ = {
			//y的坐标
			0x00,0x00,
			0x02,0x00,
			0x00,0x00,0x00,0x00,//具体z的坐标
	};
	//BTN touch事件开始
	public static byte[] touchBinEventStart = {
		0x01,0x00,
		0x4a,0x01,
		0x01,0x00,0x00,0x00
	};
	//BTN touch事件开始
	public static byte[] touchBin2EventStart = {
		0x01,0x00,
		0x45,0x01,
		0x01,0x00,0x00,0x00
	};
	//事件同步(点击结束)
	public static byte[] touchEvent = {
			0x00,0x00,
			0x00,0x00,
			0x00,0x00,0x00,0x00
	};
	//一次touch结束 
	public static byte[] touchEnd = {
			0x03,0x00,
			0x39,0x00,
			(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff
	};
	//BTN touch事件结束
	public static byte[] touchBinEventEnd = {
		0x01,0x00,
		0x4a,0x01,
		0x00,0x00,0x00,0x00
	};
	
	//BTN2 touch事件结束
	public static byte[] touchBin2EventEnd = {
		0x01,0x00,
		0x45,0x01,
		0x00,0x00,0x00,0x00
	};
	//时间
	public static byte[] time = {
		0x00,0x00,0x00,0x00,
		0x00,0x00,0x00,0x00
	};
	
}
