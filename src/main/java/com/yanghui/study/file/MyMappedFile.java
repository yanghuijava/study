package com.yanghui.study.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MyMappedFile {
	
	private File file;
	private String fileName;
	private MappedByteBuffer mappedByteBuffer;
	private long fileSize;
	private FileChannel fileChannel;
	@Setter(value=AccessLevel.NONE)
	AtomicInteger wrotePosition = new AtomicInteger(0);
	
	
	public MyMappedFile(String fileName, long fileSize) throws IOException {
		init(fileName, fileSize);
	}
	
	private void ensureDirOK(String dirName) {
		if(dirName != null) {
			File file = new File(dirName);
			if(!file.exists()) {
				file.mkdirs();
			}
		}
	}
	
	@SuppressWarnings("resource")
	private void init(String fileName, long fileSize) throws IOException {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.file = new File(fileName);
		
		this.ensureDirOK(file.getParent());
		
		this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
		this.mappedByteBuffer = this.fileChannel.map(MapMode.READ_WRITE, 0, this.fileSize);
	}
	
	
	
	public int put(byte[] data) {
		this.mappedByteBuffer.position(this.wrotePosition.get());
		this.mappedByteBuffer.putInt(data.length);
		this.mappedByteBuffer.put(data);
		int position = this.mappedByteBuffer.position();
		return position;
	}
	
	public void destroy() throws IOException {
		this.fileChannel.close();
	}
	
	
	public void setWrotePosition(int pos) {
		this.wrotePosition.set(pos);
	}


	public static class Jtest{
		
		/**
		 * length=8 offset=12
		 */
		
		@Test
		public void test1() throws IOException {
			MyMappedFile mmf = new MyMappedFile("f:/file/00000000000000000000", 1024 * 1024);
			mmf.getWrotePosition().set(0);
			String s = "yanghui3";
			System.out.println("length=" + s.length());
			int offset = mmf.put(s.getBytes("utf-8"));
			System.out.println("offset=" + offset);
			mmf.destroy();
		}
		
		@Test
		public void test2() throws IOException {
			MyMappedFile mmf = new MyMappedFile("f:/file/00000000000000000000", 1024 * 1024);
			byte[] data = new byte[8];
			mmf.getMappedByteBuffer().position(12 - data.length);
			mmf.mappedByteBuffer.get(data);
			System.out.println(new String(data,"utf-8"));
		}
		
		@Test
		public void test3() throws IOException {
			MyMappedFile mmf = new MyMappedFile("f:/file/00000000000000000000", 1024 * 1024);
			int a = mmf.getMappedByteBuffer().getInt();
			System.out.println(a);
			byte[] data = new byte[a];
			mmf.getMappedByteBuffer().get(data);
			System.out.println(new String(data,"utf-8"));
			a = mmf.getMappedByteBuffer().getInt();
			System.out.println(a);
		}
	}
}
