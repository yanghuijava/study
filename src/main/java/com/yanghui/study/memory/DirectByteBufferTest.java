package com.yanghui.study.memory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectByteBufferTest {
	
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("maxMemoryValue:" + sun.misc.VM.maxDirectMemory()); 
		while(true) {
			ByteBuffer buf = ByteBuffer.allocateDirect(1024 * 1024 * 200);
			Thread.sleep(1000 * 1);
		}
	}
}
