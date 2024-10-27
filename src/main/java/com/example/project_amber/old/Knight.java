package com.example.project_amber.old;

public class Knight extends Unit {
    public Knight(Player owner) {
        super("com.example.project_amber.old.Knight", 10, 5, owner);
    }

    @Override
    public void attack(Unit target) {
        int damage = Math.max(0, attackPower - target.getDefensePower());
        target.defend(damage);
        System.out.println(owner.getName() + " attacks " + target.getOwner().getName() + " with a com.example.project_amber.old.Knight, dealing " + damage + " damage.");
    }

    @Override
    public void defend(int damage) {
        System.out.println("com.example.project_amber.old.Knight defends against " + damage + " damage.");
    }
}
