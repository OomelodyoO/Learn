package cn.zhang.initializer;

import cn.zhang.handler.HttpClientInBoundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

public class HttpClientInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpRequestEncoder());//客户端对发送的httpRequest进行编码
        pipeline.addLast(new HttpResponseDecoder());//客户端需要对服务端返回的httpresopnse解码
        pipeline.addLast(new HttpClientInBoundHandler());
    }
}
