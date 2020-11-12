package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.FileUsername;
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
    private AnchorPane accountpane;
    /**
     * name list view
     */
    @FXML
    private ListView<String> nameListView;
    /**
     * button
     */
    @FXML
    private Button addbtn;
    /**
     * button
     */
    @FXML
    private Button editbtn;
    /**
     * button
     */
    @FXML
    private Button deletebtn;
    /**
     * button
     */
    @FXML
    private Button enterbtn;

    /**
     * hold player index while editing
     */
    private int holdIndex;
    /**
     * selected username player index
     */
    private static int selectedNameIndex = 0;

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
                    Sound.SuccessSound();
                } else {
                    Sound.ErrorSound();
                }
                break;
            case "Delete":
                if(FileUsername.deleteUsername(nameListView.getSelectionModel().getSelectedIndex())){
                    Sound.SuccessSound();
                } else {
                    Sound.ErrorSound();
                }
                break;
            case "Edit":
                holdIndex = nameListView.getSelectionModel().getSelectedIndex();
                if(holdIndex > 0){
                    nameTextField.setText(nameListView.getSelectionModel().getSelectedItem());
                    editMode(true);
                    Sound.PageFlipSound();
                } else {
                    Sound.ErrorSound();
                }
                break;
            case "Done":
                if(FileUsername.editUsername(holdIndex, nameTextField.getText())){
                    Sound.SuccessSound();
                } else {
                    Sound.ErrorSound();
                }
                nameTextField.setText("");
                editMode(false);
                break;
            case "Cancel":
                editMode(false);
                nameTextField.setText("");
                Sound.PageFlipSound();
                break;
            case "Enter":
                selectedNameIndex = nameListView.getSelectionModel().getSelectedIndex();
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                accountpane.getChildren().setAll(menuPane);
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
        Sound.BtnSound();
    }

    /**
     * change gui when enter username edit mode
     * @param bool edit mode state
     */
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

    /**
     * get selected player username
     * @return player index
     */
    public static int getSelectedNameIndex() {
        return selectedNameIndex;
    }

    /**
     * initialize account page gui
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> usernameItems = FileUsername.readUsernames();
        System.out.println(usernameItems.toString());
        //assign list to GUI
        nameListView.setItems(usernameItems);

        Sound.playMenuMusic();
    }
}
