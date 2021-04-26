package com.company;

public class AsteriskLogger implements Logger{

    @Override
    public void Log(String msg) {
        System.out.println("***" + msg + "***");
    }

    @Override
    public void Error(String errMsg) {
        System.out.println("********************");
        System.out.println("***Error:" + errMsg + "***");
        System.out.println("********************");
    }
}
