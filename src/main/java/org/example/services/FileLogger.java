package org.example.services;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class FileLogger implements Logger{
    private int num = 1;
    public void log(String msg) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.txt"))){
            bufferedWriter.write("#" + num + " " + LocalDateTime.now() + " "+ msg + "\n");
            num++;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
