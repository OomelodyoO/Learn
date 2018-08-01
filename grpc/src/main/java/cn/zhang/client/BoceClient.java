package cn.zhang.client;

import cn.zhang.grpc.CalculatorGrpc;
import cn.zhang.proto.ValueOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoceClient {
    private static final Logger logger = Logger.getLogger(BoceClient.class.getName());

    private final ManagedChannel channel;
    private final CalculatorGrpc.CalculatorBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public BoceClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    BoceClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = CalculatorGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public void calculator(int i) {
        ValueOuterClass.Value request = ValueOuterClass.Value.newBuilder().setValue(10).build();
        ValueOuterClass.Value response;
        System.out.println("calculator");
        try {
            response = blockingStub.calculator(request);
            System.out.println("" + response.getValue());
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    }

    public void calculatorServerStream(int i) {
        ValueOuterClass.Value request = ValueOuterClass.Value.newBuilder().setValue(10).build();
        Iterator<ValueOuterClass.Value> iterator;
        System.out.println("calculatorServerStream");
        try {
            iterator = blockingStub.calculatorServerStream(request);
            while (iterator.hasNext()) {
                ValueOuterClass.Value value = iterator.next();
                System.out.println("" + value.getValue());
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        BoceClient client = new BoceClient("localhost", 50051);
        try {
            client.calculator(10);
            client.calculatorServerStream(10);
        } finally {
            client.shutdown();
        }
    }
}
