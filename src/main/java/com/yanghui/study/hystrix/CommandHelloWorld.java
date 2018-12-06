package com.yanghui.study.hystrix;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class CommandHelloWorld extends HystrixCommand<String> {
	
	private final String name;

	protected CommandHelloWorld(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4))
				);
		
        this.name = name;
	}

	@Override
	protected String run() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(Thread.currentThread().getName() + "------<<" + this.name + ">>执行开始：" + sdf.format(new Date()));
		Thread.sleep(new Random().nextInt(5) * 1000);
		System.out.println(Thread.currentThread().getName() + "------<<" + this.name + ">>执行结束：" + sdf.format(new Date()));
		return Thread.currentThread().getName() + "------Hello " + name + "!";
	}
	
	@Override
	protected String getFallback() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Thread.currentThread().getName() + "------<<" + this.name + ">>回退结果：" + sdf.format(new Date());
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			CommandHelloWorld cmd = new CommandHelloWorld("Bob-" + i);
			String s = cmd.execute();
			System.out.println(s);
		}
//		Future<String> future = new CommandHelloWorld("Bob").queue();
//		Observable<String> observable = new CommandHelloWorld("Bob").observe();
	}
}
