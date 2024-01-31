package org.example;

import java.io.*;

public class Task2 {

    public void save(int[] array){
        try {
            writeToFile(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int encode(int[] array) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            number = number << 2; //сдвиг на два бита влево
            number = number | array[i]; //побитовое или
        }
        return number;
    }
    private void writeToFile(int[] array) throws IOException {
        try (DataOutputStream fos = new DataOutputStream(new FileOutputStream("test.bin"))) {
            fos.writeInt(encode(array));
        }
    }
}
