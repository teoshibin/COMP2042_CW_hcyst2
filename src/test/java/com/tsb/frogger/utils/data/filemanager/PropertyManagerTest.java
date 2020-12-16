package com.tsb.frogger.utils.data.filemanager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * property file accessing test
 */
public class PropertyManagerTest {
    /**
     * properties
     */
    Properties p;
    /**
     * testing keys
     */
    String[] keys;
    /**
     * testing values
     */
    String[] strings;

    /**
     * set up dummy properties
     */
    @Before
    public void setUp() {

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

    /**
     * save properties into file
     */
    @Test
    public void saveProperties() {
        try {
            PropertyManager.saveProperties(p, getClass().getResource("/com/tsb/frogger/testProp.properties").getFile());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * load properties from file
     */
    @Test
    public void loadProperties() {
        Properties result = null;
        try {
            PropertyManager.saveProperties(p, getClass().getResource("/com/tsb/frogger/testProp.properties").getFile());
            result = PropertyManager.loadProperties("/com/tsb/frogger/testProp.properties");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        for (int i = 0; i < p.size(); i++){
            assertEquals(p.getProperty(keys[i]), result.getProperty(keys[i]));
        }
    }

}