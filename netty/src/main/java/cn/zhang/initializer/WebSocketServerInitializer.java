package cn.zhang.initializer;

import cn.zhang.handler.WebSocketInBoundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //  相当于HttpRequestDecoder HttpResponseEncoder
        //  pipeline.addLast(new HttpRequestDecoder());
        //  pipeline.addLast(new HttpResponseEncoder());
        pipeline.addLast(new HttpServerCodec());

        //  主要用于处理大数据流 比如一个1G大小的文件如果你直接传输肯定会撑暴jvm内存的 增加ChunkedWriteHandler 这个handler我们就不用考虑这个问题了
        pipeline.addLast(new ChunkedWriteHandler());

        //  太大的HTTP包发送的时候是要被切分成好几段的 发送之后接收就变得很麻烦 HttpObjectAggregator合成一个
        pipeline.addLast(new HttpObjectAggregator(1024 * 1024));

        //  ws://server:port/context_path
        //  ws://localhost:9999/ws
        //  参数指的是contex_path
        //  WebSocketServerProtocolHandler它对整个websocket的通信进行了初始化，包括握手，以及以后的一些通信控制
        pipeline.addLast(new WebSocketServerProtocolHandler("/www"));

        //  自己的handler
        pipeline.addLast(new WebSocketInBoundHandler());
    }
}
