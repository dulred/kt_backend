package org.atguigu.Performance;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SingleThreadPerformanceTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            // 发起单线程请求
            // 在此模拟调用 HelloController 的 sayHello 方法
            String response = simulateHelloControllerRequest();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        double qps = 1000000 / (elapsedTime / 1000.0); // QPS = 总请求数 / 执行时间（秒）

        System.out.println("Total time taken: " + elapsedTime + " ms");
        System.out.println("QPS: " + qps);
    }
    private static String simulateHelloControllerRequest() {
        // 模拟请求处理
        return "Hello, world!";
    }
}
