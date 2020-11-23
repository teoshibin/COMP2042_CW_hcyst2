package com.tsb.frogger.data;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileGameTest {

    @Test
    public void createFile() throws IOException {
        FileGame.createFile();
        File file = new File("src/main/resources/com/tsb/frogger/save/saveGame.ser");
        if(file.createNewFile()){
            fail("file not created in FileGame.createFile method");
        }
    }
}