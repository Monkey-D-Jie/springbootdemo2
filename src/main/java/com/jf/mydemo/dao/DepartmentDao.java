package com.jf.mydemo.dao;

import com.jf.mydemo.entity.Departments;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2019-06-13 15:59
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@MapperScan
public interface DepartmentDao {
    int  insertDepartment(List<Departments> insertList);
}
