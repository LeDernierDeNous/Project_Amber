package com.example.project_amber;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapRenderer {
    private final int rows;
    private final int cols;

    public MapRenderer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void renderMap(GridPane gridPane){
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                int tileSize = 40;
                Rectangle tile = new Rectangle(tileSize, tileSize);
                tile.setFill(Color.rgb((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256)));
                tile.setStroke(Color.BLACK);
                gridPane.add(tile,col,row);
            }
        }
    }
}
