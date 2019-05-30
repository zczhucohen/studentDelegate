package com.gupao.student.communication;

import javafx.print.Printer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *  模拟客户端发送服务端
 * @author zhuochen
 * @comment
 * @date 2019/5/30
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Hello,server");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
