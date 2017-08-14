package webSocket.udp;

import webSocket.Common;

import java.io.IOException;
import java.net.*;

/**
 * UDP客户端
 * @author Lichenyi
 * @date 2017-8-14 0014
 */
public class UdpClient {
    public static void main(String args[]) {
        try {
            //定义服务器的地址、端口和即将发送的数据
            //地址
            InetAddress address = InetAddress.getByName("localhost");
            //端口
            int port = Common.PORT;
            //书据
            byte[] data = "大家好， 我是UDP Frank!".getBytes();

            //创建数据包
            DatagramPacket sendDatagramPacket = new DatagramPacket(data, data.length, address, port);
            //创建socket
            DatagramSocket socket = new DatagramSocket();
            //向服务器发送数据
            socket.send(sendDatagramPacket);

            //接收服务器响应的数据
            //创建byte用来接收数据
            byte[] receive = new byte[1024];
            //创建接收返回消息的数据包
            DatagramPacket receiveDatagramPacket = new DatagramPacket(receive, receive.length);
            //接受返回消息
            socket.receive(receiveDatagramPacket);
            String reply = new String(receive, 0, receiveDatagramPacket.getLength());
            //打印返回消息
            System.out.println("服务端回复: " + reply);
            //socket关闭
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
