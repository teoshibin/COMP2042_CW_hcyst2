package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.*;
import com.tsb.frogger.utils.sound.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * account controller for GUI
 */
public class AccountController implements Initializable, ControlledScreen {
    /**
     * name text field
     */
    @FXML
    public TextField nameTextField;
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * hold player index while editing
     */
    private int holdIndex;
    /**
     * name list view
     */
    @FXML
    private ListView<String> nameListView;
    /**
     * button
     */
    @FXML
    private Button addBtn;
    /**
     * button
     */
    @FXML
    private Button deleteBtn;

    /**
     * initialize account page gui
     *
     * @param location  location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PlayersDao playersDao = new PlayersDaoImpl();
        AssetsDao ad = new AssetsDaoImpl();
        Convertor convertor = new Convertor();
        nameListView.setItems(convertor.convertArrayListToObservableList(playersDao.getAllUsernames()));
        nameListView.getSelectionModel().select(0);
        Sound.playMediaPlayer(ad.getExternal("sound.music.arcade"));
    }

    /**
     * handle button event
     *
     * @param actionEvent event
     * @throws IOException exception
     */
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        PlayersDao playersDao = new PlayersDaoImpl();
        AssetsDao ad = new AssetsDaoImpl();
        Convertor convertor = new Convertor();
        switch (((Button) actionEvent.getSource()).getText()) {
            case "Add" -> {
                if (playersDao.addPlayer(nameTextField.getText())) {
                    nameTextField.setText("");
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.success"));
                } else {
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.error"));
                }
            }
            case "Delete" -> {
                if (playersDao.deletePlayer(nameListView.getSelectionModel().getSelectedIndex())) {
                    nameListView.getSelectionModel().select(0);
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.success"));
                } else {
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.error"));
                }
            }
            case "Edit" -> {
                holdIndex = nameListView.getSelectionModel().getSelectedIndex();
                if (holdIndex > 0) {
                    nameTextField.setText(nameListView.getSelectionModel().getSelectedItem());
                    editMode(true);
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.pageFlip"));
                } else {
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.error"));
                }
            }
            case "Done" -> {
                if (playersDao.updatePlayer(holdIndex, nameTextField.getText())) {
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.success"));
                } else {
                    Sound.playAudioClip(ad.getExternal("sound.clip.ui.error"));
                }
                nameTextField.setText("");
                editMode(false);
            }
            case "Cancel" -> {
                editMode(false);
                nameTextField.setText("");
                Sound.playAudioClip(ad.getExternal("sound.clip.ui.pageFlip"));
            }
            case "Enter" -> {
                // save runtime data
                RuntimeData.selectedPlayerIndex = nameListView.getSelectionModel().getSelectedIndex();

                if (RuntimeData.selectedPlayerIndex < 0) {
                    RuntimeData.selectedPlayerIndex = 0;
                }

                // load screens
                myController.loadMarkdown(ConstantData.SCREEN_ID_MENU, ad.getName("fxml.menu"));
                myController.loadMarkdown(ConstantData.SCREEN_ID_INFO, ad.getName("fxml.info"));
                myController.loadMarkdown(ConstantData.SCREEN_ID_SCOREBOARD, ad.getName("fxml.scoreboard"));
                myController.loadMarkdown(ConstantData.SCREEN_ID_SELECT_LEVEL, ad.getName("fxml.selectLevel"));
                myController.loadMarkdown(ConstantData.OVERLAY_ID_OPTION, ad.getName("fxml.option"));
                // set screen
                myController.setScreen(ConstantData.SCREEN_ID_MENU);
            }
        }
        //update listview
        nameListView.setItems(convertor.convertArrayListToObservableList(playersDao.getAllUsernames()));
    }

    /**
     * change gui when enter username edit mode
     *
     * @param bool edit mode state
     */
    private void editMode(boolean bool) {
        if (bool) {
            if (addBtn.getStyleClass().get(3).equals("addBtn")) {
                addBtn.setText("Done");
                addBtn.getStyleClass().remove("addBtn");
                addBtn.getStyleClass().add("doneBtn");

                deleteBtn.setText("Cancel");
                deleteBtn.getStyleClass().remove("deleteBtn");
                deleteBtn.getStyleClass().add("cancelBtn");
            }
        } else {
            if (!addBtn.getStyleClass().get(3).equals("addBtn")) {
                addBtn.setText("Add");
                addBtn.getStyleClass().remove("doneBtn");
                addBtn.getStyleClass().add("addBtn");

                deleteBtn.setText("Delete");
                deleteBtn.getStyleClass().remove("cancelBtn");
                deleteBtn.getStyleClass().add("deleteBtn");
            }
        }
    }

    /**
     * play button pop up sound effect
     *
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        AssetsDao ad = new AssetsDaoImpl();
        Sound.playAudioClip(ad.getExternal("sound.clip.ui.button"));
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
