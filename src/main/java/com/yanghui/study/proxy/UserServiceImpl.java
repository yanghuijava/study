package com.yanghui.study.proxy;

public class UserServiceImpl implements IUserService {

	@Override
	public String getName() {
		return "yanghui";
	}

	@Override
	public void add(String name) {
		System.out.println(name);
	}
}
