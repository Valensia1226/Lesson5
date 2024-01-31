package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Task1 {
    //Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup

    public void createBackup(String source, String backup){
        backup = backup + "\\backup";
        try {
            create(source, backup);
            System.out.println("Успешное резервное копирование");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void create(String source, String backup) throws IOException {
        File sourceDirectory = new File(source);
        File backupDirectory = new File(backup);

        if (!sourceDirectory.isDirectory()) {
            throw new IllegalArgumentException("Нет директории по копируемому пути");
        }

        if (!backupDirectory.exists()) {
            backupDirectory.mkdirs();
        }

        File[] files = sourceDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(backup + "/" + file.getName());
                    copyFile(file, backupFile);
                }
            }
        }
    }

    private void copyFile(File sourceFile, File destinationFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length); //пишем данные из одного потока в другой через буфер
            }
        }
    }
}
