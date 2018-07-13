package cn.zhang.server;

import cn.zhang.grpc.CalculatorGrpc;
import cn.zhang.protoModel.ValueOuterClass;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * Created by zhangzhixing on 2017/4/13.
 */
public class CalculatorServer {
    private int port = 50051;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new CalculatorImpl())
                .build()
                .start();

        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {

                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                CalculatorServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        final CalculatorServer server = new CalculatorServer();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase {
        @Override
        public void calculator(ValueOuterClass.Value request, StreamObserver<ValueOuterClass.Value> responseObserver) {
            ValueOuterClass.Value value = ValueOuterClass.Value.newBuilder().setValue(request.getValue()).build();
            responseObserver.onNext(value);
            responseObserver.onCompleted();
        }
    }
}
