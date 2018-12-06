package com.yanghui.study.ribbon;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

public class RuleTest {
	
	private static AtomicInteger nextServerCyclicCounter;

	public static void main(String[] args) throws InterruptedException {
		nextServerCyclicCounter = new AtomicInteger(0);
		for(int i=0;i<9;i++) {
			roundRobinRule();
			Thread.sleep(1000);
		}
	}
	
	public static void roundRobinRule() {
		
		String server = null;
		int count = 0;
		while(server == null && count++ < 10) {
			List<String> reachableServers = Lists.newArrayList("A1","A2","A3","A4");
            List<String> allServers = Lists.newArrayList("A1","A2","A3","A4");
            int upCount = reachableServers.size();
            int serverCount = allServers.size();
            
            int nextServerIndex = incrementAndGetModulo(serverCount);
            server = allServers.get(nextServerIndex);
            if(server != null) {
            	System.out.println(server);
            	break;
            }
		}
	}
	
	private static int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }
}
