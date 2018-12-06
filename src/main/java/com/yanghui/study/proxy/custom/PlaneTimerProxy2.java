package com.yanghui.study.proxy.custom;

public class PlaneTimerProxy2 implements IFlyable{
	
	private IFlyable flyable;
	
	public PlaneTimerProxy2(IFlyable flyable) {
		this.flyable = flyable;
	}

	@Override
	public int fly(int x, int y) {
		long start = System.currentTimeMillis();
		int result = this.flyable.fly(x, y);
		System.out.println("time:" + (System.currentTimeMillis() - start) + "毫秒");
		return result;
	}
}
