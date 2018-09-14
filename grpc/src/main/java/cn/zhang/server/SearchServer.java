package cn.zhang.server;

import cn.zhang.grpc.SearchGrpc;
import cn.zhang.interceptor.ServerInterruptImpl;
import cn.zhang.proto.DomainProto;
import cn.zhang.proto.IpProto;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SearchServer {

    private static final Map<String, String> ipMap;

    static {
        ipMap = new HashMap<String, String>();
        ipMap.put("a", "1");
        ipMap.put("b", "2");
        ipMap.put("c", "3");
        ipMap.put("d", "4");
        ipMap.put("e", "5");
        ipMap.put("f", "6");
        ipMap.put("g", "7");
        ipMap.put("h", "8");
    }


    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private Server server;

    private void start() throws IOException, InterruptedException {
        /* The port on which the server should run */
        int port = 50051;
//        .addService(ServerInterceptors.intercept(IUserAuthServiceGrpc.bindService(new UserAuthServiceImpl(context)), new UserAuthServerInsterceptor(context)))
        server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(new SearchServer.SearchImpl(), new ServerInterruptImpl()))
                .build()
                .start();
        server.awaitTermination();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                SearchServer.this.stop();
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

    public class SearchImpl extends SearchGrpc.SearchImplBase {
        @Override
        public void search(DomainProto.Domain request, StreamObserver<IpProto.IP> responseObserver) {
            if (ServerInterruptImpl.JWT.get().equals("thread-1")) {
                System.out.println("thread-1睡1秒");
                try {
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-1" + ServerInterruptImpl.JWT.get());
            } else {
                System.out.println("thread-2" + ServerInterruptImpl.JWT.get());
            }
            IpProto.IP ip = IpProto.IP.newBuilder().setIp(ipMap.get(request.getName())).build();
            responseObserver.onNext(ip);
            responseObserver.onCompleted();
        }

        @Override
        public void searchServerStream(DomainProto.Domain request, StreamObserver<IpProto.IP> responseObserver) {
            responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(request.getName())).build());
            responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(request.getName())).build());
            responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(request.getName())).build());
            responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(request.getName())).build());
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<DomainProto.Domain> searchClientStream(StreamObserver<IpProto.IP> responseObserver) {
            return new StreamObserver<DomainProto.Domain>() {
                List<DomainProto.Domain> list = new ArrayList<>();

                @Override
                public void onNext(DomainProto.Domain value) {
                    list.add(value);
                    responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(value.getName())).build());
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }

        @Override
        public StreamObserver<DomainProto.Domain> searchServerClientStream(StreamObserver<IpProto.IP> responseObserver) {
            return new StreamObserver<DomainProto.Domain>() {
                @Override
                public void onNext(DomainProto.Domain value) {
                    responseObserver.onNext(IpProto.IP.newBuilder().setIp(ipMap.get(value.getName())).build());
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final SearchServer server = new SearchServer();
        server.start();
        server.blockUntilShutdown();
    }
}