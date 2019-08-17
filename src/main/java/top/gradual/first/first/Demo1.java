package top.gradual.first.first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: Java网络编程 1-1
 * @Author: gradual
 * @Date: 2019-08-17 11:10
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            // 创建新的ServerSocket，用以监听指定端口上的连接请求
            ServerSocket serverSocket = new ServerSocket(8080);
            //对accept方法的调用将被阻塞，直到一个连接被建立
            Socket clientSocket = serverSocket.accept();
            //获取输入流对象
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //获取输出流对象
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String request;
            String response;
            //开始处理请求
            while ((request = in.readLine()) != null) {
                //如果客户端发送了"Done"，则退出处理循环
                if ("Done".equals(request)) {
                    break;
                }
                //请求传递给处理请求的方法
                response = processRequest(request);
                //服务器的响应发送回客户端
                out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        return "test";
    }
}
