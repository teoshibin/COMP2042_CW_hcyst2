package com.tsb.frogger.utils.data.filemanager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

class PropertyManager {

    static void saveProperties(Properties p, String pathname) throws IOException {
        OutputStream os = new FileOutputStream(pathname);
        p.store(os, null);
    }

    static Properties loadProperties(String name) throws IOException {
        Properties p = new Properties();
        InputStream is = SerialManager.class.getResourceAsStream(name);
        p.load(is);
        return p;
    }
}
