package com.example.workshojavafxjdbc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        Parent parent = fxmlLoader.load();
        Scene mainScene = new Scene(parent);
        stage.setScene(mainScene);
        stage.setTitle("Sample JavaFX application");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}