package task1801;

import util.InputUtil;

import java.io.FileInputStream;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String filePath = InputUtil.readStringInputFromConsole();

        int maxByte = findMaxByteInFile(filePath);

        printResult(maxByte);
    }

    public static int findMaxByteInFile(String filePath) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int maxByte = Integer.MIN_VALUE;

            int currentByte;
            while ((currentByte = fileInputStream.read()) != -1) {
                if (currentByte > maxByte) {
                    maxByte = currentByte;
                }
            }

            return maxByte;
        }
    }

    public static void printResult(int maxByte) {
        System.out.println("Max byte in the file: " + maxByte);
    }
}
