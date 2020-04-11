package com.company;

import java.util.Scanner;

public class UserInputProvider {
    private final Scanner scanner;

    public UserInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }


    public String provideInput() {
        return scanner.nextLine();
    }
}
