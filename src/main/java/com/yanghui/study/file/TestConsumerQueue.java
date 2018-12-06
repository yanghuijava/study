package com.yanghui.study.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class TestConsumerQueue {

	public static void main(String[] args) throws Exception{
		File file = new File("F:\\rocketmq\\store\\consumequeue\\TopicTest\\0\\00000000000000000000");
		FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
		MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE, 0, 1024 * 1024 * 6);
		long l1 = mappedByteBuffer.getLong();
		int i1 = mappedByteBuffer.getInt();
		long l2 = mappedByteBuffer.getLong();
		System.out.println(l1 + "==" + i1 + "==" + l2);
		System.out.println("00000000000000000000".length());
		System.out.println((long)(1024 * 1024 * 1024) * 2);
	}
}
