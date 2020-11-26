package com.tsb.frogger.controller;

/**
 *  screen controlling interface
 */
public interface ControlledScreen {
    /**
     * abstract method for main screen controller injection
     * @param screenPage screen page
     */
    void setScreenParent(ScreensController screenPage);
}
