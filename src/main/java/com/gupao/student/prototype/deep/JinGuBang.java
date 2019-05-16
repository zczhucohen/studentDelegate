package com.gupao.student.prototype.deep;/**
 * Created by zhuochen on 2019/5/16.
 */

import java.io.Serializable;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *=2;
        this.h *=2;
    }
    public void small(){
        this.d/=2;
        this.h/=2;
    }
}
