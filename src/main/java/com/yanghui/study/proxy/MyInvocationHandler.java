package com.yanghui.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyInvocationHandler implements InvocationHandler {
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("---");
		return "ooo";
	}
	
	public Object getProxy() {  
		Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(),   
				new Class<?>[] {IUserService.class}, this);
        return o;
    } 
	
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
		MyInvocationHandler my = new MyInvocationHandler();
		IUserService us = (IUserService)my.getProxy();
//		System.out.println(us);
		System.out.println(us.getName());
		us.add("uu");
	}
	
	@Data
	static class Target<T> {
		private Class<T> type;

		public Target(Class<T> type) {
			this.type = type;
		}
	}
}
