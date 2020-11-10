package com.tsb.frogger.controller;

import com.tsb.frogger.core.Sound;
import com.tsb.frogger.data.UsernameFile;
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
    public TextField nameTextField;
    @FXML
    private AnchorPane accountpane;
    @FXML
    private ListView<String> nameListView;
    @FXML
    private Button addbtn;
    @FXML
    private Button editbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button enterbtn;

//    private ArrayList<Player> users = GameFile.read();
    private int holdIndex;

    public void handleBtnAction(ActionEvent actionEvent) throws IOException {


        switch (((Button)actionEvent.getSource()).getText()){
            case "Add":
                if(UsernameFile.addUsername(nameTextField.getText())){
                    nameTextField.setText("");
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Delete":
                if(UsernameFile.deleteUsername(nameListView.getSelectionModel().getSelectedIndex())){
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Edit":
                holdIndex = nameListView.getSelectionModel().getSelectedIndex();
                if(holdIndex > 0){
                    nameTextField.setText(nameListView.getSelectionModel().getSelectedItem());
                    editMode(true);
                    Sound.playPageFlipSound();
                } else {
                    Sound.playErrorSound();
                }
                break;
            case "Done":
                if(UsernameFile.editUsername(holdIndex, nameTextField.getText())){
                    Sound.playSuccessSound();
                } else {
                    Sound.playErrorSound();
                }
                nameTextField.setText("");
                editMode(false);
                break;
            case "Cancel":
                editMode(false);
                nameTextField.setText("");
                Sound.playPageFlipSound();
                break;
            case "Enter":
                Pane menuPane = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
                accountpane.getChildren().setAll(menuPane);
                break;
        }
        //update listview
        nameListView.setItems(UsernameFile.readUsername());
    }

    /**
     * initialize account page gui
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {


//        //create file if not exist
//        GameFile.createFile();
//
//        //read data
//        String data = GameFile.readUsername();
//
//        if(data.length() > 2){
//            //remove "[","]" split into string array
//            String[] dataArray = data.substring(1, data.length()-1).split(", ");
//            //convert array into array list
//            ArrayList<String> dataList = new ArrayList<String>(Arrays.asList(dataArray));
//            //add preset username
//            dataList.add(0, "Guest");
//            //convert array list to observable list
//            userList = FXCollections.observableArrayList(dataList);
//        } else {
//            userList = FXCollections.observableArrayList("Guest");
//        }


        ObservableList<String> usernameItems = UsernameFile.readUsername();
        System.out.println(usernameItems.toString());
        //assign list to GUI
        nameListView.setItems(usernameItems);

        Sound.playMenuMusic();
    }

    /**
     * play button pop up sound effect
     * @param mouseEvent mouse event
     */
    public void enterBtn(MouseEvent mouseEvent) {
        Sound.playBtnSound();
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


}
