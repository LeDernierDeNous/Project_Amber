package com.example.project_amber.old;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private String name;
    private Faction faction;
    private Resources resources;
    private List<Unit> army;
    private List<City> cities;

    public Player(String id, String name, Faction faction) {
        this.id = id;
        this.name = name;
        this.faction = faction;
        this.resources = new Resources();
        this.army = new ArrayList<>();
        this.cities = new ArrayList<>();
    }

    public void attack(Player target) {
        // Logique d'attaque
        System.out.println(name + " is attacking " + target.getName());
        // Calculer les dommages, retirer des unités, etc.
    }

    public void trade(Player target) {
        // Logique d'échange
        System.out.println(name + " is trading with " + target.getName());
        // Gestion des ressources échangées
    }

    public void buildCity(String cityName) {
        // Logique pour construire une ville
        City newCity = new City(cityName, this);
        cities.add(newCity);
        System.out.println(name + " has built a new city: " + cityName);
    }

    public void upgradeUnit(Unit unit) {
        // Logique pour améliorer une unité
        System.out.println(name + " is upgrading a unit.");
        // Augmenter les attributs de l'unité
    }

    public String getName() {
        return name;
    }

    public List<City> getCities() {
        return cities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Unit> getArmy() {
        return army;
    }

    public void addUnit(Unit unit) {
        this.army.add(unit);
    }

    public void addArmy(List<Unit> army) {
        this.army.addAll(army);
    }
}
