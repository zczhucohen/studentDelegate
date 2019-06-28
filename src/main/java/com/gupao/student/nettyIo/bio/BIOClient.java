package com.gupao.student.nettyIo.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author zhuochen
 * @comment
 * @date 2019/6/28
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        // 要和谁进行通信，服务器IP、服务器的端口
        // 一台机器的端口号是有限
        Socket client = new Socket("127.0.0.1",8080);

        //  输出0，write（）
        //不管是客户端还是服务端 ，都有可能write和read
        OutputStream os = client.getOutputStream();
        String msg = UUID.randomUUID().toString();
        System.out.println("客户端发送数据："+ msg);
        // 传说中的101011010
        os.write(msg.getBytes());
        os.flush();
        os.close();
        client.close();
    }
}
