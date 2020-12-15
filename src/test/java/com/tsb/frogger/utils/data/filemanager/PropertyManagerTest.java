package com.tsb.frogger.utils.data.filemanager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

public class PropertyManagerTest {

    Properties p;
    String[] keys;
    String[] strings;

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

    @Test
    public void saveProperties() {
        try {
            PropertyManager.saveProperties(p, getClass().getResource("/com/tsb/frogger/testProp.properties").getFile());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

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