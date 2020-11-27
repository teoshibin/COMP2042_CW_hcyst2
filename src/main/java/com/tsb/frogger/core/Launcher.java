package com.tsb.frogger.core;

import com.tsb.frogger.controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadMarkdown(ConstantData.SCREEN_ACCOUNT, ConstantData.FXML_ACCOUNT);

        mainContainer.setScreen(ConstantData.SCREEN_ACCOUNT);

//        RuntimeData.pane = FXMLLoader.load(getClass().getResource("../view/Account.fxml"));
//        Scene scene = new Scene(RuntimeData.pane);
//
//        FXMLLoader accountPaneLoader = new FXMLLoader(getClass().getResource("../view/Account.fxml"));
//        Parent accountPane = accountPaneLoader.load();
//        Scene accountScene = new Scene(accountPane);
//
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../style/standard.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle(ConstantData.STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image(ConstantData.IMAGE_FROGGER_ICON));
        primaryStage.show();
    }
}
