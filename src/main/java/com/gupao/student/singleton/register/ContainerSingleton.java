package com.gupao.student.singleton.register;/**
 * Created by zhuochen on 2019/5/13.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * spring 中的做法，就是用这种注册式单例
 * @author zhuochen
 * @comment
 * @date 2019/5/13
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new HashMap<>();

    public static Object getInstance(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;

                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            }

        }
        return null;
    }
}
