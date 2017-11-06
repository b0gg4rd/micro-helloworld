package net.coatli.java.microhelloworld;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
    ctx.write("Hello World!");
  }

}
