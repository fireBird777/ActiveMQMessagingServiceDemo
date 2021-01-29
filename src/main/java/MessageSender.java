import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * This class is used to send messages to the queue
 */

public class MessageSender {

    /**
     * Url of the JMS server.DEFAULR_BROKER_URL will just mean that JMS server is on localhost
     * default broker URL: tcp://localhost:61616
     */
    private  static String url= ActiveMQConnection.DEFAULT_BROKER_URL;

    /**
     * creating queue name
     */
    private static String queueName = "MESSAGE_QUEUE";

    public static void main(String[] args) throws JMSException {

        System.out.println("url"+url);

        /**
         * getting JMS connection
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        /**
         * creating session to send receive messages on JMs
         */
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        /**
         * A queue will be created automatically on server
         */
        Destination destination = session.createQueue(queueName);

        /**
         * to create a producer and sending a message
         */
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage("Hello Samira");
        producer.send(textMessage);

        System.out.println("Message "+textMessage.getText()+" Message sent successfully to the queue");
        connection.close();
    }
}
