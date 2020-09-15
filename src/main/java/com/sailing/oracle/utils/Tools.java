package com.sailing.oracle.utils;

import com.lowagie.text.*;
import com.sailing.oracle.entity.TableStru;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Tools {
    //键类型字典
    private static Map<String,String> keyType = new HashMap<String,String>();

    /**
     * 增加表概要信息
     * @param dcument
     * @param arr
     * @param i
     * @throws Exception
     */
    public static void addTableMetaData(Document dcument, String [] arr, int i) throws Exception{
        Paragraph ph = new Paragraph(i+". 表名: "+arr[0]+"\n说明: "+(arr[1]==null?"":arr[1]));
        ph.setAlignment(Paragraph.ALIGN_LEFT);
        dcument.add(ph);
    }

    /**
     * 添加包含字段详细信息的表格
     * @param document
     * @param
     * @param columns
     * @throws Exception
     */
    public static void addTableDetail(Document document, List columns)throws Exception{
        Table table = new Table(6);
        table.setWidth(100f);
        table.setBorderWidth(1);
        table.setBorderColor(Color.BLACK);
        table.setPadding(0);
        table.setSpacing(0);
        Cell cell1 = new Cell("序号");// 单元格
        cell1.setHeader(true);

        Cell cell2 = new Cell("列名");// 单元格
        cell2.setHeader(true);

        Cell cell3 = new Cell("类型");// 单元格
        cell3.setHeader(true);

        Cell cell4 = new Cell("长度");// 单元格
        cell4.setHeader(true);

        Cell cell5 = new Cell("键");// 单元格
        cell5.setHeader(true);

        Cell cell6 = new Cell("说明");// 单元格
        cell6.setHeader(true);
        //设置表头格式
        table.setWidths(new float[]{8f,30f,15f,8f,10f,29f});
        cell1.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell1.setBackgroundColor(Color.gray);
        cell2.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell2.setBackgroundColor(Color.gray);
        cell3.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell3.setBackgroundColor(Color.gray);
        cell4.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell4.setBackgroundColor(Color.gray);
        cell5.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell5.setBackgroundColor(Color.gray);
        cell6.setHorizontalAlignment(Cell.ALIGN_CENTER);
        cell6.setBackgroundColor(Color.gray);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.endHeaders();// 表头结束
        int x = 1;
        for (Iterator <TableStru> iterator = columns.iterator(); iterator.hasNext();) {
/*            String [] arr2 = (String []) iterator.next();
            Cell c1 = new Cell(x+"");
            Cell c2 = new Cell(arr2[0]);
            Cell c3 = new Cell(arr2[1]);
            Cell c4 = new Cell(arr2[2]);

            String key = keyType.get(arr2[5]);
            if(key==null)key = "";
            Cell c5 = new Cell(key);
            Cell c6 = new Cell(arr2[3]);*/
            TableStru tableStru = iterator.next();
            Cell c1 = new Cell(x+"");
            Cell c2 = new Cell(tableStru.getColumnName());
            Cell c3 = new Cell(tableStru.getDataType());
            Cell c4 = new Cell(tableStru.getLen());

            String key = keyType.get(tableStru.getConstraintType());
            if(key==null)key = "";
            Cell c5 = new Cell(key);
            Cell c6 = new Cell(tableStru.getComments());
            c1.setHorizontalAlignment(Cell.ALIGN_CENTER);
            c2.setHorizontalAlignment(Cell.ALIGN_CENTER);
            c3.setHorizontalAlignment(Cell.ALIGN_CENTER);
            c4.setHorizontalAlignment(Cell.ALIGN_CENTER);
            c5.setHorizontalAlignment(Cell.ALIGN_CENTER);
            c6.setHorizontalAlignment(Cell.ALIGN_CENTER);
            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
            table.addCell(c6);
            x++;
        }
        document.add(table);
    }

    /**
     * 添加一个空行
     * @param document
     * @throws Exception
     */
    public static void addBlank(Document document)throws Exception{
        Paragraph ph = new Paragraph("");
        ph.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(ph);
    }
}

