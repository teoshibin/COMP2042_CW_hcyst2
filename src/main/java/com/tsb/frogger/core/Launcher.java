package com.tsb.frogger.core;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Main game window class
 */
public class Launcher extends Application {

    /**
     * Launch window
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Load main menu window
     * @param primaryStage main window
     * @throws IOException fail to load fxml exception
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
        Scene scene = new Scene(menu);
        scene.getStylesheets().add(getClass().getResource("../style/standard.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Frogger");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image("file:src/main/resources/com/tsb/frogger/images/misc/icon-frogger-pixel-512x512.png"));
        primaryStage.show();
    }
}
