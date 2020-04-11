package com.company;

public class BuyAction implements Action {
    private final CoffeMachine coffeMachine;
    private static final String EXPRESSO = "1";
    private static final String LATTE = "2";
    private final UserInputProvider userInputProvider;

    public BuyAction(CoffeMachine coffeMachine, UserInputProvider userInputProvider) {
        this.coffeMachine = coffeMachine;
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void performAction() {
        System.out.println("Which coffe would you like to order? 1: Expersso, 2:Latte");
        CoffeType coffeType = chooseCoffe(userInputProvider.provideInput());
        try {
            System.out.println(coffeMachine.buyCoffe(coffeType));
        } catch (Exception e) {
            System.err.println("Something went wrong" + e.getMessage());
        }

    }

    private CoffeType chooseCoffe(String input){
        switch (input) {
            case EXPRESSO: {
                return CoffeType.EXPRESSO;
        }
            case LATTE: {
                return CoffeType.LATTE;
            }
            default: return CoffeType.UNKNOWN_TYPE;
        }
    }


}
