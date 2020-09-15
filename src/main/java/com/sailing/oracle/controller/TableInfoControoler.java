package com.sailing.oracle.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sailing.oracle.entity.TableInfo;
import com.sailing.oracle.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oracle")
public class TableInfoControoler {

    @Autowired
    private TableInfoService tableInfoService;

    @RequestMapping("/tableInfo")
    @ResponseBody
    public String getTableInfo(){
        String tableInfo = "";
        tableInfo = JSONObject.toJSONString(tableInfoService.getTableInfo());
        System.out.println("111111111: " + tableInfo);
        return tableInfo;
    }

}
