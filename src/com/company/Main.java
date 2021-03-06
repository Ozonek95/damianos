package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInputProvider userInputProvider = new UserInputProvider(new Scanner(System.in));

        CoffeMachine coffeMachine = new CoffeMachine( userInputProvider);

        coffeMachine.displayMachineStat();

        coffeMachine.run();

    }
}
