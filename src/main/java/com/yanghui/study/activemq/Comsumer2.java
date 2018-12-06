package com.yanghui.study.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

public class Comsumer2 {

	public static void main(String[] args) throws Exception{
		ActiveMQConnectionFactory connectionFatory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"tcp://120.77.152.143:61616");
		
		RedeliveryPolicy policy = new RedeliveryPolicy();
	    policy.setInitialRedeliveryDelay(3000);  
	    policy.setBackOffMultiplier(1);

	    policy.setUseExponentialBackOff(true);  
	    policy.setMaximumRedeliveries(-1);
	    policy.setRedeliveryDelay(5000);
	    connectionFatory.setRedeliveryPolicy(policy);
		Connection connection = connectionFatory.createConnection();
		connection.start();
		final Session session = connection.createSession(Boolean.FALSE,Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("yanghui.queue.test2");
//		Destination destination = session.createTopic("market.shfe.data.topic");
		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					TextMessage tm = (TextMessage)message;
					System.out.println("收到的消息：" + tm.getText());
//					int i = 1/0;
					tm.acknowledge();
				} catch (Exception e) {
					e.printStackTrace();
					try {
						session.recover();
					} catch (JMSException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
//		connection.close();
	}
}
