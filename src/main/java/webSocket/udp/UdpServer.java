package webSocket.udp;

import webSocket.Common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Lichenyi
 * @date 2017-8-14 0014
 */
public class UdpServer {
    public static int PORT = Common.PORT;
    public static void main(String args[]) {
        try {
            //创建UDPsocket服务端
            DatagramSocket socket = new DatagramSocket(PORT);
            //创建数据报，接收客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            System.out.println("服务器链接成功！");
            //接收客户端发送的收据
            socket.receive(packet);
            //获取客户端的消息
            String str = new String(data, 0, data.length);
            System.out.println("我是服务器，客户端跟我说: " + str);

            //向客户端相应数据
            //获取客户端地址
            InetAddress address = packet.getAddress();
            //获取客户端端口
            int port = packet.getPort();
            //想客户端返回的消息内容
            byte[] responseData = "恭喜你！".getBytes();
            //将即将返回的消息封装为数据包
            DatagramPacket responseDatagramPacket = new DatagramPacket(responseData, responseData.length, address, port);
            //将消息响应到客户端
            socket.send(responseDatagramPacket);
            //关闭socket
            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
