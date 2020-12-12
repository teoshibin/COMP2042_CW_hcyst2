package com.tsb.frogger.core;

import com.tsb.frogger.controller.ScreensController;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
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

        //initialize game data and load assets
        RuntimeData.init(ConstantData.SAVE_FILE_PATH, ConstantData.ASSET_PROPERTY_PATH);

        PropertiesDao pd = new PropertiesDaoImpl();

        //main screen controller
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadMarkdown(ConstantData.SCREEN_ID_ACCOUNT, pd.getName("fxml.account"));
        mainContainer.setScreen(ConstantData.SCREEN_ID_ACCOUNT);

        // root node
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(pd.getExternal("style.css.standard"));

        // main stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Frogger");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image(pd.getExternal("image.icon.frog")));
        primaryStage.show();
    }
}
