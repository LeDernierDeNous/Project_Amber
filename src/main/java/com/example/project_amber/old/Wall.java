package com.example.project_amber.old;

public class Wall extends Building {
    public Wall() {
        super("com.example.project_amber.old.Wall", 0, 5);
    }

    @Override
    public void produce() {
        System.out.println("com.example.project_amber.old.Wall provides defense bonus of " + defenseBonus + ".");
    }
}
