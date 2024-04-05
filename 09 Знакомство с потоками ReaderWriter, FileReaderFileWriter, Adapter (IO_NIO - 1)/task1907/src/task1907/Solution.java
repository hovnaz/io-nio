package task1907;

import util.InputUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String inputFilePath = InputUtil.readStringInputFromConsole();

        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader fileBufferedReader = new BufferedReader(fileReader)) {

            int count = 0;
            String line;
            while ((line = fileBufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase("world")) {
                        count++;
                    }
                }
            }

            System.out.println("Number of occurrences of 'world': " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
