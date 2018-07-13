package cn.zhang.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class ServerOutBoundHandlerTwo extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);
        ctx.writeAndFlush("ServerOutBoundHandlerTwo 已经接收信息 !\n");
        super.write(ctx, msg, promise);
    }
}
