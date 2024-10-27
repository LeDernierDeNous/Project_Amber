package com.example.project_amber.old;

public class Sawmill extends Building {
    public Sawmill() {
        super("com.example.project_amber.old.Sawmill", 2, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " wood from com.example.project_amber.old.Sawmill.");
    }
}