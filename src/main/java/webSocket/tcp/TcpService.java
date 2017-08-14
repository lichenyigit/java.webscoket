package webSocket.tcp;

import webSocket.Common;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp 服务端
 * @author Lichenyi
 * @date 2017-8-9 0009
 */
public class TcpService {
    public static int PORT = Common.PORT;
    public static void main(String args[]) {
        try {
            //绑定端口
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("服务器链接成功");
            //开始监听，等待客服端的链接
            Socket server = serverSocket.accept();

            //获取客户端的输出流信息
            InputStream inputStream = server.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println("我是服务器.客户端说: "+str);
            }
            server.shutdownInput();//关闭输入流
            //获取输出流，响应客户端请求
            OutputStream outputStream = server.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("恭喜你，链接服务器成功");
            printWriter.flush();

            //将资源逐个进行关闭
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            server.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
