package com.tsb.frogger.utils.data.filemanager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * load properties files into property objects
 */
class PropertyManager {
    /**
     * save properties object into property files
     *
     * @param p p
     * @param pathname path name
     * @throws IOException fail to save file
     */
    static void saveProperties(Properties p, String pathname) throws IOException {
        OutputStream os = new FileOutputStream(pathname);
        p.store(os, null);
    }

    /**
     * load properties into properties object
     *
     * @param name name
     * @return properties object
     * @throws IOException fail to load file
     */
    static Properties loadProperties(String name) throws IOException {
        Properties p = new Properties();
        InputStream is = SerialManager.class.getResourceAsStream(name);
        p.load(is);
        return p;
    }
}
