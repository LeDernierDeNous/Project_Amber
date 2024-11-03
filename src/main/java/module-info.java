module com.example.project_amber {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.project_amber to javafx.fxml;
    exports com.example.project_amber;
    exports com.example.project_amber.fx_old;
    opens com.example.project_amber.fx_old to javafx.fxml;
}