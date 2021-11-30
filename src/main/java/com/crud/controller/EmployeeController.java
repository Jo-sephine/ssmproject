package com.crud.controller;

import com.crud.bean.Employee;
import com.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

/**
 * @author Misluo
 * @create 2021/11/30 9:40
 */
@Controller
public class EmployeeController {

  @Autowired
    EmployeeService employeeService;
  //分页查询
    @RequestMapping("/emps")
   public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn ,Model Model) {
        //在查询前调用，传入页码，以及每页大小
        PageHelper.startPage(pn,5);
      List<Employee> emps= employeeService.getAll();
  //使用pageinfo来包装页面，只需要将pageinfo交给页面就行了
        //封装了详细的分页信息，包括查询来的信息，传入连续显示的页数
        PageInfo page=new PageInfo(emps,5);
        Model.addAttribute("pageInfo",6);
       return "list";
   }
}
