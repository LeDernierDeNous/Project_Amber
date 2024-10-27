package com.example.project_amber.old;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Map map;
    private int currentTurn;

    public Game() {
        this.players = new ArrayList<>();
        this.map = new Map();
        this.currentTurn = 0;
    }

    public void startGame() {
        map.generateMap();
        // Initialiser les joueurs, leur attribuer des territoires, etc.
    }

    public void endGame() {
        // Logique pour gérer la fin du jeu
    }

    public void nextTurn() {
        currentTurn++;
        // Mettre à jour l'état du jeu pour le nouveau tour
    }

    public List<Player> getPlayerStats() {
        return players; // Ou une représentation plus détaillée des stats
    }
}
