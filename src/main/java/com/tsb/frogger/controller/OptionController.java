package com.tsb.frogger.controller;

import com.tsb.frogger.world.Game;
import com.tsb.frogger.world.MyStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class OptionController {

    public AnchorPane optionPane;
    private static Pane parentPane;
    private static Game game;
    private static MyStage gamePane;

    @FXML
    private Button backBtn;

    public void handleBtnAction(ActionEvent actionEvent) {
        if(((Button)actionEvent.getSource()).getText().equals("Back")){
            parentPane.getChildren().remove(optionPane);
            game.resume();
            gamePane.start();
        }
    }

    public static void setParentPane(Pane pane){
        parentPane = pane;
    }

    public static void setGameInfo(MyStage gamePane, Game game){
        OptionController.gamePane = gamePane;
        OptionController.game = game;
    }
}
