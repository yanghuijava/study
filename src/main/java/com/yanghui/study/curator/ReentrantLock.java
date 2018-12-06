package com.yanghui.study.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ReentrantLock {
	
	private static CuratorFramework client;
	
	static {
		client = CuratorFrameworkFactory.newClient("172.16.24.35:2181", new ExponentialBackoffRetry(1000, 3));
		client.start();
	}
	
	public static InterProcessMutex getLock(String lockPath) {
		InterProcessMutex lock = new InterProcessMutex(client, lockPath);
		return lock;
	}
}
