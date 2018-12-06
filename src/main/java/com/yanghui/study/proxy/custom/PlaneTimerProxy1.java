package com.yanghui.study.proxy.custom;

public class PlaneTimerProxy1 extends Plane{

	@Override
	public int fly(int x, int y) {
		long start = System.currentTimeMillis();
		int result = super.fly(x, y);
		System.out.println("time:" + (System.currentTimeMillis() - start) + "毫秒");
		return result;
	}
}
