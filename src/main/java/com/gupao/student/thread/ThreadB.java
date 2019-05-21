package com.gupao.student.thread;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/20
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    public ThreadB() {
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("start ThreadB");
            lock.notify();
            System.out.println("end ThreadB");
        }
    }
}
