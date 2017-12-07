package Message;

import java.util.Arrays;

public class Message {
    private int head_tag = ConstantValue.HEAD_TAG ;

    private int type ;

    private int length ;

    private byte[] content ;


    /**
     * 构造函数实现
     */
    private Message () {}

    private Message ( String content, int type ) {
        this.content = content.getBytes() ;
        this.length = this.content.length ;
        this.type = type ;
    }

    /**
     * 设置type类型
     */
    public static Message newSysMsg ( String string ) {
        return newMsg ( string, ConstantValue.SYSTEM_MSG );
    }

    public static Message newStatusMsg ( String string ) {
        return newMsg ( string, ConstantValue.STATUS_MSG ) ;
    }

    public static Message newUsrMsg ( String string ) {
        return newMsg ( string, ConstantValue.USER_MSG ) ;
    }

    public static Message newMsg ( String string, int type ) {
        return new Message ( string, type ) ;
    }

    /**
     * 重建Message对象
     * @param data
     * @param type
     * @return
     */
    public static Message reconstructMsg ( byte[] data, int type ) {
        Message msg = new Message() ;

        msg.length = data.length ;
        msg.content = data ;
        msg.type = type ;

        return msg ;
    }

    /**
     * get方法的实现
     * @return
     */

    public int getHead_tag () {
        return head_tag ;
    }

    public int getType () {
        return type ;
    }

    public int getLength() {
        return length ;
    }

    public byte[] getContent() {
        return content ;
    }

    /**
     * toString()方法的重写
     * 以换行符作为信息的分段
     * @return
     */
    @Override
    public String toString() {
        return "Message{\n" +
                "\ttype:\t" + (type == 1 ? "状态信息\n" : "非状态信息\n") +
                "\tcontent:\t" + new String(content) +
                "\n}\n";
    }
}
