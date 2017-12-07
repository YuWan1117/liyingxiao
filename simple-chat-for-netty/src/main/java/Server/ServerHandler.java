package Server;

import Message.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE) ;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        Channel incoming = ctx.channel() ;      //获取当前输入信息的客户端管道

        for ( Channel ch : channels ) {
            if (ch != incoming) {               //给其他客户端广发该message
                ch.writeAndFlush(message) ;
            }
        }
    }

    @Override
    public void handlerAdded ( ChannelHandlerContext ctx ) throws Exception {
        Channel incoming = ctx.channel() ;

        for (Channel ch : channels) {
            channels.writeAndFlush(Message.newStatusMsg("[SERVER] - " + incoming.remoteAddress() + "   LoginIn.")) ;
        }

        channels.add(incoming) ;
    }

    @Override
    public void handlerRemoved ( ChannelHandlerContext ctx ) throws Exception {
        Channel incoming = ctx.channel() ;

        for (Channel ch : channels) {
            if (ch != incoming) {
                channels.writeAndFlush(Message.newStatusMsg("[SERVER] - " + incoming.remoteAddress() + "  LoginOut."));
            }
        }

        ctx.close() ;
        // incoming.close() ;
        // channels.add(incoming) ;
    }

    @Override
    public void channelActive (ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel() ;

        //在服务端显示各客户端状态
        System.out.println ("Client: " + incoming.remoteAddress() + "   online.\n") ;
    }

    @Override
    public void channelInactive (ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel() ;

        //在服务端显示各客户端状态
        System.out.println ("Client: " + incoming.remoteAddress() + "   offline.\n") ;
    }

    @Override
    public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel() ;

        //在服务端显示各客户端状态
        System.out.println ("Client: " + incoming.remoteAddress() + "   throwException.\n") ;

        cause.printStackTrace();
        ctx.close() ;
    }
}
