package cn.zhang.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetAddress;

public class ServerInBoundHandlerTwo extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);
        ctx.writeAndFlush("ServerInBoundHandlerTwo 已经接收信息 !\n");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("欢迎使用 " + InetAddress.getLocalHost().getHostName() + " 服务!\n");
        super.channelActive(ctx);
    }
}