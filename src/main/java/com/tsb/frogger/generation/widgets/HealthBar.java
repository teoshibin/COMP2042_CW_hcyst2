package com.tsb.frogger.generation.widgets;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class HealthBar extends Region {

    /**
     * value
     */
    private int health;
    /**
     * maximum number of icons displayed
     */
    private final int maxIcon;
    /**
     * image path
     */
    private final String imagePath;
    /**
     * icons container
     */
    private final HBox innerLeft;
    /**
     * + sign label
     */
    private final Label symbolLbl;
    /**
     * overflow icon numbers
     */
    private final Label overflowHealthLbl;

    /**
     * health bar constructor
     *
     * @param imagePath heart icon image path
     * @param layoutX layout x
     * @param layoutY layout y
     * @param health number of health
     * @param maxIcon maximum number of icon displayed
     */
    public HealthBar(String imagePath, int layoutX, int layoutY, int health, int maxIcon){

        // variables and containers
        HBox outer = new HBox();
        innerLeft = new HBox();
        HBox innerRight = new HBox();
        symbolLbl = new Label();
        overflowHealthLbl = new Label();
        this.maxIcon = maxIcon;
        this.imagePath = imagePath;

        // fill icons and update labels
        setHealth(health);

        // styles
        symbolLbl.getStyleClass().add("main-font");
        symbolLbl.getStyleClass().add("font-weight-bold");
        overflowHealthLbl.getStyleClass().add("main-font");
        overflowHealthLbl.getStyleClass().add("font-weight-bold");

        innerLeft.setBackground(Background.EMPTY);
        innerLeft.setAlignment(Pos.CENTER_LEFT);
        innerLeft.setSpacing(5);

        innerRight.setBackground(Background.EMPTY);
        innerRight.setAlignment(Pos.CENTER_RIGHT);
        innerRight.setSpacing(2);

        outer.setBackground(Background.EMPTY);
        outer.setAlignment(Pos.CENTER);
        outer.setSpacing(5);

        // fill in containers
        innerRight.getChildren().add(symbolLbl);
        innerRight.getChildren().add(overflowHealthLbl);
        outer.getChildren().addAll(innerLeft, innerRight);
        this.getChildren().add(outer);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setBackground(Background.EMPTY);
    }

    /**
     * add style class to the label
     *
     * @param styleClass string style class
     */
    public void addStyleClass(String styleClass){
        symbolLbl.getStyleClass().add(styleClass);
        overflowHealthLbl.getStyleClass().add(styleClass);
    }

    /**
     * update icon more efficiently without clearing and reconstructing the bar again
     *
     * @param newHealth int health
     */
    public void updateHealth(int newHealth){
        int difHealth = newHealth - maxIcon;
        if (newHealth < maxIcon){
            addHeart(newHealth - health);
        }
        symbolLbl.setText(newHealth > maxIcon ? "+" : "");
        overflowHealthLbl.setText(difHealth > 0 ? String.valueOf(difHealth): "");
        health = newHealth;
    }

    /**
     * construct the entire bar of icons and update labels
     *
     * @param newHealth int health
     */
    private void setHealth(int newHealth){

        int difHealth = newHealth - maxIcon;

        innerLeft.getChildren().clear();
        for (int i = 0; i < Math.min(newHealth, maxIcon); i++){
            innerLeft.getChildren().add(new Hearth(imagePath));
        }
        symbolLbl.setText(newHealth > maxIcon ? "+" : "");
        overflowHealthLbl.setText(difHealth > 0 ? String.valueOf(difHealth): "");
        health = newHealth;
    }


    /**
     * add or remove icon depending on input number
     * add 3 meaning add 3 icons to it
     * add -2 meaning remove 2 icons from it
     *
     * @param numHeart int, can be negative or 0 or positive number
     */
    private void addHeart(int numHeart){
        if (numHeart > 0){
            for (int i = 0; i < numHeart; i++){
                innerLeft.getChildren().add(new Hearth(imagePath));
            }
        } else if (numHeart < 0){
            for (int i = 0; i > numHeart; i--){
                innerLeft.getChildren().remove(0);
            }
        }
    }
}
