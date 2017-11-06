package net.coatli.java.microhelloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyHelloWorldApplication {

  public static void main(final String[] args) throws InterruptedException {

    final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    final EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      final ServerBootstrap server = new ServerBootstrap();
      server.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .option(ChannelOption.SO_BACKLOG, 100)
        .handler(new LoggingHandler(LogLevel.INFO))
        .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(final SocketChannel ch) throws Exception {
              ch.pipeline().addLast(new EchoServerHandler());
            }
          });
      // Start the server.
      final ChannelFuture f = server.bind(8080).sync();
      // Wait until the server socket is closed.
      f.channel().closeFuture().sync();
    } finally {
      // Shut down all event loops to terminate all threads.
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }

  }

}
