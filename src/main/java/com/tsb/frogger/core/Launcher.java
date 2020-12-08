package com.tsb.frogger.core;

import com.tsb.frogger.controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
     */
    @Override
    public void start(Stage primaryStage) {

        //init all runtime data
        RuntimeData.init();

        //main screen controller
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadMarkdown(ConstantData.SCREEN_ID_ACCOUNT, ConstantData.FXML_ACCOUNT);
        mainContainer.setScreen(ConstantData.SCREEN_ID_ACCOUNT);

        // root node
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/tsb/frogger/style/standard.css").toExternalForm());

        // main stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(ConstantData.STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image(ConstantData.IMAGE_FROGGER_ICON));
        primaryStage.show();
    }
}
