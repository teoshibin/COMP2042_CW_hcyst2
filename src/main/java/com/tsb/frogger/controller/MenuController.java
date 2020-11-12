package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.Game;
import com.tsb.frogger.data.FileUsername;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main menu controller for menu GUI
 */
public class MenuController implements Initializable {
    /**
     * anchor pane
     */
    @FXML
    public AnchorPane menuPane;
    /**
     * label
     */
    @FXML
    public Label usernameLabel;
    /**
     * button
     */
    @FXML
    private Button playBtn;
    /**
     * button
     */
    @FXML
    private Button scoreBtn;
    /**
     * button
     */
    @FXML
    private Button optionBtn;
    /**
     * button
     */
    @FXML
    private Button creditBtn;
    /**
     * button
     */
    @FXML
    private Button quitBtn;

    /**
     * handle main menu GUI button event
     * @param actionEvent button event
     * @throws IOException exception
     */
    @FXML
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        switch (((Button)actionEvent.getSource()).getText()){
            case "Play":
                Sound.stopMenuMusic();
                Game game = new Game("Guest", 1);
                // TODO: 11/12/2020
                Pane gamePane = game.createPane();
                game.start();
                menuPane.getChildren().setAll(gamePane);
                break;
            case "Scores":
                Pane scorePane = FXMLLoader.load(getClass().getResource("../view/Scoreboard.fxml"));
                menuPane.getChildren().setAll(scorePane);
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
        Sound.BtnSound();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(FileUsername.readUsernames().get(AccountController.getSelectedNameIndex()));
    }
}
