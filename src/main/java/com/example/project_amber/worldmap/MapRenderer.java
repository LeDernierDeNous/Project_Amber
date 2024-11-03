package com.example.project_amber.worldmap;

import com.example.project_amber.worldmap.biomes.Biome;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class MapRenderer {
    private final int rows;
    private final int cols;
    private Biome[][] biomes;  // 2D array to store biomes

    public MapRenderer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.biomes = new Biome[rows][cols];
    }

    public void renderMap(GridPane gridPane) {
        int tileSize = 40;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Rectangle tile = new Rectangle(tileSize, tileSize);

                // Use the biome color if available
                Biome biome = biomes[row][col];
                if (biome != null) {
                    tile.setFill(biome.getColor());
                } else {
                    tile.setFill(Color.GRAY); // Default color for empty biomes
                }

                tile.setStroke(Color.BLACK);
                gridPane.add(tile, col, row);
            }
        }
    }

    // Set biomes for the grid, called by the controller when loading from JSON
    public void setBiomes(Biome[][] biomes) {
        this.biomes = biomes;
    }

    // Get biomes for saving the map
    public Biome[][] getBiomes() {
        return biomes;
    }
}
