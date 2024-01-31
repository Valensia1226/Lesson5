package org.example;

import java.io.*;

public class Task2 {
    //Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой, например,
    // состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
    // 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
    // всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
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
