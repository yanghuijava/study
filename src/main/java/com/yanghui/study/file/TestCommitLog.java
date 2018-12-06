package com.yanghui.study.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Map;

public class TestCommitLog {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		File file = new File("F:\\rocketmq\\store\\commitlog\\00000000000000000000");
		FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
		MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE, 0, 1024 * 1024);
		printAll(mappedByteBuffer);
		Thread.sleep(Integer.MAX_VALUE);
//		printMsg(mappedByteBuffer,2521);
	}
	
	public static void printMsg(MappedByteBuffer mappedByteBuffer,long offset) throws Exception{
		mappedByteBuffer.position((int)offset);
		printMsg(mappedByteBuffer);
	}
	
	public static void printAll(MappedByteBuffer mappedByteBuffer) throws Exception {
		while(true) {
			int msgLh = printMsg(mappedByteBuffer);
			if(msgLh == 0) {
				System.out.println(mappedByteBuffer.position());
				break;
			}
			System.out.println(mappedByteBuffer.position());
			System.out.println("------------------------------------------------------------------------");
		}
	}
	
	public static int printMsg(MappedByteBuffer mappedByteBuffer) throws Exception {
		if(mappedByteBuffer.position() == mappedByteBuffer.capacity()) {
			return 0;
		}
		int msgLh = mappedByteBuffer.getInt();
		if(msgLh == 0) {
			return 0;
		}
		System.out.println("消息的总长度=" + msgLh);
		System.out.println("魔数=" + mappedByteBuffer.getInt());
		System.out.println("crc=" + mappedByteBuffer.getInt());
		System.out.println("queueId=" + mappedByteBuffer.getInt());
		System.out.println("flag=" + mappedByteBuffer.getInt());
		System.out.println("queueOffset=" + mappedByteBuffer.getLong());
		System.out.println("writeOffset=" + mappedByteBuffer.getLong());
		System.out.println("sysFlag=" + mappedByteBuffer.getInt());
		System.out.println("bornTimeastam=" + mappedByteBuffer.getLong());
		
		byte[] bornhostByte = new byte[8];
		mappedByteBuffer.get(bornhostByte);
		ByteBuffer bornhost = ByteBuffer.wrap(bornhostByte);
		byte[] addrByte = new byte[4];
		bornhost.get(addrByte, 0, 4);
		InetAddress inet4Address = Inet4Address.getByAddress(addrByte);
		System.out.println("addr=" + inet4Address.getHostAddress() + ":" + bornhost.getInt());
		
		System.out.println("storeTimeastam=" + mappedByteBuffer.getLong());
		
		byte[] storeHostAddressByte = new byte[8];
		mappedByteBuffer.get(storeHostAddressByte);
		ByteBuffer storeHostAddress = ByteBuffer.wrap(storeHostAddressByte);
		byte[] storeAddressByte = new byte[4];
		storeHostAddress.get(storeAddressByte, 0, 4);
		InetAddress storeAddress = Inet4Address.getByAddress(storeAddressByte);
		System.out.println("storeAddr=" + storeAddress.getHostAddress() + ":" + storeHostAddress.getInt());
		
		System.out.println("reconsumerTime=" + mappedByteBuffer.getInt());
		
		System.out.println("preparedTranctionOffset=" + mappedByteBuffer.getLong());
		
		int bl = mappedByteBuffer.getInt();
		System.out.println("bodyLength=" + bl);
		
		byte[] bodyByte = new byte[bl];
		mappedByteBuffer.get(bodyByte);
		System.out.println("body=" + new String(bodyByte));
		
		int topicLength = mappedByteBuffer.get();
		System.out.println("topicLength=" + topicLength);
		
		byte[] topicByte = new byte[topicLength];
		mappedByteBuffer.get(topicByte);
		System.out.println("topic=" + new String(topicByte));
		
		int properttiesLength = mappedByteBuffer.getShort();
		System.out.println("properttiesLength=" + properttiesLength);
		
		byte[] properttiesByte = new byte[properttiesLength];
		mappedByteBuffer.get(properttiesByte);
		String propertties = new String(properttiesByte,"utf-8");
		System.out.println("propertties=" + propertties);
		
		return msgLh;
	}
	
	
	public static Map<String, String> string2messageProperties(final String properties) {
        Map<String, String> map = new HashMap<String, String>();
        if (properties != null) {
            String[] items = properties.split(String.valueOf(2));
            for (String i : items) {
                String[] nv = i.split(String.valueOf(1));
                if (2 == nv.length) {
                    map.put(nv[0], nv[1]);
                }
            }
        }
        return map;
    }
}
