package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.TestStructure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * test file access serial manager class
 */
public class SerialManagerTest {
    /**
     * serializable testing data structure
     */
    TestStructure saveData;

    /**
     * set up dummy data
     */
    @Before
    public void setUp() {
        saveData = new TestStructure(9999,"something");

    }

    /**
     * save dummy data to file
     */
    @Test
    public void saveSerialized() {
        try {
            SerialManager.saveSerialized(saveData, "testSave.ser");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * laod dummy data from file
     */
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

    /**
     * tear down remove created save file
     */
    @After
    public void tearDown(){
        File file = new File("testSave.ser");
        file.delete();
    }
}