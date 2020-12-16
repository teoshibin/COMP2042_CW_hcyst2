package com.tsb.frogger.utils.data.filemanager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * serialize and deserialize object
 */
class SerialManager {
    /**
     * save serialized object to file
     *
     * @param data data object
     * @param filename file name
     * @throws IOException failt to save file
     */
    static void saveSerialized(Serializable data, String filename) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            oss.writeObject(data);
        }
    }

    /**
     * load and deserialize serialized object
     *
     * @param filename file name
     * @return deserialized object
     * @throws IOException fail to load file
     * @throws ClassNotFoundException fail to deserialize
     */
    static Object loadSerialized(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return ois.readObject();
        }
    }

}
