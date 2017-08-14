package webSocket.tcp;

import webSocket.Common;

import java.io.*;
import java.net.Socket;

/**
 * tcp 客户端
 * @author Lichenyi
 * @date 2017-8-14 0014
 */
public class TcpClient {
    private static int PORT = Common.PORT;
    private static String IP = "127.0.0.1";
    public static void main(String args[]) {
        try {
            //创建客户端socket
            Socket socket = new Socket(IP, PORT);
            //获取输出流向服务器发送信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("大家好， 我是TCP Frank!");
            printWriter.flush();
            socket.shutdownOutput();

            //获取输入流，并读取服务器端的响应信息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println("我是客户端，服务器说：" + str);
            }

            //关闭资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
