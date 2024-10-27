package com.example.project_amber.old;

public class GuardTower extends Building {
    public GuardTower() {
        super("Guard Tower", 0, 7);
    }

    @Override
    public void produce() {
        System.out.println("Guard Tower provides defense bonus of " + defenseBonus + ".");
    }
}
