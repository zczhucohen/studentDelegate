package com.gupao.student.nettyIo.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * AIO客户端
 * @author zhuochen
 * @comment
 * @date 2019/7/1
 */
public class AIOClient {
    private final AsynchronousSocketChannel client;

    public AIOClient() throws IOException {
        client = AsynchronousSocketChannel.open();
    }
    public void connection(String host,int port){
        client.connect(new InetSocketAddress(host,port),null,
                new CompletionHandler<Void,Void>(){

                    @Override
                    public void completed(Void result, Void attachment) {
                        try {
                            client.write(ByteBuffer.wrap("这是一条测试数据".getBytes())).get();
                            System.out.println("已发送至服务器");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        exc.printStackTrace();
                    }
                });
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new AIOClient().connection("localhost", 8000);
    }
}
