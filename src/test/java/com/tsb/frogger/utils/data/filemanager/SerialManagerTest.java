package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.TestStructure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.fail;

public class SerialManagerTest {

    TestStructure saveData;
    Properties p;
    String[] keys;
    String[] strings;

    @Before
    public void setUp() throws Exception {
        saveData = new TestStructure(9999,"something");

    }

    @Test
    public void saveSerialized() {
        try {
            SerialManager.saveSerialized(saveData, "testSave.ser");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void loadSerialized() {
        try {
            SerialManager.saveSerialized(saveData, "testSave.ser");
            SerialManager.loadSerialized("testSave.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail();
        }
    }

    @After
    public void tearDown(){
        File file = new File("testSave.ser");
        file.delete();
    }
}