package org.example.database_ui_localization;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("select_language.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Employee Management");
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        controller.setStage(stage); // Set the stage explicitly
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
