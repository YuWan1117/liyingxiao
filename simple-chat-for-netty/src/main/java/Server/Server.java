package Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    private Server(){}

    public static void main (String[] args) {
        try {
            new Server().run (7911) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run ( int port ) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup() ;
        EventLoopGroup worker = new NioEventLoopGroup() ;

        try {
            ServerBootstrap bootstrap = new ServerBootstrap() ;

            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.SO_KEEPALIVE, true) ;

            ChannelFuture channelFuture = bootstrap.bind( port ).sync() ;

            channelFuture.channel().closeFuture().sync() ;
        } finally {
            worker.shutdownGracefully() ;
            boss.shutdownGracefully() ;
            System.out.println ("Server Over!\n");
        }
    }
}
