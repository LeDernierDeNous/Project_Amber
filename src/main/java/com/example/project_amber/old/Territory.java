package com.example.project_amber.old;

import java.util.ArrayList;
import java.util.List;

public class Territory {
    private String name;
    private String biome;
    private Resources resources;
    private Player owner;
    private List<Building> buildings;

    public Territory(String name, String biome, Resources resources) {
        this.name = name;
        this.biome = biome;
        this.resources = resources;
        this.buildings = new ArrayList<>();
        this.owner = null; // Initialement sans propriétaire
    }

    public void conquer(Player newOwner) {
        owner = newOwner;
        System.out.println(newOwner.getName() + " has conquered " + name);
    }

    public void gatherResources() {
        // Logique pour récolter les ressources
        System.out.println(owner.getName() + " is gathering resources from " + name);
        // Par exemple, ajouter des ressources à l'objet resources du joueur
    }

    public void build(Building building) {
        buildings.add(building);
        System.out.println(owner.getName() + " has built a " + building.getType() + " in " + name);
    }

    public String getName() {
        return name;
    }

    public String getBiome() {
        return biome;
    }

    public Player getOwner() {
        return owner;
    }

    public Resources getResources() {
        return resources;
    }
}
