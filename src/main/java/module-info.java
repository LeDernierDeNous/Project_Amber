module com.example.project_amber {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.logging;

    opens com.example.project_amber to javafx.fxml;
    exports com.example.project_amber;
    exports com.example.project_amber.fx_old;
    opens com.example.project_amber.fx_old to javafx.fxml;
    exports com.example.project_amber.worldmap;
    opens com.example.project_amber.worldmap to javafx.fxml;
    exports com.example.project_amber.worldmap.biomes;
    opens com.example.project_amber.worldmap.biomes to javafx.fxml, com.fasterxml.jackson.databind;

}