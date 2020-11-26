package com.tsb.frogger.files;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    private final String expected = "testing123456";
    private ArrayList<Integer> expected1 = new ArrayList<>();
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
    public void getSetHighest_scores() {
        player = new Player();
        player.setHighest_scores(expected1);
        ArrayList<Integer> output = player.getHighest_scores();
        assertEquals(expected1, output);
    }
}