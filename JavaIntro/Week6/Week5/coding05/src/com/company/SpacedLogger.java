package com.company;

public class SpacedLogger implements Logger{
    @Override
    public void Log(String msg) {
        System.out.println(space(msg));
    }

    @Override
    public void Error(String errMsg) {
        System.out.println("ERROR: " + space(errMsg));
    }

    public StringBuilder space(String msg) {
        StringBuilder spaceString = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            spaceString.append(c);
            spaceString.append(" ");
        }
            return spaceString;
    }
}
