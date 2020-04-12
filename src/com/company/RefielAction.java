package com.company;

public class RefielAction implements Action {
    private final CoffeMachine coffeMachine;
    private UserInputProvider userInputProvider;

    public RefielAction(CoffeMachine coffeMachine, UserInputProvider userInputProvider) {
        this.coffeMachine = coffeMachine;
        this.userInputProvider = userInputProvider;
    }


    @Override
    public void performAction() {
        System.out.println("What you want to refill? 1 water 2 milk, 3 beans");
        String input = userInputProvider.provideInput();
        System.out.println("How much?");
        int quantity = Integer.parseInt(userInputProvider.provideInput());
        coffeMachine.refill(ResourceType.valueOf(input), quantity);
    }
}
