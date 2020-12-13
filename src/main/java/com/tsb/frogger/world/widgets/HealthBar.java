package com.tsb.frogger.world.widgets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class HealthBar extends Region {

    private int health;
    private final int maxHearth;
    private final String name;
    private Label label1;
    private Label label2;
    private HBox outer;
    private HBox innerLeft;
    private HBox innerRight;
    private ObservableList<Hearth> hearths;

    public HealthBar(String imagePath, int layoutX, int layoutY, int health, int maxHearth){

        int imageNum;
        hearths = FXCollections.observableArrayList();

        outer = new HBox();
        innerLeft = new HBox();
        innerRight = new HBox();
        label1 = new Label();
        label2 = new Label();

        this.maxHearth = maxHearth;
        this.name = imagePath;



        if (health > maxHearth){
            label1.setText("+");
            label2.setText(String.valueOf(health - maxHearth));
            imageNum = maxHearth;
        } else {
            label1.setText("");
            label2.setText("");
            imageNum = health;
        }

        for (int i = 0; i < imageNum; i++){
            Hearth hearth = new Hearth(imagePath);
            hearths.add(hearth);
        }

        innerLeft.getChildren().addAll(hearths);
        innerLeft.setBackground(Background.EMPTY);
        innerLeft.setSpacing(5);
        innerLeft.setAlignment(Pos.CENTER_LEFT);

        innerRight.getChildren().add(label1);
        innerRight.getChildren().add(label2);
        innerRight.setBackground(Background.EMPTY);
        innerRight.setSpacing(2);
        innerRight.setAlignment(Pos.CENTER_RIGHT);

        outer.getChildren().addAll(innerLeft, innerRight);
        outer.setBackground(Background.EMPTY);
        outer.setSpacing(2);

        this.getChildren().add(outer);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setBackground(Background.EMPTY);
    }

    public void addStyleClass(String name){
        label1.getStyleClass().add(name);
        label2.getStyleClass().add(name);
    }

    public void setHealth(int newHealth){
        if (newHealth != health){
            if (newHealth > maxHearth) {
                label1.setText("+");
                label2.setText(String.valueOf(newHealth - maxHearth));
            } else if(newHealth == maxHearth){
                label1.setText("");
                label2.setText("");
            } else {
                label1.setText("");
                label2.setText("");
                updateHearth(health - newHealth);
            }
            health = newHealth;
        }
    }

    private void updateHearth(int difHealth){
        if (difHealth > 0){
            for (int i = 0; i < difHealth; i++){
                innerLeft.getChildren().remove(0);
                hearths.remove(0);
            }
        } else if(difHealth < 0) {
            for (int i = difHealth; i < 0; i++){
                Hearth hearth = new Hearth(name);
                hearths.add(hearth);
            }
        }
    }

}
