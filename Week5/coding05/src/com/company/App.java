package com.company;

public class App {

    public static void main(String[] args) {
        Logger asterisk = new AsteriskLogger();
        Logger space    = new SpacedLogger();
        asterisk.Log("Hello");
        asterisk.Error("Hello");
        space.Log("Hello");
        space.Error("Hello");
    }
}
