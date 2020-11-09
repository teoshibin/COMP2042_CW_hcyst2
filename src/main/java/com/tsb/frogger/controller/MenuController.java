package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main menu controller for menu gui
 */
public class MenuController {
    @FXML
    public AnchorPane menuPane;
    @FXML
    private Button playBtn;
    @FXML
    private Button scoreBtn;
    @FXML
    private Button optionBtn;
    @FXML
    private Button creditBtn;
    @FXML
    private Button quitBtn;

    /**
     * handle main menu GUI button event
     * @param actionEvent button event
     */
    @FXML
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        switch (((Button)actionEvent.getSource()).getText()){
            case "Play":
                Sound.stopMenuMusic();
                Game game = new Game("Guest", 0);
                Pane gamePane = game.getPane();
                game.start();
                menuPane.getChildren().setAll(gamePane);
                break;
            case "Scores":
                // TODO: 11/3/2020
                break;
            case "Options":
                Pane optionPane = FXMLLoader.load(getClass().getResource("../view/Option.fxml"));
                menuPane.getChildren().add(optionPane);
                OptionController.setParentPane(menuPane);
                break;
            case "Info":
                Pane infoPane = FXMLLoader.load(getClass().getResource("../view/Info.fxml"));
                menuPane.getChildren().setAll(infoPane);
                break;
            case "Back":
                Pane accountPane = FXMLLoader.load(getClass().getResource("../view/Account.fxml"));
                menuPane.getChildren().setAll(accountPane);
                break;
            case "Quit":
                Stage stage = (Stage) quitBtn.getScene().getWindow();
                stage.close();
                break;
        }
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playBtnSound();
    }
}
