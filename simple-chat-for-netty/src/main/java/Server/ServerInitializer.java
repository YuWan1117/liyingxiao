package Server;

import Message.MessageDecoder;
import Message.MessageEncoder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new MessageDecoder())
                .addLast(new MessageEncoder())
                .addLast(new ServerHandler()) ;

        System.out.println ("Client: " + socketChannel.remoteAddress() + "登陆\n");
    }

}
