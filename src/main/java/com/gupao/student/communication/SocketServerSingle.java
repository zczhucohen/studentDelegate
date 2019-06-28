package com.gupao.student.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单的实现 服务端
 * @author zhuochen
 * @comment
 * @date 2019/5/30
 */
public class SocketServerSingle {

    public static void main(String[] args) {
        ServerSocket server = null;
        BufferedReader reader = null;
        Socket socket = null;
        try {
            // 创建一个ServerSocket在端口8080监听客户要求
            server = new ServerSocket(8880);
            /*
            使用accept（）阻塞等待客户请求，有客户
            请求到来则产生一个Socket对象，并继续执行
             */
            socket = server.accept();
        } catch (IOException e) {
            // 打印出错信息
            e.printStackTrace();
        }
        String line;
        try {
            // 由Socket对象得到输入流，并构造相应的BufferReader对象
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输出流，并构造PrintWeiter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            // 由系统标准输入设备构造BufferedReader对象
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            // 在标准输出上打印从客户端读入的字符串
            System.out.println("Client:"+reader.readLine());
            // 从标准输入读入一字符串
            line = sin.readLine();
            // 如果该字符串为 bye，则停止循环
            while (!line.equals("bye")){
                // 想客户端输出该字符串
                os.println(line);
               // 刷新输出流，是客户端马上就能受到该字符串
                os.flush();
                // 在系统标准输出上打印读入的字符串
                System.out.println("Server:"+line);
                // 从Client读入一字符串，并打印到标准输出上
                System.out.println("Client:"+reader.readLine());
                // 从系统标准输入读入一字符串
                line = sin.readLine();
                // 继续循环
            }
            os.close(); // 关闭Socket输出流
            reader.close();// 关闭Socket输入流
            socket.close(); // 关闭Socket
            server.close(); // 关闭ServerSocket；

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
