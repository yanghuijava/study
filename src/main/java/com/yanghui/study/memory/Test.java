package com.yanghui.study.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("C:\\\\Users\\\\think\\\\store\\\\commitlog\\\\00000000000000000000");
		byte[] b = new byte[1024 * 1024];
		in.read(b);
		Thread.sleep(Integer.MAX_VALUE);
	}
}
