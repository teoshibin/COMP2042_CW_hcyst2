package com.tsb.frogger.generation.levels;

import com.tsb.frogger.utils.game.ActorLoader;

/**
 * level base interface for factory
 */
public interface LevelBase {
    /**
     * load corresponding actors by calling this method
     * @param actorLoader actor loader
     * @return actor loader
     */
    ActorLoader loadLevel(ActorLoader actorLoader);

}
