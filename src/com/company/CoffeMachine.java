package com.company;

public class CoffeMachine {
    private int remainingExpressos;
    private int remainingLatte;
    private ActionFactory actionFactory;
    private UserInputProvider userInputProvider;

    public CoffeMachine(int remainingExpressos, int remainingLatte, UserInputProvider userInputProvider) {
        this.remainingExpressos = remainingExpressos;
        this.remainingLatte = remainingLatte;
        this.userInputProvider = userInputProvider;
        this.actionFactory = new ActionFactory(userInputProvider, this);
    }

    public void performAction(Action action) {
        action.performAction();
    }

    public CoffeType buyCoffe(CoffeType coffeType) throws Exception {
        switch (coffeType) {
            case EXPRESSO:
                return buy(CoffeType.EXPRESSO);
            case LATTE:
                return buy(CoffeType.LATTE);
            default:
                throw new Exception("Unknonw coffe type");
        }
    }

    private CoffeType buy(CoffeType coffeType) throws Exception {
        if (isEnoughCoffe(coffeType)) {
            return coffeType;
        }
        throw new Exception("Not enough of " + coffeType.name());
    }

    private boolean isEnoughCoffe(CoffeType coffeType) {
        switch (coffeType) {
            case EXPRESSO:
                return remainingExpressos > 0;
            case LATTE:
                return remainingLatte > 0;
        }
        return false;
    }

    public void run() {
        while (true) {
            System.out.println("Pick action 1BUY 2Refiel");
            performAction(actionFactory.getAction(userInputProvider.provideInput()));
        }
    }

    public void refeil(CoffeType coffeType) {
    }
}
