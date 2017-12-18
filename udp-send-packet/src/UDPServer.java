import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        // 创建一个数据报socket
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        while(true) {

            // 创建一个数据报packet，可以接受4096大小的字节数组
            DatagramPacket datagramPacket = new DatagramPacket(new byte[16384], 16384);
            // socket接收数据存在packet中
            datagramSocket.receive(datagramPacket);

            // 服务器将接收到的数据转换为String类型，存入msg中
            String msg = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            // 打印出接收数据的地址、端口、内容信息
            System.out.println(datagramPacket.getAddress() + "/" + datagramPacket.getPort() + ":" /*+ msg*/ + "[" + msg.length() + "]");

            // 设置服务器的回复数据，并发送出去
            datagramPacket.setData("I'm server!".getBytes());
            datagramSocket.send(datagramPacket);
        }
    }
}
