package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.*;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * scoreboard controller for scoreboard GUI
 */
public class ScoreboardController implements Initializable, ControlledScreen{
    /**
     * main screen controller
     */
    private ScreensController myController;
    /**
     * selected level
     */
    private int selectedLevel = 1;
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
     * init GUI
     *
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateInfo();
    }

    /**
     * handle action event
     *
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
            case "Back" -> myController.setScreen(ConstantData.SCREEN_ID_MENU);
        }
        updateInfo();
    }

    /**
     * mouse enter event
     *
     * @param mouseEvent event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.button"));
    }

    /**
     * mouse click event
     *
     * @param mouseEvent event
     */
    public void clickBtn(MouseEvent mouseEvent) {
        PropertiesDao pd = new PropertiesDaoImpl();
        Sound.playAudioClip(pd.getExternal("sound.clip.ui.pageFlip"));
    }

    /**
     * update display info
     *
     */
    public void updateInfo(){
        PlayersDao playersDao = new PlayersDaoImpl();
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

        // resize width
        scoreboardTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * fetch data from player data access object, create table content and convert it into observable list
     *
     * @return observable list of table content
     */
    public ObservableList<TableViewPlayer> getTableViewPlayer(){
        // instantiate dao
        PlayersDao playersDao = new PlayersDaoImpl();
        // instantiate convertor object
        Convertor convertor = new Convertor();
        // create empty list and assign a converted zipped arraylist into it
        ObservableList<TableViewPlayer> tableViewPlayers = FXCollections.observableArrayList();
        tableViewPlayers.addAll(
                convertor.convertToObservableListZipTwo(
                        TableViewPlayer.class,
                        String.class,
                        Integer.class,
                        playersDao.getAllUsernames(),
                        playersDao.getAllHighScores(selectedLevel)
                )
        );
        return tableViewPlayers;
    }

    /**
     * set main screen controller
     *
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
