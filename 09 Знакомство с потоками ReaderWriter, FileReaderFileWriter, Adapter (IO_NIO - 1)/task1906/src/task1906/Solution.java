package task1906;

import util.InputUtil;

import java.io.*;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String inputFilePath = InputUtil.readStringInputFromConsole();
        String outputFilePath = InputUtil.readStringInputFromConsole();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int charValue;
            int count = 1;

            while ((charValue = reader.read()) != -1) {
                if (count % 2 == 0) {  // Check if the position is even
                    writer.write(charValue);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
