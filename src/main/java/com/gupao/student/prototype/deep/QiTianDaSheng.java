package com.gupao.student.prototype.deep;/**
 * Created by zhuochen on 2019/5/16.
 */

import java.io.*;
import java.util.Date;

/**
 * @author zhuochen
 * @comment
 * @date 2019/5/16
 */
public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }
    protected Object clone(){
        return this.deepClone();
    }

    public Object deepClone(){

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();

            return copy;

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target){
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;

        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;
    }
}
