package icecream.utils;

import java.util.Scanner;

public class ConsoleHandler implements IHandler {

    private final Scanner scanner;

    public ConsoleHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return "";
    }
}
