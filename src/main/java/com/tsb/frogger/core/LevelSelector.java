package com.tsb.frogger.core;

import com.tsb.frogger.exceptions.LevelNotFoundException;
import com.tsb.frogger.levels.LevelBase;
import com.tsb.frogger.levels.LevelOne;
import com.tsb.frogger.levels.LevelTwo;
import com.tsb.frogger.world.MyStage;

import java.util.Objects;

/**
 * link and load different classes of levels
 */
public class LevelSelector {

    /**
     * current max level
     * increment this when new level is added
     */
    public static final int MAX_LEVEL = 2;

    /**
     * get actors based on selected levels
     * link newly added levels in here
     *
     * @param level level value
     */
    public static void selectLevel(MyStage gamePane, int level) throws LevelNotFoundException {
        LevelBase myLevel;
        switch (level){
            case 1:
                myLevel = new LevelOne();
                break;
            case 2:
                myLevel = new LevelTwo();
                break;
            default:
                throw new LevelNotFoundException("Level not found or Unlinked level, please check linking in LevelSelector");
        }
        Objects.requireNonNull(myLevel).loadLevel(gamePane);
    }
}
