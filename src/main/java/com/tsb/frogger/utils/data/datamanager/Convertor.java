package com.tsb.frogger.utils.data.datamanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Convertor {

    public <A, B, C> ObservableList<A> convertToObservableListZipTwo(
            Class<A> clsA,
            Class<B> clsB,
            Class<C> clsC,
            ArrayList<B> arrayListOne,
            ArrayList<C> arrayListTwo
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return convertArrayListToObservableList(zipTwo(clsA,clsB,clsC,arrayListOne,arrayListTwo));
    }

    public <A, B, C> ArrayList<A> zipTwo(
            Class<A> clsA,
            Class<B> clsB,
            Class<C> clsC,
            ArrayList<B> arrayListOne,
            ArrayList<C> arrayListTwo
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<A> zipArrayList = new ArrayList<>();
        int len = Math.min(arrayListOne.size(), arrayListTwo.size());
        for (int i = 0; i < len; i++){
            zipArrayList.add(clsA.getDeclaredConstructor(clsB, clsC).newInstance(arrayListOne.get(i), arrayListTwo.get(i)));
        }
        return zipArrayList;
    }

    public <T> ObservableList<T> convertArrayListToObservableList(ArrayList<T> arrayList){
        ObservableList<T> observableList = FXCollections.observableArrayList();
        if (arrayList.size() > 0){
            observableList.addAll(arrayList);
        }
        return observableList;
    }

}
