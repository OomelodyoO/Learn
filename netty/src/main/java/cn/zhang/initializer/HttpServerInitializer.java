package cn.zhang.initializer;

import cn.zhang.handler.HttpServerInBoundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //  相当于HttpRequestDecoder HttpResponseEncoder
        //  pipeline.addLast(new HttpRequestDecoder());
        //  pipeline.addLast(new HttpResponseEncoder());
        pipeline.addLast(new HttpServerCodec());

        //  太大的HTTP包发送的时候是要被切分成好几段的 发送之后接收就变得很麻烦 HttpObjectAggregator合成一个
        pipeline.addLast(new HttpObjectAggregator(1024 * 1024));

        //  自己的handler
        pipeline.addLast(new HttpServerInBoundHandler());
    }
}
