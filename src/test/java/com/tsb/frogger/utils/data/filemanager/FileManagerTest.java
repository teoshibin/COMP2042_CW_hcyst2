package com.tsb.frogger.utils.data.filemanager;

import com.tsb.frogger.utils.data.datastructure.TestStructure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FileManagerTest {

    TestStructure saveData;
    Properties p;
    String[] keys;
    String[] strings;

    @Before
    public void setUp() throws Exception {
        saveData = new TestStructure(9999,"something");
        keys = new String[3];
        strings = new String[3];
        p = new Properties();

        keys[0] = "ball";
        keys[1] = "cookie";
        keys[2] = "frogger";

        strings[0] = "fun";
        strings[1] = "delicious";
        strings[2] = "depressing";

        for (int i = 0; i < keys.length; i++){
            p.setProperty(keys[i],strings[i]);
        }
    }

    @Test
    public void saveSerialized() {
        try {
            FileManager.saveSerialized(saveData, "testSave.ser");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void loadSerialized() {
        try {
            FileManager.saveSerialized(saveData, "testSave.ser");
            FileManager.loadSerialized("testSave.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void saveProperties() {
        try {
            FileManager.saveProperties(p, getClass().getResource("/com/tsb/frogger/testProp.properties").getFile());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void loadProperties() {
        Properties result = null;
        try {
            FileManager.saveProperties(p, getClass().getResource("/com/tsb/frogger/testProp.properties").getFile());
            result = FileManager.loadProperties("/com/tsb/frogger/testProp.properties");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        for (int i = 0; i < p.size(); i++){
            assertEquals(p.getProperty(keys[i]), result.getProperty(keys[i]));;
        }
    }

    @After
    public void tearDown(){
        File file = new File("testSave.ser");
        file.delete();
    }
}