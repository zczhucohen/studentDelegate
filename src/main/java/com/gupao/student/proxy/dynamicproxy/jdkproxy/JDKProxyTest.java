package com.gupao.student.proxy.dynamicproxy.jdkproxy;

import com.gupao.student.proxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/21
 */
public class JDKProxyTest {

    public static void main(String[] args) {

        // Person instance = (Person)new JDKMeiPo().getInstance(new Girl());
        try {
            Object instance = new JDKMeiPo().getInstance(new Girl());
            Method method = instance.getClass().getMethod("findLove", null);
            method.invoke(instance);
            // instance.findLove();
            // 输出代理对象生成的class
           /* byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream fos  = new FileOutputStream("F://$Proxy0.class");
            fos.write(bytes);
            fos.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
