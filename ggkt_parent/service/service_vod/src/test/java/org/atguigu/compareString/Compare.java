package org.atguigu.compareString;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

@Slf4j
public class Compare {

    public static void main(String[] args) {

        compareStrings("abcdefg","25abdfxcx");
//        compareStrings("abcdf12313","11abccfg1lsk3aa122");
//        for (String a:
//                "dfxx".split("c") ) {
//            System.out.println(a + "cc");
//        }

    }

//25abdfxx - >bdfxx  0
//bdfxx -->dfxx 1
//dfxx --> dfxx 2
//dfxx -->fxx 3
//fxx -->fxx 4
//fxx-->xx 5
//xx-->xx 6
    private static void compareStrings(String s1, String s2) {
        for (int i= 0;i<s1.length();i++){
            String[] arr = s2.split(String.valueOf(s1.charAt(i)));
            if (StringUtils.isEmpty(s2)){
                System.out.println("位置" + i + "缺少" + s1.charAt(i));
            } else if (i==s1.length()-1) {
                if (arr.length==1 && org.apache.commons.lang3.StringUtils.isNotEmpty(arr[0])){
                    System.out.println("位置" + i + "错误," + arr[0] + "应为" + s1.charAt(i));
                    System.out.println("woaini" + i +"---" +s2);
                } else if (arr.length>1) {
                    if (org.apache.commons.lang3.StringUtils.isNotEmpty(arr[0])){
                        System.out.println("位置" + i + "多出" + arr[0]);
                    }
                    System.out.println("末尾多出" + arr[1]);
                }
            } else if (arr.length>1) {
                    if (org.apache.commons.lang3.StringUtils.isNotEmpty(arr[0])){
                        System.out.println("位置" + i +"多出" +arr[0]);
                        s2 = s2.replaceFirst(arr[0] + s1.charAt(i),"");
                        System.out.println("bbbbbbbbbbbbbbbbb" + s2);
                    }else {
                        s2 = s2.replaceFirst(String.valueOf(s1.charAt(i)),"");
                        System.out.println(s2 +"-----" + i );
                    }
            } else if (arr.length ==1) {
                    if (!s2.contains((String.valueOf(s1.charAt(i+1))))){
                        System.out.println("位置" + i + "缺少" + s1.charAt(i));
                        System.out.println("66666666666666666666");
                    }else {
                        System.out.println(i +"hhahahahahahha");
                        System.out.println("位置" + i + "错误 ," +arr[0].split(String.valueOf(s1.charAt(i+1)))[0]+"应为" +s1.charAt(i)  );
                        System.out.println("kllllll" + s2);
                        System.out.println("ggggbbb" + s1.charAt(i+1));
                        s2=s2.replaceFirst(s2.split(String.valueOf(s1.charAt(i+1)))[0],"");
                        System.out.println("kllllll222222222" + s2);
                    }
            }
        }

    }

    @Test
    public  void test (){
        String input = "Hello, World!";
        String regex = "\\s";
        String replacement = "-";
        String output = input.replaceFirst(regex, replacement);
        System.out.println(output);
    }

}
