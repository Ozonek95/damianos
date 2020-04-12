package com.company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoffeMachine {
    private ActionFactory actionFactory;
    private UserInputProvider userInputProvider;
    private Map<ResourceType, Integer> resourceToQuantityMap = new HashMap<>();
    private BigDecimal cashInTheMachine = new BigDecimal(0);

    public CoffeMachine(UserInputProvider userInputProvider) {
        this.userInputProvider = userInputProvider;
        this.actionFactory = new ActionFactory(userInputProvider, this);
        initResources();
    }

    private void initResources() {
        for (ResourceType value : ResourceType.values()) {
            resourceToQuantityMap.put(value, 1000);
        }
    }

    private void performAction(Action action) {
        action.performAction();
    }

    CoffeType buyCoffe(CoffeType coffeType) throws Exception {
        if (checkIfIsEnoughResources(coffeType)) {
            removeRequiredResources(coffeType);
        }
        return coffeType;
    }

    private void removeRequiredResources(CoffeType coffeType) {
        for (Map.Entry<ResourceType, Integer> entry : coffeType.resourceToQuantityMap.entrySet()) {
            resourceToQuantityMap.put(entry.getKey(), resourceToQuantityMap.get(entry.getKey()) - entry.getValue());
        }
    }

    private boolean checkIfIsEnoughResources(CoffeType coffeType) {
        boolean isEnough = true;
        for (Map.Entry<ResourceType, Integer> entry : coffeType.resourceToQuantityMap.entrySet()) {
            if (!(resourceToQuantityMap.get(entry.getKey()) >= entry.getValue())) {
                isEnough = false;
            }
        }
        return isEnough;
    }


    public void run() {
        while (true) {
            System.out.println("Pick action 1BUY 2Refiel");
            performAction(actionFactory.getAction(userInputProvider.provideInput()));
            displayMachineStat();
        }
    }

    void refill(ResourceType resourceType, int value) {
        resourceToQuantityMap.put(resourceType, resourceToQuantityMap.get(resourceType) + value);
    }

    public void displayMachineStat() {
        for (Map.Entry<ResourceType, Integer> entry : resourceToQuantityMap.entrySet()) {
            System.out.println("Teraz mamy tyle " + entry.getValue() + " " + entry.getKey().name());
        }
    }

    public void addMoney(BigDecimal zapłacono) {
        this.cashInTheMachine.add(zapłacono);
    }
}
