package org.atguigu.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class CalculatorServiceImpl extends UnicastRemoteObject implements CalculatorService {

    protected CalculatorServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int cat, int dog) throws RemoteException {
        return cat + dog;
    }

}

