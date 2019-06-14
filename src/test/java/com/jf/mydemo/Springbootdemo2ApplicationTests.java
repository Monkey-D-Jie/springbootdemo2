package com.jf.mydemo;

import com.jf.mydemo.dao.DepartmentDao;
import com.jf.mydemo.entity.Departments;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springbootdemo2ApplicationTests {

    /**
     * 打印日志用logger-用debug级别
     */
    private Logger LOGGER = LoggerFactory.getLogger(Springbootdemo2ApplicationTests.class.getName());

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate()
    {
        return sqlSessionTemplate;
    }

    @Resource
    private DepartmentDao departmentDao;

/*---------------------
    作者：小灯光环
    来源：CSDN
    原文：https://blog.csdn.net/wlwlwlwl015/article/details/50246717
    版权声明：本文为博主原创文章，转载请附上博文链接！*/

    @Test
    public void contextLoads() {
    }

    @Test
    public void logTest() {
        LOGGER.debug("debug：....");
        LOGGER.info("info...");
        LOGGER.error("error...");
        String str = null;
        try {
            System.out.println(str.toString());
        } catch (NullPointerException e) {
            LOGGER.error("异常测试日志打印，异常信息 {}", e.getMessage(), e);
        }
    }

    @Test
    public void insertTest() throws Exception {
        List<Departments> insertList = new ArrayList<>(10000);
        //添加数据
        for (int i = 0; i < 1000000; i++) {
            Departments departments = new Departments();
            departments.setDeptNo("d000"+i);
            departments.setDeptName("测试数据"+i);
            insertList.add(departments);
        }
        //插入数据
        long start = System.currentTimeMillis();
        insertCrossEvaluation(insertList);
        long end = System.currentTimeMillis();
        System.out.println("插入"+insertList.size()+"条数据，"+"合计耗时时长为："+(end-start)/1000+"s");
    }
    /**
     * 来自：
     * Mybatis 大数据量的批量insert解决方案 - 小灯光环 - CSDN博客
     https://blog.csdn.net/wlwlwlwl015/article/details/50246717
     */
    public boolean insertCrossEvaluation(List<Departments> members)
            throws Exception {
        // TODO Auto-generated method stub
        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            // 获取批量方式的sqlsession
//            batchSqlSession = this.getSqlSessionTemplate()
//                    .getSqlSessionFactory()
//                    .openSession(ExecutorType.SIMPLE, false);
            int batchCount = 10000;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            for (int index = 0; index < members.size();) {
                if (batchLastIndex >= members.size()) {
                    batchLastIndex = members.size();
                    result = result * departmentDao.insertDepartment(members.subList(index, batchLastIndex));
//                    batchSqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    break;// 数据插入完毕，退出循环
                } else {
//                    result = result * batchSqlSession.insert("DepartmentMapper.insertDepartment",members.subList(index, batchLastIndex));
                    result = result * departmentDao.insertDepartment(members.subList(index, batchLastIndex));
//                    batchSqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
//            batchSqlSession.commit();
        }
        finally {
//            batchSqlSession.close();
        }
        return result == 0 ? false : true;
    }
}
