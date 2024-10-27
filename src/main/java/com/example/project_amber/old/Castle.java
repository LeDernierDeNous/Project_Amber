package com.example.project_amber.old;

public class Castle extends Building {
    public Castle() {
        super("com.example.project_amber.old.Castle", 5, 10);
    }

    @Override
    public void produce() {
        System.out.println("com.example.project_amber.old.Castle produces " + productionRate + " resources and provides a defense bonus of " + defenseBonus + ".");
    }
}
