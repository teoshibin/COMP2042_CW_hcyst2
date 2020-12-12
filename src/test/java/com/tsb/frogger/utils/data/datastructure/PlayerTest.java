package com.tsb.frogger.utils.data.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    private final String expected = "testing123456";
    private final ArrayList<Integer> expected1 = new ArrayList<>();
    private Player player;

    @Before
    public void init(){
        expected1.add(-9999);
        expected1.add(0);
        expected1.add(9999);
    }

    @Test
    public void getUsername() {
        player = new Player(expected);
        String output = player.getUsername();
        assertEquals(expected, output);
    }

    @Test
    public void setUsername() {
        player = new Player();
        player.setUsername(expected);
        String output = player.getUsername();
        assertEquals(expected, output);
    }

    @Test
    public void HighScores() {
        player = new Player();
        player.setHighScores(expected1);
        ArrayList<Integer> output = player.getHighScores();
        assertEquals(expected1, output);
    }
}