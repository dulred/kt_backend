package org.atguigu.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        // 获取远程对象
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        CalculatorService calculatorService = (CalculatorService) registry.lookup("CalculatorService");

        // 调用远程方法
        int result = calculatorService.add(5, 7);
        System.out.println("Result: " + result);
    }
}
