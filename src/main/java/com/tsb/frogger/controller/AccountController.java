package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.ConstantData;
import com.tsb.frogger.data.FileUsername;
import com.tsb.frogger.data.RuntimeData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * account controller for GUI
 */
public class AccountController implements Initializable {

    /**
     * name text field
     */
    @FXML
    public TextField nameTextField;
    /**
     * parent anchor pane
     */
    @FXML
    private AnchorPane accountPane;
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

        ObservableList<String> usernameItems = FileUsername.readUsernames();
        //assign list to GUI
        nameListView.setItems(usernameItems);

        Sound.playMediaPlayer(ConstantData.menuMusic);
    }

    /**
     * handle button event
     * @param actionEvent event
     * @throws IOException exception
     */
    public void handleBtnAction(ActionEvent actionEvent) throws IOException {


        switch (((Button)actionEvent.getSource()).getText()){
            case "Add":
                if(FileUsername.addUsername(nameTextField.getText())){
                    nameTextField.setText("");
                    Sound.playAudioClip(ConstantData.successSound);
                } else {
                    Sound.playAudioClip(ConstantData.errorSound);
                }
                break;
            case "Delete":
                if(FileUsername.deleteUsername(nameListView.getSelectionModel().getSelectedIndex())){
                    Sound.playAudioClip(ConstantData.successSound);
                } else {
                    Sound.playAudioClip(ConstantData.errorSound);
                }
                break;
            case "Edit":
                holdIndex = nameListView.getSelectionModel().getSelectedIndex();
                if(holdIndex > 0){
                    nameTextField.setText(nameListView.getSelectionModel().getSelectedItem());
                    editMode(true);
                    Sound.playAudioClip(ConstantData.pageFlipSound);
                } else {
                    Sound.playAudioClip(ConstantData.errorSound);
                }
                break;
            case "Done":
                if(FileUsername.editUsername(holdIndex, nameTextField.getText())){
                    Sound.playAudioClip(ConstantData.successSound);
                } else {
                    Sound.playAudioClip(ConstantData.errorSound);
                }
                nameTextField.setText("");
                editMode(false);
                break;
            case "Cancel":
                editMode(false);
                nameTextField.setText("");
                Sound.playAudioClip(ConstantData.pageFlipSound);
                break;
            case "Enter":
                RuntimeData.selectedUsernameIndex = nameListView.getSelectionModel().getSelectedIndex();
                RuntimeData.Username = FileUsername.readUsernames().get(RuntimeData.selectedUsernameIndex);
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                accountPane.getChildren().setAll(menuPane);
                break;
        }
        //update listview
        nameListView.setItems(FileUsername.readUsernames());
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playAudioClip(ConstantData.buttonSound);
    }

    /**
     * change gui when enter username edit mode
     * @param bool edit mode state
     */
    private void editMode(boolean bool){
        if (bool){
            addBtn.setText("Done");
            addBtn.getStyleClass().add("doneBtn");
            deleteBtn.setText("Cancel");
            deleteBtn.getStyleClass().remove("deleteBtn");
            deleteBtn.getStyleClass().add("cancelBtn");
        } else {
            addBtn.setText("Add");
            addBtn.getStyleClass().remove("doneBtn");
            deleteBtn.setText("Delete");
            deleteBtn.getStyleClass().remove("cancelBtn");
            deleteBtn.getStyleClass().add("deleteBtn");
        }
    }


}
