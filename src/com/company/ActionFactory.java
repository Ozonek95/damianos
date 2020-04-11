package com.company;

public class ActionFactory {
    private static final String BUY_ACTION = "1";
    private static final String REFEIL_ACTION = "2";
    private final UserInputProvider userInputProvider;
    private final CoffeMachine coffeMachine;

    public ActionFactory(UserInputProvider userInputProvider, CoffeMachine coffeMachine) {
        this.userInputProvider = userInputProvider;
        this.coffeMachine = coffeMachine;
    }

    public Action getAction(String input){
        switch (input) {
            case BUY_ACTION: {
                return new BuyAction(coffeMachine,userInputProvider);
            } case REFEIL_ACTION: {
                return new RefielAction(coffeMachine, userInputProvider);
            }
            default: {
                return new UnknownAction();
            }
        }
    }
}
