package com.gupao.student.sqlhelper;/**
 * Created by zhuochen on 2019/4/29.
 */

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhuochen
 * @comment
 * @date 2019/4/29
 */
public class TestCmd {

    public static void main(String[] args) {
        DataBaseCmd dataBaseCmd = new DataBaseCmd();
        String sql  = "select * from t_user";
        try {
            ResultSet resultSet = dataBaseCmd.excuteQuery(sql, false, null);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
            dataBaseCmd.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
