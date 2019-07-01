package com.gupao.student.nettyIo.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AIO 服务端
 * @author zhuochen
 * @comment
 * @date 2019/7/1
 */
public class AIOServer {

    private final int port;

    public AIOServer(int port) {
        this.port = port;
        listen();
    }

    public static void main(String[] args) {
        new AIOServer(8000).listen();
    }

    private void listen() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.
                    withCachedThreadPool(executorService, 1);
            // 开门营业
            // 工作线程，用来侦听回调的，事件响应的时候需要回调
            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.
                    open(threadGroup);
            server.bind(new InetSocketAddress(port));
            System.out.println("服务已启动，监听端口"+port);
            // 准备接收数据
            server.accept(null,
                    new CompletionHandler<AsynchronousSocketChannel, Object>() {
                        final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                        // 实现由completion方法回调
                        //由操作系统触发
                        //回调由两个状态，成功，失败
                        @Override
                        public void completed(AsynchronousSocketChannel result, Object attachment) {
                            System.out.println("IO操作成功，开始获取数据");
                            try{
                                buffer.clear();
                                result.read(buffer).get();
                                buffer.flip();
                                result.write(buffer);
                                buffer.flip();
                                System.out.println(buffer.getChar());
                            }catch (Exception e){
                                e.printStackTrace();
                            }finally {
                                try {
                                    result.close();
                                    server.accept(null,this);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("操作完成");
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println("IO操作失败，失败原因："+exc);
                        }
                    });
            Thread.sleep(Integer.MAX_VALUE);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
