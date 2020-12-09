package com.tsb.frogger.utils.files.datamanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Convertor {

    public <T> ObservableList<T> convertArrayListToObservableList(ArrayList<T> arrayList){
        ObservableList<T> observableList = FXCollections.observableArrayList();
        if (arrayList.size() > 0){
            observableList.addAll(arrayList);
        }
        return observableList;
    }

}
