package com.tsb.frogger.utils.data.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * test player data structure
 */
public class PlayerTest {
    /**
     * username
     */
    private String expected;
    /**
     * high score list
     */
    private ArrayList<Integer> expected1;
    /**
     * player object
     */
    private Player player;

    /**
     * set up dummy data
     */
    @Before
    public void init(){
        expected1 = new ArrayList<>();
        expected = "testing123456";
        expected1.add(-9999);
        expected1.add(0);
        expected1.add(9999);
    }

    /**
     * test getter
     */
    @Test
    public void getUsername() {
        player = new Player(expected);
        String output = player.getUsername();
        assertEquals(expected, output);
    }

    /**
     * test setter
     */
    @Test
    public void setUsername() {
        player = new Player();
        player.setUsername(expected);
        String output = player.getUsername();
        assertEquals(expected, output);
    }

    /**
     * test high score getter and setter
     */
    @Test
    public void HighScores() {
        player = new Player();
        player.setHighScores(expected1);
        ArrayList<Integer> output = player.getHighScores();
        assertEquals(expected1, output);
    }
}