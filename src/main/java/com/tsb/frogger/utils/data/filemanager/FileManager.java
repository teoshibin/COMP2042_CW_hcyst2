package com.tsb.frogger.utils.data.filemanager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

class FileManager {

    static void saveSerialized(Serializable data, String filename) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            oss.writeObject(data);
        }
    }

    static Object loadSerialized(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return ois.readObject();
        }
    }

    static void saveProperties(Properties p, String pathname) throws IOException {
        OutputStream os = new FileOutputStream(pathname);
        p.store(os, null);
    }

    static Properties loadProperties(String name) throws IOException {
        Properties p = new Properties();
        InputStream is = FileManager.class.getResourceAsStream(name);
        p.load(is);
        return p;
    }
}
