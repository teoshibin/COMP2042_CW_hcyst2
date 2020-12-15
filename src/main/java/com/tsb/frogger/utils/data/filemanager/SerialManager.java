package com.tsb.frogger.utils.data.filemanager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

class SerialManager {

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

}
