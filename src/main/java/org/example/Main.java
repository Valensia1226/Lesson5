package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Task1
        Task1 task1 = new Task1();
        task1.createBackup("C:\\Users\\valen\\Desktop\\JavaCore\\Lesson5", "C:\\Users\\valen\\Desktop\\JavaCore");


        //Task2
        int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 3};
        Task2 task2 = new Task2();
        task2.save(array);
    }

}