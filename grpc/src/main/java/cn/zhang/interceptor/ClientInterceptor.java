package cn.zhang.interceptor;

import io.grpc.*;

public class ClientInterceptor implements io.grpc.ClientInterceptor {

    public static String jwt = "thread";

    Metadata.Key<String> keyJwt = Metadata.Key.of("jwt", Metadata.ASCII_STRING_MARSHALLER);


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                //此处为你登录后获得的token的值
                System.out.println("headers.put(keyJwt, Thread.currentThread().getName()):\t" + Thread.currentThread().getName());
                headers.put(keyJwt, Thread.currentThread().getName());
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onHeaders(Metadata headers) {
                        /**
                         * if you don't need receive header from server, you can
                         * use {@link io.grpc.stub.MetadataUtils#attachHeaders}
                         * directly to send header
                         */
                        super.onHeaders(headers);
                    }
                }, headers);
            }
        };
    }
}