package Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    // 设置数据包的基准长度
    private final int BASE_LENGTH = 4 + 4 + 4 ;


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableLength = byteBuf.readableBytes() ;

        /**
         * 对于数据包长度的检验，并做出对应的处理。
         */
        if ( readableLength >= BASE_LENGTH ) {
            if (readableLength > 2048) {
                byteBuf.skipBytes(readableLength) ;
            }

            int beginReader ;

            while (true) {
                beginReader = byteBuf.readerIndex() ;   //获取开始读的下标
                byteBuf.markReaderIndex() ;             //标记开始读的下标

                //当读到开始标记时结束循环
                if (byteBuf.readInt() == ConstantValue.HEAD_TAG) {
                    break ;
                }

                byteBuf.resetReaderIndex() ;            //重设读下标
                byteBuf.readByte() ;                    //读取byte
                if (byteBuf.readableBytes() < BASE_LENGTH) {
                    return ;
                }
            }

            int type = byteBuf.readInt() ;
            int length = byteBuf.readInt() ;
            if (byteBuf.readableBytes() < length) {     //长度不符合要求时，结束
                byteBuf.readerIndex(beginReader) ;
                return ;
            }

            byte[] data = new byte[length] ;            //长度吻合则创建这么大的数据对象获取数据
            byteBuf.readBytes(data) ;

            //重建Message对象
            Message msg = Message.reconstructMsg(data, type) ;

            list.add(msg) ;                             //添加到list中
        }
    }
}
