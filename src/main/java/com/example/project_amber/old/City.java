package com.example.project_amber.old;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private Player owner;
    private List<Building> buildings;

    public City(String name, Player owner) {
        this.name = name;
        this.owner = owner;
        this.buildings = new ArrayList<>();
    }

    public void build(Building building) {
        buildings.add(building);
        System.out.println(owner.getName() + " has built a " + building.getType() + " in " + name);
    }

    public void upgrade() {
        // Logique pour améliorer la ville
        System.out.println(owner.getName() + "'s city " + name + " has been upgraded.");
    }

    public void produceUnit(String unitType) {
        Unit newUnit = null;

        switch (unitType.toLowerCase()) {
            case "archer":
                newUnit = new Archer(owner);
                break;
            case "knight":
                newUnit = new Knight(owner);
                break;
            case "lancer":
                newUnit = new Lancer(owner);
                break;
            default:
                System.out.println("Unknown unit type: " + unitType);
                return; // Exit the method if the unit type is unknown
        }

        System.out.println(owner.getName() + " has produced a " + unitType + " in " + name);
        owner.addUnit(newUnit); // Assuming addUnit method is defined in com.example.project_amber.old.Player
    }


    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
