package org.atguigu.rmi;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        CalculatorService calculatorService = new CalculatorServiceImpl();

        // 注册 RMI 服务
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculatorService", calculatorService);

        System.out.println("Server is running...");
    }
}
