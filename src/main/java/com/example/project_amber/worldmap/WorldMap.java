package com.example.project_amber.worldmap;

import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;

public class WorldMap extends Pane {

    private double initialX;
    private double initialY;
    private double scaleFactor = 1.0;
    private static final double SCALE_STEP = 0.1;
    private final GridPane gridPane;
    private final Scale scale;

    public WorldMap(int rows, int cols) {
        // Initialize the grid pane and map
        gridPane = new GridPane();
        MapRenderer mapRenderer = new MapRenderer(rows, cols);
        mapRenderer.renderMap(gridPane);

        // Create and apply the scale transformation
        scale = new Scale(scaleFactor, scaleFactor, 0, 0);
        gridPane.getTransforms().add(scale);

        // Add gridPane to the WorldMap pane
        this.getChildren().add(gridPane);

        // Set up event handlers for dragging and zooming
        setupDragging();
        setupZooming();
    }

    private void setupDragging() {
        this.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) { // click
                initialX = event.getSceneX();
                initialY = event.getSceneY();
            }
        });

        this.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) { // hold click drag
                double offsetX = event.getSceneX() - initialX;
                double offsetY = event.getSceneY() - initialY;

                // Move the gridPane by adjusting its layout positions
                gridPane.setLayoutX(gridPane.getLayoutX() + offsetX);
                gridPane.setLayoutY(gridPane.getLayoutY() + offsetY);

                initialX = event.getSceneX();
                initialY = event.getSceneY();
            }
        });
    }

    private void setupZooming() {
        this.setOnScroll((ScrollEvent event) -> {
            if (event.getDeltaY() > 0) {
                scaleFactor += SCALE_STEP;
            } else {
                scaleFactor -= SCALE_STEP;
                scaleFactor = Math.max(scaleFactor, SCALE_STEP); // Prevent zooming out too far
            }
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });
    }
}
