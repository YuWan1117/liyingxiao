package Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(message.getHead_tag()) ;
        byteBuf.writeInt(message.getType()) ;
        byteBuf.writeInt(message.getLength()) ;
        byteBuf.writeBytes(message.getContent()) ;
    }
}
