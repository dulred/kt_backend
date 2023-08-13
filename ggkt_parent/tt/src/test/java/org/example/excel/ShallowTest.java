package org.example.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 浅测试
 *
 * @author dulred
 * @date 2023/08/14
 */
public class ShallowTest {


    public static void main(String[] args) {

        List<DemoData> list = testData();

        for (DemoData data : list) {
            System.out.println( data.toString());
        }

    }

    /**
     *  生成10条测试数据
     *
     * @author dulred
     * @date 2023/08/14
     */
    private static List<DemoData> testData() {

        List<DemoData> list = new ArrayList<DemoData>();

        for(int i = 0; i < 10; i++) {
            DemoData data = new DemoData("testData"+i,new Date(),13+i);
            list.add(data);
        }

        return list;



    }
}
