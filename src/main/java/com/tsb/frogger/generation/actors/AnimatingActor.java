package com.tsb.frogger.generation.actors;

/**
 * animating actor
 * any actor that animates or involve timer counting will having to implement this interface
 */
public interface AnimatingActor {
    /**
     * pause
     */
    void pause();

    /**
     * resume
     */
    void resume();

    /**
     * stop
     */
    void stop();
}
