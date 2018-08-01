package cn.zhang.server;

import cn.zhang.grpc.CalculatorGrpc;
import cn.zhang.proto.ValueOuterClass;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;


public class BoceServer {

    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private Server server;

    private void start() throws IOException, InterruptedException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new CalculatorImpl())
                .build()
                .start();
        server.awaitTermination();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                BoceServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final BoceServer server = new BoceServer();
        server.start();
        server.blockUntilShutdown();
    }

    public class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase {
        @Override
        public void calculator(ValueOuterClass.Value request, StreamObserver<ValueOuterClass.Value> responseObserver) {
            ValueOuterClass.Value value = ValueOuterClass.Value.newBuilder().setValue(request.getValue() + 10).build();
            responseObserver.onNext(value);
            responseObserver.onCompleted();
        }

        @Override
        public void calculatorServerStream(ValueOuterClass.Value request, StreamObserver<ValueOuterClass.Value> responseObserver) {
            responseObserver.onNext(ValueOuterClass.Value.newBuilder().setValue(request.getValue() + request.getValue()).build());
            responseObserver.onNext(ValueOuterClass.Value.newBuilder().setValue(request.getValue() - request.getValue()).build());
            responseObserver.onNext(ValueOuterClass.Value.newBuilder().setValue(request.getValue() * request.getValue()).build());
            responseObserver.onNext(ValueOuterClass.Value.newBuilder().setValue(request.getValue() / request.getValue()).build());
            responseObserver.onCompleted();

            responseObserver.onNext(ValueOuterClass.Value.newBuilder().setValue(request.getValue() / request.getValue()).build());
            responseObserver.onCompleted();
        }
    }
}
