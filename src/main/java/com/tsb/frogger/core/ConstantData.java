package com.tsb.frogger.core;

public class ConstantData {

    // screen page id
    public static final String SCREEN_ID_ACCOUNT = "accountScreen";
    public static final String SCREEN_ID_MENU = "menuScreen";
    public static final String SCREEN_ID_GAME = "gameScreen";
    public static final String SCREEN_ID_INFO = "infoScreen";
    public static final String SCREEN_ID_SCOREBOARD = "scoreboardScreen";
    public static final String SCREEN_ID_SELECT_LEVEL = "selectLevelScreen";
    public static final String OVERLAY_ID_OPTION = "optionOverlay";
    public static final String OVERLAY_ID_VICTORY = "victoryOverlay";

    // Save File Path
    public static final String SAVE_FILE_PATH = "saveGame.ser";
    public static final String ASSET_PROPERTY_PATH = "/com/tsb/frogger/assets.properties";

    // background image size
    public static int[] SIZE_BACKGROUND = {540, 720};

    // actor image size config
    public static final int SIZE_END = 54;
    public static final int SIZE_FROG_END = 63;
    public static final int SIZE_SHORT_LOG = 135;
    public static final int SIZE_MEDIUM_LOG = 200;
    public static final int SIZE_LONG_LOG = 270;
    public static final int SIZE_TURTLE = 117;
    public static final int SIZE_SHORT_TRUCK = 108;
    public static final int SIZE_LONG_TRUCK = 180;
    public static final int SIZE_CAR = 45;
    public static final int SIZE_FROG = 36;

    // actor moving bound
    public static final int[] ACTOR_MOVING_BOUND = {-270,810};

    /**
     * preset y locations for actors
     * row = map number, col = x locations in a single map, index 0 is end
     * The last element is starting point
     */
    public static final int[][] LAYOUT_Y_ACTOR = {
            {88, 155, 195, 248, 291, 338, 390, 441, 486, 537, 584, 630, 655},
    };

    /**
     * end preset x location
     */
    public static final int[][] LAYOUT_X_END = {
            {12, 127, 242, 358, 472}
    };

    /**
     * frog's initial x location
     */
    public static final int[] LAYOUT_X_FROG = {
            252,
    };

}
