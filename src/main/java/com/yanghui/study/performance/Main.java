package com.yanghui.study.performance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class Main {
	
	public static void main(String[] args) throws SigarException, IOException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		System.out.println("总内存：" + (double)mem.getTotal() / (1024L * 1024L * 1024L) + "G");
		System.out.println("已使用内存：" + (double)mem.getUsed() / (1024L * 1024L * 1024L) + "G");
		System.out.println("空闲内存：" + (double)mem.getFree() / (1024L * 1024L * 1024L) + "G");
		
		CpuInfo[] cpuInfos = sigar.getCpuInfoList();
		System.out.println("当前机器拥有的cpu数：" + cpuInfos.length);
		
		Process p = Runtime.getRuntime().exec("jstat -gc 12992 1000 10");
		InputStream fis= p.getInputStream();    
        //用一个读输出流类去读    
         InputStreamReader isr=new InputStreamReader(fis);
        //用缓冲器读行    
         BufferedReader br=new BufferedReader(isr);    
         String line=null;    
        //直到读完为止    
        while((line=br.readLine())!=null)    
         {    
             System.out.println(line);    
         }    
	}
}
