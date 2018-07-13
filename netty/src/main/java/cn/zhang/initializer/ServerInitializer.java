package cn.zhang.initializer;

import cn.zhang.handler.ServerInBoundHandlerOne;
import cn.zhang.handler.ServerInBoundHandlerTwo;
import cn.zhang.handler.ServerOutBoundHandlerOne;
import cn.zhang.handler.ServerOutBoundHandlerTwo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // ChannelInboundHandlerAdapter
        pipeline.addLast("oneInHandler", new ServerInBoundHandlerOne());
        pipeline.addLast("oneOutHandler", new ServerOutBoundHandlerOne());
        pipeline.addLast("twoOutHandler", new ServerOutBoundHandlerTwo());
        pipeline.addLast("twoInHandler", new ServerInBoundHandlerTwo());
    }
}
