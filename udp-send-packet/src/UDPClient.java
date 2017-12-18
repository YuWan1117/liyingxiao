import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        String msg = "hello";
        byte[] buffer = msg.getBytes();
        System.out.println("length : " + buffer.length);
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, 8080);
        datagramSocket.send(datagramPacket);

        // 接收数据，首先创建一个接收数据的packet，然后接收数据，最后打印出接收到的数据
        DatagramPacket inputPacket = new DatagramPacket(new byte[512], 512);
        datagramSocket.receive(inputPacket);
        System.out.println(new String(inputPacket.getData(), 0, inputPacket.getLength()));
        datagramSocket.close();
    }
}

