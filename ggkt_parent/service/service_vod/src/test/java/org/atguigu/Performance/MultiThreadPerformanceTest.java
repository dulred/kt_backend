package org.atguigu.Performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiThreadPerformanceTest {

    private static final int NUM_THREADS = 10;
    private static final int TOTAL_REQUESTS = 1000000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        AtomicInteger completedRequests = new AtomicInteger(0);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TOTAL_REQUESTS; i++) {
            executor.submit(() -> {
                // 在此模拟调用 HelloController 的 sayHello 方法
                String response = simulateHelloControllerRequest();
                completedRequests.incrementAndGet();
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // 等待所有线程执行完成
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        double qps = (double) completedRequests.get() / (elapsedTime / 1000.0);

        System.out.println("Total requests: " + completedRequests.get());
        System.out.println("Total time taken: " + elapsedTime + " ms");
        System.out.println("QPS: " + qps);
    }

    private static String simulateHelloControllerRequest() {
        // 模拟请求处理
        return "Hello, world!";
    }

}
