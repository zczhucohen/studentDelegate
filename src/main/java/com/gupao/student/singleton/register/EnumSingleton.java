package com.gupao.student.singleton.register;/**
 * Created by zhuochen on 2019/5/14.
 */

/**
 * 常量中使用，常量不就是用来大家能够共享的吗
 * 通常在通用API中使用
 * @author zhuochen
 * @comment
 * @date 2019/5/14
 */
public enum  EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){return INSTANCE;}
}
