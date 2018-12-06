package com.yanghui.study.algorithm.sort;

public class IPStringToInt {

	public static void main(String[] args) {
		String ip = "192.168.30.252";
		ipStringToInt(ip);
	}
	
	public static long ipStringToInt(String ip) {
		String[] ins = ip.split("\\.");
		long result = 0;
		if(ins == null || ins.length != 4) {
			throw new RuntimeException("ip地址不合规范");
		}
		for(int i=0;i<ins.length;i++) {
			long k = Long.valueOf(ins[i].trim());
			if(k > 255L) {
				throw new RuntimeException("ip地址不合规范");
			}
			long j = Long.valueOf(ins[i].trim()).longValue() << (3 - i) * 8;
			result = result + j;
		}
		System.out.println(result);
		return result;
	}
}
