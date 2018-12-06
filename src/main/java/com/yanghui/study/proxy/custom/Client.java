package com.yanghui.study.proxy.custom;

import java.lang.reflect.Method;

public class Client {
	
	public static void main(String[] args) {
		Plane plane = new Plane();
		IFlyable flyable = (IFlyable)Proxy.newProxyInstance(IFlyable.class,new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				long start = System.currentTimeMillis();
				Object result = method.invoke(plane, args);
				System.out.println("time:" + (System.currentTimeMillis() - start) + "毫秒");
				return result;
			}
		});
		System.out.println(flyable.fly(1, 2));
	}
}
