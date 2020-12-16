package com.tsb.frogger.generation.widgets;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.transform.Rotate;

/**
 * time bar component
 */
public class TimeBar extends Region {
    /**
     * progress bar
     */
    private final ProgressBar progressBar;

    /**
     * constructor
     *
     * @param imagePath icon image path
     * @param layoutX layout x
     * @param layoutY layout y
     * @param imageSize icon image size
     * @param barWidth bar width
     * @param barHeight bar height
     * @param flip bar flip direction
     */
    public TimeBar(String imagePath, int layoutX, int layoutY, int imageSize,
                   int barWidth, int barHeight, boolean flip){

        HBox outer = new HBox();

        // UI
        progressBar = new ProgressBar(1);
        progressBar.setPrefSize(barWidth, barHeight);
        progressBar.getStyleClass().add("orange-bar");

        if (flip){
            Rotate rotate = new Rotate();
            rotate.setPivotX(progressBar.getPrefWidth()/2);
            rotate.setPivotY(progressBar.getPrefHeight()/2);
            rotate.setAngle(180);
            progressBar.getTransforms().add(rotate);
        }

        ImageView alarmClock = new ImageView(
                new Image(imagePath,imageSize, imageSize, true, true)
        );

        // layout
        outer.setSpacing(5);
        outer.setAlignment(Pos.CENTER);
        outer.setBackground(Background.EMPTY);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setBackground(Background.EMPTY);

        // warp
        outer.getChildren().addAll(progressBar, alarmClock);
        this.getChildren().addAll(outer);
    }

    /**
     * get progress bar
     *
     * @return progress bar
     */
    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
