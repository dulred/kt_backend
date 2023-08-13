package org.atguigu.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Data date;
    @ExcelProperty("数字标题")
    private Double doubleData;

    @ExcelIgnore
    private String ignore;




}
