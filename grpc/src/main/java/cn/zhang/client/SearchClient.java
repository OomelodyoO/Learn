package cn.zhang.client;

import cn.zhang.grpc.SearchGrpc;
import cn.zhang.proto.DomainProto;
import cn.zhang.proto.IpProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchClient {
    private static final Logger logger = Logger.getLogger(SearchClient.class.getName());

    private final ManagedChannel channel;
    private final SearchGrpc.SearchBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public SearchClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    SearchClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = SearchGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public String search(String s) {
        DomainProto.Domain request = DomainProto.Domain.newBuilder().setName(s).build();
        IpProto.IP response = null;
        try {
            response = blockingStub.search(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
        return response.getIp();
    }

    public void searchServerStream(String s) {
        DomainProto.Domain request = DomainProto.Domain.newBuilder().setName(s).build();
        Iterator<IpProto.IP> iterator;
        try {
            iterator = blockingStub.searchServerStream(request);
            while (iterator.hasNext()) {
                IpProto.IP ip = iterator.next();
                System.out.print(ip);
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        SearchClient client = new SearchClient("localhost", 50051);
        try {
            System.out.println(client.search("a"));
            System.out.println("searchServerStream:");
            client.searchServerStream("b");
        } finally {
            client.shutdown();
        }
    }
}
