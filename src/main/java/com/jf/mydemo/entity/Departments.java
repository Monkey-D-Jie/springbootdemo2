package com.jf.mydemo.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2019-06-13 15:57
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class Departments implements Serializable {
    private static final long serialVersionUID = 2325250596320505345L;
    private String deptNo;
    private String deptName;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
