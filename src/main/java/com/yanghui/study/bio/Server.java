package com.yanghui.study.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
	
	static class handle implements Runnable {
		
		private Socket socket;
		
		public handle(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				System.out.println("连接上来了：" + socket);
				BufferedWriter w = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				BufferedReader r = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				while(true) {
					String line = null;
					do {
						line = r.readLine();
					}while(line == null);
					System.out.println("收到客户端数据：" + line);
					Thread.sleep(new Random().nextInt(10) * 1000);
					w.write("你也好啊!\n");
					w.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9099);
			System.out.println("server init.......");
			while(true) {
				try {
					Socket socket = server.accept();
					new Thread(new handle(socket)).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
