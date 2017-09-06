package org.xtwy.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {
	
	private int port;

    public DiscardServer(int port) {
        this.port = port;
    }
    
    public void run() throws Exception{
    	EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class) 
			.childHandler(new MyChannelInitializer())
			.option(ChannelOption.SO_BACKLOG, 128)
			 .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
			ChannelFuture f = b.bind(port).sync(); // (7)
			f.channel().closeFuture().sync();
		} finally{
			 workerGroup.shutdownGracefully();
			  bossGroup.shutdownGracefully();
		}
    }

    
    public static void main(String[] args) throws Exception {
        int port=8999;
        new DiscardServer(port).run();
    }
}
