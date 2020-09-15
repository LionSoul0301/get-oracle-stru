package com.sailing.oracle.controller;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.rtf.RtfWriter2;
import com.sailing.oracle.entity.TableInfo;
import com.sailing.oracle.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import static com.sailing.oracle.utils.Tools.*;

@RestController
public class TableStruControoler {

    @Autowired
    private TableInfoService tableInfoService;
    @RequestMapping("/tableStru")
    @ResponseBody
    public String getTableStru() throws Exception {
        Config config = ConfigService.getConfig("application");
        String systemName = config.getProperty("system_name", "");
        String systemNameStr = "处理的系统是：" + config.getProperty("system_name", "");

        String tableNames = "处理的表如下：<br>";
        //初始化word文档
        Document document = new Document(PageSize.A4);
        RtfWriter2.getInstance(document,new FileOutputStream("F:/test/"+ systemName + "表结构.doc"));
        document.open();

        String tableStru = "";
        //获取所有表
        List<TableInfo> tables = tableInfoService.getTableInfo();

        int i=1;
        for (Iterator<TableInfo> iterator = tables.iterator(); iterator.hasNext();) {
            //String [] arr = (String []) iterator.next();
            TableInfo tableInfo = iterator.next();

            String [] arr = new String[]{tableInfo.getTableName(), tableInfo.getTableComments()};
            //循环获取字段信息
            String tableName = arr[0];
            System.out.print(i + ".正在处理数据表-----------" + arr[0]);
            addTableMetaData(document, arr, i);
            List columns = tableInfoService.getTableStru(tableName);
            //List columns = getDataBySQL(sql_get_all_columns.replace("{table_name}", arr[0]), conn);
            addTableDetail(document, columns);
            addBlank(document);
            System.out.println("...done");
            i++;
            tableNames +=  tableName + "<br>";
        }
        document.close();

        return systemNameStr+ "<br>"+ tableNames;
    }

}
