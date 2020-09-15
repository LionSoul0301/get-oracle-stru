package com.sailing.oracle.mapper;

import com.sailing.oracle.entity.TableInfo;
import com.sailing.oracle.entity.TableStru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableStruMapper {
    List<TableStru> getTableStru(@Param("tableName") String tableName);
}
