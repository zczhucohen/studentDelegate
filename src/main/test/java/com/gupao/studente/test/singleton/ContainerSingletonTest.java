package com.gupao.studente.test.singleton;/**
 * Created by zhuochen on 2019/5/14.
 */

import com.gupao.student.singleton.register.ContainerSingleton;

/**
 * 测试注册式单例
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public class ContainerSingletonTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {
            System.out.println("创建开始时间："+start+"ms");
            ConcurrenExecutor.execute(new ConcurrenExecutor.RunHander(){
                @Override
                public void handler() {
                    Object instance = ContainerSingleton.getInstance("com.gupao.student.pojo.User");
                    System.out.println(System.currentTimeMillis()+":"+instance);
                }
            },10,5);
            long end = System.currentTimeMillis();
            System.out.println("结束时间："+end+"ms");
            System.out.println("用时："+(end-start)+"ms。");
        } catch (InterruptedException e) {
            e.printStackTrace();
            long end = System.currentTimeMillis();
            System.out.println("创建失败，总耗时："+(end-start)+"ms。");
        }

    }
}
