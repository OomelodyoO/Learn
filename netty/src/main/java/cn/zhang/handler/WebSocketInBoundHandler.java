package cn.zhang.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;


public class WebSocketInBoundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof TextWebSocketFrame) {
            String str = ((TextWebSocketFrame) msg).text();
            ctx.channel().writeAndFlush(new TextWebSocketFrame("处理" + str + "是完成!"));
        }
    }
}