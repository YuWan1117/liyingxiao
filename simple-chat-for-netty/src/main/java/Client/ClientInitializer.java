package Client;

import Message.MessageDecoder;
import Message.MessageEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

public class ClientInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                .addLast(new MessageDecoder())
                .addLast(new MessageEncoder())
                .addLast(new ClientHandler()) ;
    }
}
