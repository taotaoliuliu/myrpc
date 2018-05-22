package com.nettyrpc.test.future;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.nettyrpc.protocol.RpcResponse;

public class Test2 extends SimpleChannelInboundHandler<RpcResponse>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, RpcResponse msg)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
