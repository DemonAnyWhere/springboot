package com.lirui.controller;

import com.lirui.constan.DataSourceType;
import com.lirui.multids.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestMulDataSourceController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/local")
    @DataSource(value = DataSourceType.LOCAL)
    public List<Map<String, Object>> local(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tbl_emp");
        return maps;
    }
    @GetMapping("/remote")
    @DataSource(value = DataSourceType.REMOTE)
    public List<Map<String, Object>> remote(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tbl_emp");
        return maps;
    }

}