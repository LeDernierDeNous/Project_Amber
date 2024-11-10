package com.example.project_amber;

import com.example.project_amber.worldmap.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameUI extends Application {
    public static final String MAP_FILE_PATH = "map_data.json";
    public static final Logger LOGGER = Logger.getLogger(GameUI.class.getName());

    @Override
    public void start(Stage primaryStage) throws IOException {
        WorldMapUI worldMap = new WorldMapUI(10, 10);

        // Add worldMap to the scene
        Scene scene = new Scene(worldMap, 800, 600);
        primaryStage.setTitle("Project Amber Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Save map data on application exit
        primaryStage.setOnCloseRequest(event -> {
            try {
                worldMap.closeWorldMap();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Create an AnimationTimer for continuous updates
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update the scene here
                updateScene(worldMap);
            }
        };

        // Start the AnimationTimer (it will call handle() on each frame)
        animationTimer.start();
    }

    private void updateScene(WorldMapUI worldMap) {
        // You can also update other aspects of worldMap, like adding/removing shapes, updating labels, etc.

    }
}
