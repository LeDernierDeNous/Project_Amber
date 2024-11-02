package com.example.project_amber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        MapRenderer mapRenderer = new MapRenderer(10,10);
        mapRenderer.renderMap(gridPane);

        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setTitle("Project Amber game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
