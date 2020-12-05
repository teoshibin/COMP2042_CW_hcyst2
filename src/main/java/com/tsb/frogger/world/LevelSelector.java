package com.tsb.frogger.world;

import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.world.levels.*;

import java.util.Objects;

/**
 * link and load different classes of levels
 */
public class LevelSelector {

    /**
     * current max level
     * increment this when new level is added
     */
    public static final int MAX_LEVEL = 5;

    /**
     * get actors based on selected levels
     * link newly added levels in here
     * kindly note that whenever a level is removed, save file wont be able to load
     *
     * @param level level value
     */
    public static void selectLevel(int level) throws LevelNotFoundException {
        LevelBase myLevel;
        switch (level) {
            case 1 -> myLevel = new Level_001();
            case 2 -> myLevel = new Level_002();
            case 3 -> myLevel = new Level_003();
            case 4 -> myLevel = new Level_004();
            case 5 -> myLevel = new Level_005();
            default -> throw new LevelNotFoundException("Level not found or Unlinked level, please check linking in LevelSelector");
        }
        Objects.requireNonNull(myLevel).loadLevel();
    }
}
