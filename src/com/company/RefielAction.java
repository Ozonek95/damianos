package com.company;

public class RefielAction implements Action {
    private static final String EXPRESSO = "1";
    private static final String LATTE = "2";

    private final CoffeMachine coffeMachine;
    private UserInputProvider userInputProvider;

    public RefielAction(CoffeMachine coffeMachine, UserInputProvider userInputProvider) {
        this.coffeMachine = coffeMachine;

        this.userInputProvider = userInputProvider;
    }


    @Override
    public void performAction() {
        System.out.println("What you want to refeil? 1 Espresso 2 latte");
        String input = userInputProvider.provideInput();
        switch (input) {
            case EXPRESSO: {
                coffeMachine.refeil(CoffeType.EXPRESSO);
            }
            case LATTE: {
                coffeMachine.refeil(CoffeType.LATTE);
            }
        }
    }
}
