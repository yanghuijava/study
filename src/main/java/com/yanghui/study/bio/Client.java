package com.yanghui.study.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	static class handle implements Runnable {
		
		private Socket socket;
		
		public handle(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				BufferedWriter w = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				BufferedReader r = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				while(true) {
					w.write("你好：\n");
					w.flush();
					String line = null;
					do {
						line = r.readLine();
					}while(line == null);
					System.out.println("服务器响应数据：" + line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 9099);
		socket.setTcpNoDelay(true);
		System.out.println(" client init ");
		for(int i=0;i<1;i++) {
			new Thread(new handle(socket)).start();
		}
		Thread.sleep(100000000);
		socket.close();
	}
}
