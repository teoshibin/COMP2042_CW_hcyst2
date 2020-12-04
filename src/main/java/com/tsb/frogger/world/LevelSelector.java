package com.tsb.frogger.world;

import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.world.levels.LevelBase;
import com.tsb.frogger.world.levels.LevelOne;
import com.tsb.frogger.world.levels.LevelTwo;

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
     * kindly note that whenever a level is removed, save file wont be able to load
     *
     * @param level level value
     */
    public static void selectLevel(MyStage gamePane, int level) throws LevelNotFoundException {
        LevelBase myLevel;
        switch (level) {
            case 1 -> myLevel = new LevelOne();
            case 2 -> myLevel = new LevelTwo();
            default -> throw new LevelNotFoundException("Level not found or Unlinked level, please check linking in LevelSelector");
        }
        Objects.requireNonNull(myLevel).loadLevel(gamePane);
    }
}
