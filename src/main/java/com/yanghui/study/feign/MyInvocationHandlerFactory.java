package com.yanghui.study.feign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import feign.InvocationHandlerFactory;
import feign.Target;

public class MyInvocationHandlerFactory implements InvocationHandlerFactory{

	@Override
	public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
		return new MyInvocationHandler(target, dispatch);
	}
}
