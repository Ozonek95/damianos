package com.company;

public class UnknownAction implements Action {
    @Override
    public void performAction() {
        System.out.println("Nieznana akcja, sorka");
    }
}
