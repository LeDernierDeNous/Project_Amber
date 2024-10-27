package com.example.project_amber.old;

public class Farm extends Building {
    public Farm() {
        super("com.example.project_amber.old.Farm", 3, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " food from com.example.project_amber.old.Farm.");
    }
}
