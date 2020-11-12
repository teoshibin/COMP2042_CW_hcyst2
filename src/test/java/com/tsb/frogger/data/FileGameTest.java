package com.tsb.frogger.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileGameTest {

    private static final String DATA_PATH = "src/main/resources/com/tsb/frogger/save/saveGame.ser";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createFile() throws IOException {
        FileGame.createFile();
        File file = new File(DATA_PATH);
        file.createNewFile();
    }

    @Test
    public void write() {
    }

    @Test
    public void read() {
    }
}