package win.zhangzhixing.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    public static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.6.184");
        factory.setVirtualHost("/zhang");
        factory.setUsername("zhang");
        factory.setPassword("zhang");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(
                QUEUE_NAME, false, false,
                false, null
        );
        String message = "message";
        for (int i = 1; i <= 10; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + "" + i).getBytes());
        }
        channel.close();
        connection.close();
    }
}