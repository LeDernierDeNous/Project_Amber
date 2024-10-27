package com.example.project_amber.old;

public class Mine extends Building {
    public Mine() {
        super("com.example.project_amber.old.Mine", 2, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " minerals from com.example.project_amber.old.Mine.");
    }
}
