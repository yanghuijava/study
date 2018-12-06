package com.yanghui.study.classLoader;

import java.net.URL;
import java.time.chrono.IsoEra;

import com.yanghui.clplug.PlugManager;
import com.yanghui.clplug.api.IUserService;

import junit.framework.Test;

public class ClassLoaderTest {
	
	private static String classDir="D:\\workspace\\study\\target\\classes\\";
//	private static String classDir="F:\\file\\jars\\cl-model1-0.0.1-SNAPSHOT.jar";

	public static void main(String[] args) throws Exception {
//		MyClassLoader classLoader1 = new MyClassLoader(new URL[] {new URL("file:" + classDir)});
//		Class<?> clz1 = classLoader1.loadClass("com.yanghui.study.classLoader.Worker");
//		System.out.println(clz1.getClassLoader());
//		
//		
//		MyClassLoader classLoader2 = new MyClassLoader(new URL[] {new URL("file:" + classDir)});
//		Class<?> clz2 = classLoader2.loadClass("com.yanghui.study.classLoader.Worker");
//		System.out.println(clz2.getClassLoader());
//		
//		classLoader1.close();
//		classLoader2.close();
		
		PlugManager plugManager = PlugManager.getInstace();
		plugManager.init();
		
		IUserService us = plugManager.getPlug("com.yanghui.clmodel1.impl.UserServiceImpl", IUserService.class);
		us.save("yanghui");
		System.out.println(us.get("zengchang"));
		
	}
}
