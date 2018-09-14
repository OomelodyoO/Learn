package cn.zhang.interceptor;

import io.grpc.*;

public class ServerInterruptImpl implements ServerInterceptor {
    public static final Context.Key<String> JWT = Context.key("jwt");


    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        Metadata.Key<String> keyJwt = Metadata.Key.of("jwt", Metadata.ASCII_STRING_MARSHALLER);
        String jwt = headers.get(keyJwt);
        Context context = Context.current().withValue(JWT, jwt);
        System.out.println("static JWT 修改为:" + jwt);
        return Contexts.interceptCall(context, call, headers, next);
    }
}
