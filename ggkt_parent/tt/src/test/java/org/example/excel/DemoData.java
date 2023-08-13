package org.example.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;



public class DemoData {

    @ExcelProperty("title")
    private String name;
    @ExcelProperty("date")
    private Date date;
    @ExcelProperty("numberTitle")
    private double doubleValule;

    @ExcelIgnore
    private String ignore;


}
