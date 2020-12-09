package com.tsb.frogger.utils.files.filemanager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileManager {

    static void save(Serializable data, String filename) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            oss.writeObject(data);
        }
    }

    static Object load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return ois.readObject();
        }
    }
}
