package com.gupao.student.prototype.deep;/**
 * Created by zhuochen on 2019/5/16.
 */

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
        System.out.println("深克隆："+ (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        // 深浅克隆的比较
        QiTianDaSheng qiTianDaSheng1 = new QiTianDaSheng();
        QiTianDaSheng shallowClone = qiTianDaSheng1.shallowClone(qiTianDaSheng1);
        System.out.println("浅克隆："+ (qiTianDaSheng1.jinGuBang == shallowClone.jinGuBang));
    }
}
