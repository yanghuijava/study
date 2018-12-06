package com.yanghui.study.classLoader;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader{

	public MyClassLoader(URL[] urls) {
		super(urls);
	}

	@Override
	protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class<?> c = this.findLoadedClass(name);
		if(c == null) {
			try {
				c = this.findClass(name);
			} catch (Exception e) {
			}
		}
		if(c == null) {
			c = super.loadClass(name,resolve);
		}
		return c;
	}
}
