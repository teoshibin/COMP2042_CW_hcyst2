package com.tsb.frogger.generation.widgets;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * value indicator widget
 */
public class ValueIndicator extends Region {

    /**
     * value label
     */
    private final Label valueLbl;

    /**
     * constructor
     *
     * @param layoutX layout x
     * @param layoutY layout y
     * @param text value label
     * @param value value
     * @param digits number of digits displayed for value
     */
    public ValueIndicator(int layoutX, int layoutY, String text , int value, int digits){

        // init
        VBox outer = new VBox();
        Label textLbl = new Label(text);
        valueLbl = new Label(calString(value));

        // preset style
        textLbl.setBackground(Background.EMPTY);
        textLbl.setAlignment(Pos.CENTER);
        textLbl.getStyleClass().add("main-font");
        textLbl.getStyleClass().add("font-weight-bold");
        valueLbl.setBackground(Background.EMPTY);
        valueLbl.setAlignment(Pos.CENTER);
        valueLbl.getStyleClass().add("inGame-font");
        valueLbl.getStyleClass().add("bigger-font-size");
        outer.setBackground(Background.EMPTY);
        outer.setAlignment(Pos.CENTER);
        outer.setSpacing(-6);
        this.setBackground(Background.EMPTY);

        // wrap in container
        outer.getChildren().addAll(textLbl, valueLbl);
        this.getChildren().add(outer);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
    }

    /**
     * convert int to strings with specified digits
     *
     * @param value value
     * @return string
     */
    private String calString(int value){
        return "0".repeat(3 - String.valueOf(value).length()) + value;
    }

    /**
     * update value
     *
     * @param value value
     */
    public void updateValue(int value){
        valueLbl.setText(calString(value));
    }
}
