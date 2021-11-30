package com.crud.test;

import com.crud.bean.Department;
import com.crud.bean.Employee;
import com.crud.dao.DepartmentMapper;
import com.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author Misluo
 * @create 2021/11/29 15:14
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
 @Autowired
 DepartmentMapper departmentMapper;
@Autowired
EmployeeMapper employeeMapper;
@Autowired
    SqlSession sqlSession;
    //测试DepartmentMapper
    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        //插入几个部门
        departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));
       //批量插入
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null,uid,"M","uid.qq@com",1));
        }

    }
}
