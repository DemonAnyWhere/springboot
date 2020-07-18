package com.lirui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Map<String, Object>> selectAll() {
        System.out.println("---------------");
        String sql = "select * from tbl_emp";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }


}
