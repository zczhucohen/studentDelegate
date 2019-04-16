package com.gupao.student.factory.method;/**
 * Created by zhuochen on 2019/4/16.
 */

import com.gupao.student.factory.Department;
import com.gupao.student.factory.ResearchDepartment;

/**
 * 研发部门创建
 * @author zhuochen
 * @comment
 * @date 2019/4/16
 */
public class ResearchFactory implements DepartmentFactory {
    @Override
    public Department create() {
        return new ResearchDepartment();
    }
}
