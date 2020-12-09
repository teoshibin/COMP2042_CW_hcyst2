package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.Convertor;
import com.tsb.frogger.utils.data.datamanager.PlayersDao;
import com.tsb.frogger.utils.data.datamanager.PlayersDaoImpl;
import com.tsb.frogger.utils.data.datastructure.TableViewPlayer;
import com.tsb.frogger.utils.sound.Sound;
import com.tsb.frogger.world.LevelSelector;
import com.tsb.frogger.world.actors.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * scoreboard controller for scoreboard GUI
 */
public class ScoreboardController implements Initializable, ControlledScreen{
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * data access object
     */
    PlayersDao playersDao = new PlayersDaoImpl();
    /**
     * table view
     */
    @FXML
    public TableView<TableViewPlayer> scoreboardTable;
    /**
     * column
     */
    @FXML
    public TableColumn<TableViewPlayer, String> usernameColumn;
    /**
     * column
     */
    @FXML
    public TableColumn<TableViewPlayer, Integer> highScoreColumn;
    /**
     * anchor pane
     */
    @FXML
    private AnchorPane scoreBoardPane;
    /**
     * label
     */
    @FXML
    private Label nameLabel;
    /**
     * label
     */
    @FXML
    private Label levelLabel;
    /**
     * label
     */
    @FXML
    private Label maxLevelLabel;
    /**
     * label
     */
    @FXML
    private Label highestScoreLabel;
    /**
     * label
     */
    @FXML
    private Label maxScoreLabel;

    /**
     * selected level
     */
    private int selectedLevel = 1;

    /**
     * init GUI
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateInfo();
    }

    /**
     * handle action event
     * @param actionEvent event
     * @throws IOException exception
     */
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Prev" -> {
                selectedLevel--;
                if (selectedLevel < 1) {
                    selectedLevel = LevelSelector.MAX_LEVEL;
                }
            }
            case "Next" -> {
                selectedLevel++;
                if (selectedLevel > LevelSelector.MAX_LEVEL) {
                    selectedLevel = 1;
                }
            }
            case "Back" -> {
                myController.setScreen(ConstantData.SCREEN_ID_MENU);
            }
        }
        updateInfo();
    }

    /**
     * mouse enter event
     * @param mouseEvent event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    /**
     * mouse click event
     * @param mouseEvent event
     */
    public void clickBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_PAGE_FLIP);
    }

    /**
     * update display info
     */
    public void updateInfo(){
        // set username
        nameLabel.setText(playersDao.getUsername(RuntimeData.selectedPlayerIndex));
        // set current level page
        levelLabel.setText(String.valueOf(selectedLevel));
        // set max possible level
        maxLevelLabel.setText(String.valueOf(LevelSelector.MAX_LEVEL));
        // set personal current level high score
        highestScoreLabel.setText(
                String.valueOf(playersDao.getHighScore(RuntimeData.selectedPlayerIndex,selectedLevel))
        );
        // set max possible score
        maxScoreLabel.setText(String.valueOf(Animal.MAX_SCORE));

        // assign TableViewPlayer class variables into table
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        highScoreColumn.setCellValueFactory(new PropertyValueFactory<>("currentLevelHighScore"));
        // parse data into table
        scoreboardTable.setItems(getTableViewPlayer());

        // sort high score in descending order
        highScoreColumn.setSortType(TableColumn.SortType.DESCENDING);
        // add high score column as sorting target
        scoreboardTable.getSortOrder().add(highScoreColumn);
        // sort
        scoreboardTable.sort();
    }

    public ObservableList<TableViewPlayer> getTableViewPlayer(){
        Convertor convertor = new Convertor();
        ObservableList<TableViewPlayer> tableViewPlayers = FXCollections.observableArrayList();
        try {
            tableViewPlayers.addAll(
                convertor.convertToObservableListZipTwo(
                    TableViewPlayer.class,
                    String.class,
                    Integer.class,
                    playersDao.getAllUsernames(),
                    playersDao.getAllHighScores(selectedLevel)
                )
            );
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return tableViewPlayers;
    }

    /**
     * set main screen controller
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
