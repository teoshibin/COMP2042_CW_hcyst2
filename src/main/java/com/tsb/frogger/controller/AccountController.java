package com.tsb.frogger.controller;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datamanager.Convertor;
import com.tsb.frogger.utils.data.datamanager.PlayersDao;
import com.tsb.frogger.utils.data.datamanager.PlayersDaoImpl;
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
public class AccountController implements Initializable, ControlledScreen{
    /**
     * main screen controller
     */
    ScreensController myController;
    /**
     * data access object
     */
    PlayersDao playersDao = new PlayersDaoImpl();
    /**
     * data convertor
     */
    Convertor convertor = new Convertor();
    /**
     * name text field
     */
    @FXML
    public TextField nameTextField;
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
     * hold player index while editing
     */
    private int holdIndex;

    /**
     * initialize account page gui
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameListView.setItems(convertor.convertArrayListToObservableList(playersDao.getAllUsernames()));
        Sound.playMediaPlayer(ConstantData.MUSIC_ARCADE);
    }

    /**
     * handle button event
     * @param actionEvent event
     * @throws IOException exception
     */
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {

        switch (((Button)actionEvent.getSource()).getText()){
            case "Add" -> {
                if (playersDao.addPlayer(nameTextField.getText())) {
                    nameTextField.setText("");
                    Sound.playAudioClip(ConstantData.SOUND_SUCCESS);
                } else {
                    Sound.playAudioClip(ConstantData.SOUND_ERROR);
                }
            }
            case "Delete"->{
                if(playersDao.deletePlayer(nameListView.getSelectionModel().getSelectedIndex())){
                    nameListView.getSelectionModel().select(0);
                    Sound.playAudioClip(ConstantData.SOUND_SUCCESS);
                } else {
                    Sound.playAudioClip(ConstantData.SOUND_ERROR);
                }
            }
            case "Edit"->{
                holdIndex = nameListView.getSelectionModel().getSelectedIndex();
                if(holdIndex > 0){
                    nameTextField.setText(nameListView.getSelectionModel().getSelectedItem());
                    editMode(true);
                    Sound.playAudioClip(ConstantData.SOUND_PAGE_FLIP);
                } else {
                    Sound.playAudioClip(ConstantData.SOUND_ERROR);
                }
            }
            case "Done"->{
                if (playersDao.updatePlayer(holdIndex, nameTextField.getText())){
                    Sound.playAudioClip(ConstantData.SOUND_SUCCESS);
                } else {
                    Sound.playAudioClip(ConstantData.SOUND_ERROR);
                }
                nameTextField.setText("");
                editMode(false);
            }
            case "Cancel"->{
                editMode(false);
                nameTextField.setText("");
                Sound.playAudioClip(ConstantData.SOUND_PAGE_FLIP);
            }
            case "Enter"->{
                // save runtime data
                RuntimeData.selectedPlayerIndex = nameListView.getSelectionModel().getSelectedIndex();

                // load screens
                myController.loadMarkdown(ConstantData.SCREEN_ID_MENU, ConstantData.FXML_MENU);
                myController.loadMarkdown(ConstantData.SCREEN_ID_INFO, ConstantData.FXML_INFO);
                myController.loadMarkdown(ConstantData.SCREEN_ID_SCOREBOARD, ConstantData.FXML_SCOREBOARD);
                myController.loadMarkdown(ConstantData.SCREEN_ID_SELECT_LEVEL, ConstantData.FXML_SELECT_LEVEL);
                myController.loadMarkdown(ConstantData.OVERLAY_ID_OPTION, ConstantData.FXML_OPTION);
                // set screen
                myController.setScreen(ConstantData.SCREEN_ID_MENU);
            }
        }
        //update listview
        nameListView.setItems(convertor.convertArrayListToObservableList(playersDao.getAllUsernames()));
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.SOUND_BUTTON);
    }

    /**
     * change gui when enter username edit mode
     * @param bool edit mode state
     */
    private void editMode(boolean bool){
        if (bool){
            if (addBtn.getStyleClass().get(3).equals("addBtn")){
                addBtn.setText("Done");
                addBtn.getStyleClass().remove("addBtn");
                addBtn.getStyleClass().add("doneBtn");

                deleteBtn.setText("Cancel");
                deleteBtn.getStyleClass().remove("deleteBtn");
                deleteBtn.getStyleClass().add("cancelBtn");
            }
        } else {
            if (!addBtn.getStyleClass().get(3).equals("addBtn")){
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
     * set main screen controller
     * @param screenPage screen page
     */
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
