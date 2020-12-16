package com.tsb.frogger.utils.data.filemanager;

import java.io.IOException;
import java.util.Properties;

/**
 * load assets path name from properties
 */
public class AssetsPropertiesManager {
    /**
     * load assets path name properties object
     *
     * @param name path name
     * @return properties object
     * @throws IOException fail to load file
     */
    public static Properties loadProperties(String name) throws IOException {
        return PropertyManager.loadProperties(name);
    }
}
