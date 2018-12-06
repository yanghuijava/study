package com.yanghui.study.feign;

import java.lang.reflect.Type;

import feign.Response;
import feign.ResponseInterceptor;
import feign.Util;

public class MyResponseInterceptorImpl implements ResponseInterceptor {

	@Override
	public byte[] intercept(Response response,Type type) throws Exception {
		byte[] bodyData = Util.toByteArray(response.body().asInputStream());
		if(response.status() == 200) {
			String data = new String(bodyData);
			data = data + "------";
			return data.getBytes();
		}
		return bodyData;
	}
}
