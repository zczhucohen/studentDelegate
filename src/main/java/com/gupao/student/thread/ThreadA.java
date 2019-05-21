package com.gupao.student.thread;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/20
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    public ThreadA() {
    }

    @Override
    public void run() {
        //threadTest.demo(countA);
        synchronized (lock){
            System.out.println("start ThreadA");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadA");
        }
    }
}
