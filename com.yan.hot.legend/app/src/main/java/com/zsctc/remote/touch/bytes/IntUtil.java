package com.zsctc.remote.touch.bytes;
/**
 * int转字节
 *
 */
public class IntUtil {
	public static byte[] toByteArray(int iSource) {
	    byte[] bLocalArr = new byte[4];
	    for (int i = 0; i < 4; i++) {
	        bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
	    }
	    return bLocalArr;
	}

	// 将byte数组bRefArr转为一个整数,字节数组的低位是整型的低字节位
	public static int toInt(byte[] bRefArr) {
	    int iOutcome = 0;
	    byte bLoop;

	    for (int i = 0; i < bRefArr.length; i++) {
	        bLoop = bRefArr[i];
	        iOutcome += (bLoop & 0xFF) << (8 * i);
	    }
	    return iOutcome;
	}
	
	// 将byte数组bRefArr转为一个整数,字节数组的低位是整型的低字节位
	public static int toInt(byte bRef) {
	    int iOutcome = 0;
        iOutcome += bRef & 0xFF;
	    return iOutcome;
	}
}
