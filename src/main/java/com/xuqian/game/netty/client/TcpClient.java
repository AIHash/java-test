package com.xuqian.game.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TcpClient {

	public void connect(String host, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {  
			Bootstrap b = new Bootstrap();  
	            b.group(workerGroup);  
	            b.channel(NioSocketChannel.class);  
	            b.option(ChannelOption.SO_KEEPALIVE, true);  
	            b.handler(new ChannelInitializer<SocketChannel>() {  
	                @Override  
	                public void initChannel(SocketChannel ch) throws Exception {  
	                    ch.pipeline().addLast(new TcpClientHandler());  
	                }  
	            });  
	            
	            // Start the client.  
	            ChannelFuture f = b.connect(host, port).sync();  
	  
	            // Wait until the connection is closed.  
	            f.channel().closeFuture().sync();  
	    } finally {  
//	           workerGroup.shutdownGracefully();
	    }
	}

	public static void main(String[] args) {
		
//		for (int i =0; i <60000; i++) {
			TcpClient client = new TcpClient();  
	        try {
				client.connect("127.0.0.1", 8000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
//		}

	}
}
