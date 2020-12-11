package com.tsb.frogger.core;

public class ConstantData {

    // stage title
    public static final String STAGE_TITLE = "Frogger";

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
    public static final String ASSETS_FILE_PATH = "/com/tsb/frogger/assets.properties";

    // game scale and layout pos
    public static final double SCALE = 1;

    // background image size
    public static int[] SIZE_BACKGROUND = {540, 720};

    // actor image size config
    public static int SIZE_END = 54;
    public static int SIZE_FROG_END = 63;
    public static int SIZE_SHORT_LOG = 135;
    public static int SIZE_MEDIUM_LOG = 200;
    public static int SIZE_LONG_LOG = 270;
    public static int SIZE_TURTLE = 117;
    public static int SIZE_SHORT_TRUCK = 108;
    public static int SIZE_LONG_TRUCK = 180;
    public static int SIZE_CAR = 45;

    // actor moving bound
    public static final int[] ACTOR_MOVING_BOUND = {-270,810};

    // row = map number, col = sections in map, index 0 is end, last element is starting point
    public static final int[][] LAYOUT_Y_ACTOR = {
//            {96, 166, 217, 276, 329, 376, 433, 490, 540, 597, 649, 706, 756}, // old layout y
            {88, 155, 195, 248, 291, 338, 390, 441, 486, 537, 584, 630, 655},
    };

    public static final int[][] LAYOUT_X_END = {
            {12, 127, 242, 358, 472}
    };

    public static final int[] LAYOUT_X_FROG = {
            252,
    };

}
