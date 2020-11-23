package com.tsb.frogger.data;

import com.tsb.frogger.core.Game;
import javafx.scene.layout.Pane;

public class RuntimeData {
    /**
     * selected username once enter the account page
     */
    public static int selectedUsernameIndex = 0;
    /**
     * username
     */
    public static String Username = "Guest";
    /**
     * game object
     */
    public static Game game;
    /**
     * root node
     */
    public static Pane pane;
}
