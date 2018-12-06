package com.yanghui.study.activemq;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFatory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"tcp://120.77.152.143:61616");
		Connection connection = connectionFatory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("yanghui.queue.test2");
//		Destination destination = session.createTopic("market.shfe.data.topic");
		MessageProducer producer = session.createProducer(null);
		String s = "{\"code\":210200,\"data\":{\"actionDay\":1527868800000,\"actionDayTime\":\"2018-06-02 01:59:59.898\",\"askPrice1\":51255,\"askPrice2\":0,\"askPrice3\":0,\"askPrice4\":0,\"askPrice5\":0,\"askVolume1\":22931,\"askVolume2\":0,\"askVolume3\":0,\"askVolume4\":0,\"askVolume5\":0,\"averagePrice\":0,\"bidPrice1\":51157,\"bidPrice2\":0,\"bidPrice3\":0,\"bidPrice4\":0,\"bidPrice5\":0,\"bidVolume1\":62904,\"bidVolume2\":0,\"bidVolume3\":0,\"bidVolume4\":0,\"bidVolume5\":0,\"closePrice\":0,\"contract\":\"CU\",\"createTime\":\"2018-06-02 01:59:59\",\"currDelta\":0,\"diffUpLow\":41,\"highPrice\":51260,\"id\":0,\"instruId\":\"cu1806\",\"lLimitPrice\":49260,\"lastPrice\":51260,\"lowPrice\":51060,\"marketType\":\"cu\",\"modifyTime\":\"2018-06-02 01:59:59\",\"openInt\":35080,\"openPrice\":51260,\"preCloPrice\":51186,\"preDelta\":0,\"preOpenInt\":51286,\"preSetPrice\":51219,\"setPrice\":0,\"tradDay\":1527868800000,\"turnover\":162878539,\"uLimitPrice\":52192,\"updateTime\":1527875999898,\"volume\":16047},\"message\":\"成功\",\"msg\":\"成功\",\"success\":true}";
		for(int i = 1;i <= 1;i++){
			TextMessage textMessage = session.createTextMessage("我发送的消息，id为：" + i + s);
			long start = System.currentTimeMillis();
			producer.send(destination, textMessage, DeliveryMode.PERSISTENT, i,1000 * 60 * 60);
			long total = System.currentTimeMillis()  - start;
			if (total > 200) {
				System.err.println("发送耗时：" + total + "ms");
			}else {
//				System.out.println("发送耗时：" + total + "ms");
			}
		}
		session.close();
		connection.close();
	}
}
