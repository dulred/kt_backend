package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        冒泡排序
    int[] arr = {56, 48, 66, 23, 38, 45};
    for(int j = 0; j < arr.length - 1; j++) {
            for(int i = 0; i < arr.length - 1 - j; i++) {//如果前面元素大，后面的元素往前移
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
    }
        System.out.println("冒回排序结果：");
        for(int t : arr) {
            System.out.println(t);
        }
        System.out.println("--------------------------");

    }
}
