package task1805;

import util.InputUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* 
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/

public class Solution {

    private static Set<Integer> bytes = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {

        String filePath = InputUtil.readStringInputFromConsole();

        readBytesFromFileAndAdd(filePath);

        sortBytes();
        printResult();
    }

    public static void readBytesFromFileAndAdd(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int currentByte;
            while ((currentByte = fileInputStream.read()) != -1) {
                bytes.add(currentByte);
            }
        }
    }

    public static void sortBytes() {
        bytes = bytes.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void printResult() {
        System.out.println(bytes);
    }
}
