package com.gupao.student.thread;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @author zhuochen
 * @comment
 * @date 2019/5/20
 */
public class ThreadTest {

    static ReentrantLock lock = new ReentrantLock();
    private  int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public synchronized void demo (int i){

        System.out.println("随便做个事呢？");
        i--;
        System.out.println(i);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest threadTest1 = new ThreadTest();
        // ThreadTest threadTest1 = new ThreadTest();
       /* new Thread(()->threadTest.demo(i)).start();
        new Thread(()->threadTest.demo(i)).start();*/
        ThreadB threadB = new ThreadB(threadTest);
        ThreadA threadA = new ThreadA(threadTest);
        threadB.start();
        threadA.start();

        System.out.println("结束");

    }
}
