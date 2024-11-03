package com.example.project_amber;

import com.example.project_amber.worldmap.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameUI extends Application {
    public static final String MAP_FILE_PATH = "map_data.json";
    public static final Logger LOGGER = Logger.getLogger(GameUI.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

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
    }
}
