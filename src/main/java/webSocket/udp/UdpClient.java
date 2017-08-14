package webSocket.udp;

import webSocket.Common;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP客户端
 * @author Lichenyi
 * @date 2017-8-14 0014
 */
public class UdpClient {
    public static int PORT = Common.PORT;
    public static void main(String args[]) {
        try {
            //创建UDPsocket服务端
            DatagramSocket socket = new DatagramSocket(PORT);

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
