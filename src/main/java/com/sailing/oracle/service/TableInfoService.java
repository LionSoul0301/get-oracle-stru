package com.sailing.oracle.service;

import com.sailing.oracle.entity.TableInfo;
import com.sailing.oracle.entity.TableStru;
import com.sailing.oracle.mapper.TableInfoMapper;
import com.sailing.oracle.mapper.TableStruMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TableInfoService {

    @Resource
    private TableInfoMapper tableInfoMapper;

    @Resource
    private TableStruMapper tableStruMapper;

    public List<TableInfo> getTableInfo(){
        List<TableInfo> tableInfos =  tableInfoMapper.getTableInfo();
        return tableInfos;
    }

    public List<TableStru> getTableStru(String tableName){
        List<TableStru> tableStrus =  tableStruMapper.getTableStru(tableName);
        return tableStrus;
    }
}
