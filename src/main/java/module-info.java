module com.example.project_amber {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.project_amber to javafx.fxml;
    exports com.example.project_amber;
}