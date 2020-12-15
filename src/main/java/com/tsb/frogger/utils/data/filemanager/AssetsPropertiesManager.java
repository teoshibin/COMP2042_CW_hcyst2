package com.tsb.frogger.utils.data.filemanager;

import java.io.IOException;
import java.util.Properties;

public class AssetsPropertiesManager {

    public static Properties loadProperties(String name) throws IOException {
        return PropertyManager.loadProperties(name);
    }
}
