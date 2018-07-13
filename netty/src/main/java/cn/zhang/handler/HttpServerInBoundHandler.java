package cn.zhang.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpServerInBoundHandler extends ChannelInboundHandlerAdapter {
    private HttpRequest request;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof DefaultHttpRequest) {
            request = (HttpRequest) msg;
            String uri = request.uri();
            System.out.println("Uri:" + uri);
        }
        if (msg instanceof HttpContent) {
            String str = ((HttpContent) msg).content().toString(CharsetUtil.UTF_8);
            System.out.println(str.length());
            System.out.println(str);
            HttpResponse httpResponse = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(str.getBytes())
            );
            httpResponse.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            httpResponse.headers().add(HttpHeaderNames.CONTENT_LENGTH, str.length());
            ctx.writeAndFlush(httpResponse);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}