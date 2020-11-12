package com.tsb.frogger.controller;

import com.tsb.frogger.core.Game;
import com.tsb.frogger.world.MyStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * option controller for option GUI
 */
public class OptionController {

    /**
     * game object
     */
    private static Game game;
    /**
     * game parent node
     */
    private static MyStage gamePane;
    /**
     * anchor pane
     */
    @FXML
    public AnchorPane optionPane;
    /**
     * previous parent pane
     */
    @FXML
    private static Pane parentPane;

    /**
     * handle action event
     * @param actionEvent event
     */
    public void handleBtnAction(ActionEvent actionEvent) {
        if(((Button)actionEvent.getSource()).getText().equals("Back")){
            parentPane.getChildren().remove(optionPane);
            game.resume();
            gamePane.start();
        }
    }

    /**
     * set parent node
     * @param pane parent node
     */
    public static void setParentPane(Pane pane){
        parentPane = pane;
    }

    /**
     * set game info
     * @param gamePane game stage parent node
     * @param game game object
     */
    public static void setGameInfo(MyStage gamePane, Game game){
        OptionController.gamePane = gamePane;
        OptionController.game = game;
    }
}
