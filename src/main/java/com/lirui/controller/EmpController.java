package com.lirui.controller;


import com.lirui.bean.Emp;
import com.lirui.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lirui
 * @since 2020-07-19
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpMapper empMapper;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Emp selectAll() {
        System.out.println(empMapper);
        return empMapper.selectById(1);
    }
}

