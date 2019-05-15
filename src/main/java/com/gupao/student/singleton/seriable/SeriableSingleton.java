package com.gupao.student.singleton.seriable;/**
 * Created by zhuochen on 2019/5/14.
 */

import java.io.Serializable;

/**
 * 反序列化时导致单例破坏
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public class SeriableSingleton implements Serializable{

    // 序列化就是说把内存的状态通过转换成字节码的形式
    // 从而转换一个IO流，写入到其他地方（可以是磁盘，网络IO）
    // 内存中状态给永久保存下来了

    // 反序列化
    // 将已经持久化的字节码内容，转换为IO流
    // 通过IO流的读取，进而将读取的内容转换为java对象
    // 在转换过程中会重新创建对象new

    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){return INSTANCE;}

    private Object readResolve(){
        return INSTANCE;
    }
}
