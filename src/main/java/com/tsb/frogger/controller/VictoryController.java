package com.tsb.frogger.controller;

import com.tsb.frogger.core.Game;
import com.tsb.frogger.core.Sound;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.files.FileScore;
import com.tsb.frogger.files.FileUsername;
import com.tsb.frogger.core.RuntimeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * victory controller for victory GUI
 */
public class VictoryController implements Initializable {

    /**
     * image view
     */
    @FXML
    public ImageView newImageView;
    /**
     * button
     */
    @FXML
    private Button continueBtn;
    /**
     * label
     */
    @FXML
    private Label highestScoreLabel;
    /**
     * label
     */
    @FXML
    private Label usernameLabel;
    /**
     * label
     */
    @FXML
    private Label levelLabel;
    /**
     * label
     */
    @FXML
    private Label scoreLabel;

    /**
     * handle action event
     * @param actionEvent event
     */
    public void handleBtnAction(ActionEvent actionEvent) {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Leave", "Done" -> {
                try {
                    Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
//                    RuntimeData.game.getGamePane().getChildren().setAll(menuPane);
                    // TODO
//                    RuntimeData.pane.getChildren().setAll(menuPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Sound.stopMediaPlayer();
            }
            case "Continue" -> {
//                RuntimeData.game.setLevel(RuntimeData.game.getLevel() + 1);
//                RuntimeData.pane.getChildren().setAll(RuntimeData.game.createPane());
//                RuntimeData.game.start();
            }
        }
    }

    /**
     * mouse enter event
     * @param mouseEvent event
     */
    public void MouseEnter(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    /**
     * set game object
     * @param game game object
     */
//    public static void setGame(Game game){
//        VictoryController.game = game;
//    }

    /**
     * init GUI
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int playerIndex = RuntimeData.selectedUsernameIndex;
        int currentScore = RuntimeData.game.getScore();
        int currentLevel = RuntimeData.game.getLevel();
        int previousHighScore = FileScore.readScore(playerIndex, currentLevel);

        usernameLabel.setText(FileUsername.readUsernames().get(playerIndex));
        levelLabel.setText(Integer.toString(currentLevel));
        scoreLabel.setText(Integer.toString(currentScore));

        if(currentScore <= previousHighScore){
            highestScoreLabel.setText(Integer.toString(previousHighScore));
            newImageView.setVisible(false);
        } else {
            highestScoreLabel.setText(Integer.toString(currentScore));
            FileScore.writeScore(playerIndex, currentLevel, currentScore);
            newImageView.setVisible(true);
        }
        if(RuntimeData.game.getLevel() == Game.MAX_LEVEL){
            continueBtn.setText("Done");
        }
    }
}
