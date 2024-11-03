package com.example.project_amber;

import com.example.project_amber.worldmap.WorldMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the WorldMap object with specified grid size
        WorldMap worldMap = new WorldMap(10, 10);

        // Set up the scene and add the worldMap to it
        Scene scene = new Scene(worldMap, 800, 600);

        primaryStage.setTitle("Project Amber Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
