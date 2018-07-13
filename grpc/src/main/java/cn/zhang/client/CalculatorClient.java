package cn.zhang.client;

import cn.zhang.grpc.CalculatorGrpc;
import cn.zhang.protoModel.ValueOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzhixing on 2017/4/13.
 */
public class CalculatorClient {
    private final ManagedChannel channel;
    private final CalculatorGrpc.CalculatorBlockingStub blockingStub;


    public CalculatorClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();

        blockingStub = CalculatorGrpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void calculator(int i) {
        ValueOuterClass.Value value = ValueOuterClass.Value.newBuilder().setValue(i).build();
        ValueOuterClass.Value retValue = blockingStub.calculator(value);
        System.out.println(retValue.toString());

    }

    public static void main(String[] args) throws InterruptedException {
        CalculatorClient client = new CalculatorClient("127.0.0.1", 50051);
        for (int i = 0; i < 100; i++) {
            client.calculator(i);
        }


    }
}
