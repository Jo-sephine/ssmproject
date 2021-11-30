package com.crud.service;

import com.crud.bean.Employee;
import com.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Misluo
 * @create 2021/11/30 9:44
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll() {

        return employeeMapper.selectByExampleWithDept(null) ;
    }
}
