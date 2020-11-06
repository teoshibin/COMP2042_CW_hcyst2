package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    public TextField usernametextfield;
    @FXML
    private AnchorPane accountpane;
    @FXML
    private ListView<String> usernamelistview;
    @FXML
    private Button addbtn;
    @FXML
    private Button editbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button enterbtn;

    ObservableList<String> userList = FXCollections.observableArrayList("Guest");
    int holdIndex;
    String username;

    public void handleBtnAction(ActionEvent actionEvent) throws IOException {
        switch (((Button)actionEvent.getSource()).getText()){
            case "Add":
                username = usernametextfield.getText();
                if (!usernamelistview.getItems().contains(username) && username != ""){
                    usernamelistview.getItems().add(username);
                    usernametextfield.setText("");
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Delete":
                holdIndex = -1;
                holdIndex = usernamelistview.getSelectionModel().getSelectedIndex();
                if (holdIndex > 0){
                    usernamelistview.getItems().remove(holdIndex);
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Edit":
                holdIndex = -1;
                holdIndex = usernamelistview.getSelectionModel().getSelectedIndex();
                if(holdIndex > 0){
                    username = usernamelistview.getSelectionModel().getSelectedItem();
                    usernametextfield.setText(username);
                    editMode(true);
                    Sound.playPageFlipSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Done":
                username = usernametextfield.getText();
                if(!usernamelistview.getItems().contains(username)){
                    usernamelistview.getItems().set(holdIndex, username);
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                usernametextfield.setText("");
                editMode(false);
                break;
            case "Cancel":
                editMode(false);
                usernametextfield.setText("");
                Sound.playPageFlipSound();
                break;
            case "Login":
                Pane menupane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                accountpane.getChildren().setAll(menupane);
                break;
        }
    }

    /**
     * initialize account page gui
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 11/7/2020 load usernames from file
        usernamelistview.setItems(userList);
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playBtnSound();
    }

    private void editMode(boolean bool){
        if (bool){
            addbtn.setText("Done");
            addbtn.getStyleClass().add("donebtn");
            deletebtn.setText("Cancel");
            deletebtn.getStyleClass().remove("deletebtn");
            deletebtn.getStyleClass().add("cancelbtn");
        } else {
            addbtn.setText("Add");
            addbtn.getStyleClass().remove("donebtn");
            deletebtn.setText("Delete");
            deletebtn.getStyleClass().remove("cancelbtn");
            deletebtn.getStyleClass().add("deletebtn");
        }
    }
}
