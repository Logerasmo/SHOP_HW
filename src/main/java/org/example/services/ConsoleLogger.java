package org.example.services;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger{
    private int num = 1;

    public void log(String msg) {
        System.out.println("#" + num + " " + LocalDateTime.now() + " "+ msg);
        num++;
    }
}
