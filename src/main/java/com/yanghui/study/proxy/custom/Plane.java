package com.yanghui.study.proxy.custom;

import java.util.Random;

public class Plane implements IFlyable{

	@Override
	public int fly(int x, int y) {
//		long start = System.currentTimeMillis();
		int result = x * x + y * y;
		try {
			Thread.sleep(new Random().nextInt(700));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("time:" + (System.currentTimeMillis() - start) + "毫秒");
		return result;
	}
}
