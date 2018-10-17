package win.zhangzhixing;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

import static org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

public class CKafkaProducer {
    private final Producer<String,String> producer;
    public final static String TOPIC = "ZZX-TOPIC";
    public CKafkaProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG,"192.168.102.47:9092");
        props.put(KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
    }
    public void produce(){
        int messageNo = 0;
        final int COUNT = 200;
        while (messageNo < COUNT){
            String key = String.valueOf(messageNo);
            String data = "@@@@@hello kafka message"+key;
            producer.send(new ProducerRecord<>(TOPIC,key,data));
            System.out.println(data);
            messageNo++;
        }
    }
    public static void main(String[] args) {
        new CKafkaProducer().produce();
    }
}
