package com.xuqian.game.netty.server;

import java.net.InetSocketAddress;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TcpServerHandler extends ChannelInboundHandlerAdapter{
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {
    	InetSocketAddress insocket = (InetSocketAddress) ctx.channel()
                    .remoteAddress();
    	System.out.println("" + insocket.getAddress().getHostAddress());
    }  
  
    @Override  
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {  
        ctx.flush();  
    }  
}
