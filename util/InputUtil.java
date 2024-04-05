package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readStringInputFromConsole() throws IOException {
        System.out.println("Please enter your input:");
        return reader.readLine();
    }
}
