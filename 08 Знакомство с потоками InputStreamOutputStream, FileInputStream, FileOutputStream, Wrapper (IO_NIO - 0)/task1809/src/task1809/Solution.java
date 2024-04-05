package task1809;

import util.InputUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String filePath1 = InputUtil.readStringInputFromConsole();
        String filePath2 = InputUtil.readStringInputFromConsole();


        try (FileInputStream fileInputStream = new FileInputStream(filePath1);
             FileOutputStream fileOutputStream = new FileOutputStream(filePath2)) {

            byte[] buffer = new byte[fileInputStream.available()];
            int bytesRead = fileInputStream.read(buffer);

            for (int i = bytesRead - 1; i >= 0; i--) {
                fileOutputStream.write(buffer[i]);
            }
        }
    }
}
