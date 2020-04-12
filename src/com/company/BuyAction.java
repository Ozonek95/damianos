package com.company;

import java.math.BigDecimal;

public class BuyAction implements Action {
    private final CoffeMachine coffeMachine;
    private final UserInputProvider userInputProvider;

    public BuyAction(CoffeMachine coffeMachine, UserInputProvider userInputProvider) {
        this.coffeMachine = coffeMachine;
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void performAction() {
        System.out.println("Which coffe would you like to order? 1: Expersso, 2:Latte");
        CoffeType coffeType = chooseCoffe(userInputProvider.provideInput().toUpperCase());
        System.out.println("Zapłać leszczu "+coffeType.cost);
        BigDecimal zapłacono = new BigDecimal(userInputProvider.provideInput());
        coffeMachine.addMoney(zapłacono);
        try {
            System.out.println(coffeMachine.buyCoffe(coffeType));
        } catch (Exception e) {
            System.err.println("Something went wrong" + e.getMessage());
        }

    }

    private CoffeType chooseCoffe(String input) {
        return CoffeType.valueOf(input);
    }
}
