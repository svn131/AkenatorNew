package ru.kata.spring.boot_security.demo.util;

import java.io.*;

public class CopyFileExample {

        public static void main(String[] args) throws IOException {
            String sourceFilePath = "C:/22/1.jpg";
            int skolko = 100;

            File sourceFile = new File(sourceFilePath);
            String fileDirectory = sourceFile.getParent();
            String fileName = sourceFile.getName();

            for (int i = 2; i <= skolko; i++) {
                String destinationFilePath = fileDirectory + "/" + i + ".jpg";
                File destinationFile = new File(destinationFilePath);

                // Копирование файла
                InputStream is = new FileInputStream(sourceFile);
                OutputStream os = new FileOutputStream(destinationFile);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }

                is.close();
                os.close();

                System.out.println("Скопирован файл: " + destinationFilePath);
            }
        }
}
