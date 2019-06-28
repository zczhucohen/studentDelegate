package com.gupao.student.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端 发送
 * @author zhuochen
 * @comment
 * @date 2019/5/30
 */
public class SocketClientSingle {

    public static void main(String[] args) {
        try {
            // 向本机的4700端口发出客户请求
            Socket socket = new Socket("127.0.0.1",8880);
            // 由系统标准输入设备构造BufferedReader 对象
            BufferedReader sin  = new BufferedReader(new InputStreamReader(System.in));
            // 由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            // 由Socket对象得到输入流，并构造BufferedReader对象
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readLine;
            // 从系统标准输入读入一字符串
            readLine = sin.readLine();
            // 若系统标准输入读入的字符串为"bye",则停止循环
            while (!readLine.equals("bye")) {
                // 将系统标准输入读入的字符串输出到Server
                os.println(readLine);
                // 刷新缓存，使Server马上收到该字符串
                os.flush();
                // 在系统标准输入中打印读入的字符串
                System.out.println("Client:"+readLine);
                // 从Server读入一字符串，并打印到标准输出上
                System.out.println("Server:"+reader.readLine());
                // 从系统标准输入上读入一字符串
                readLine = sin.readLine();
                // 继续循环
            }
            os.close();// 关闭Socket输出流
            reader.close(); // 关闭Socket输入流
            socket.close(); // 关闭Socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
