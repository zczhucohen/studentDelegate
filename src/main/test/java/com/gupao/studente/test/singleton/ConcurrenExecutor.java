package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/8.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程类
 * @author zhuochen
 * @comment
 * @date 2019/5/8
 */
public class ConcurrenExecutor {

    /**
     *
     * @param runHander
     * @param executeCount 发起请求总数
     * @param concurrenCount 同时并发执行的线程数
     * @throws InterruptedException
     */
    public static void execute(final RunHander runHander, int executeCount, final int concurrenCount) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("开始线程时间："+start+"ms");
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 控制信好量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(concurrenCount);
        // 闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executeCount);
         for(int i = 0; i< executeCount; i++){
             executorService.execute(new Runnable() {
                 @Override
                 public void run() {
                     // 执行此方法用于获取执行许可，当总计未释放的许可数不超过executeCount时，
                     // 则允许同行，否则线程阻塞等待，直到获取许可
                     try {
                         semaphore.acquire();
                         runHander.handler();
                         // 释放许可
                         semaphore.release();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     countDownLatch.countDown();
                 }
             });
         }
        long endNew = System.currentTimeMillis();
        System.out.println("创建结束："+endNew+"ms");
        countDownLatch.await();// 线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        long end = System.currentTimeMillis();
        System.out.println("await："+end+"ms");
        executorService.shutdown();
        long end1 = System.currentTimeMillis();
        System.out.println("shutdown："+end1+"ms");

    }

    public interface RunHander{
        void handler();
    }
}
