package org.example.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 演示数据
 *
 * @author dulred
 * @date 2023/08/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoData {

    @ExcelProperty("title")
    private String name;
    @ExcelProperty("date")
    private Date date;
    @ExcelProperty("numberTitle")
    private double doubleValule;


}
