package com.xuqian.game.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TcpClientHandler extends ChannelInboundHandlerAdapter {
    
    // ����server�˵���Ϣ������ӡ����  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  

        System.out.println("TcpClientHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;  
        byte[] result1 = new byte[result.readableBytes()];  
        result.readBytes(result1);  
        System.out.println("Server said:" + new String(result1));  
        result.release();  
    }  
  
    // ���ӳɹ�����server������Ϣ  
    @Override  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  

        System.out.println("TcpClientHandler.channelActive");
        String msg = "clent";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());  
        encoded.writeBytes(msg.getBytes());  
        ctx.write(encoded);  
        ctx.flush();
        
    }  
}
