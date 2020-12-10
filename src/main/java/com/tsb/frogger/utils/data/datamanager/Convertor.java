package com.tsb.frogger.utils.data.datamanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * convertor class that consist of all data conversion methods
 *
 */
public class Convertor {

    /**
     * zip arraylist B and arraylist C into one arraylist A and convert it into observable list
     * this will zip any two objects into one
     *
     * @param clsA class A a defined object class that contains B and C
     * @param clsB class B
     * @param clsC class C
     * @param arrayListOne array list one
     * @param arrayListTwo array list two
     * @param <A> type parameter A output object type
     * @param <B> type parameter B input one object type
     * @param <C> type parameter C input two object type
     * @return observable list of A
     */
    public <A, B, C> ObservableList<A> convertToObservableListZipTwo(Class<A> clsA, Class<B> clsB, Class<C> clsC, ArrayList<B> arrayListOne, ArrayList<C> arrayListTwo) {
        return convertArrayListToObservableList(zipTwo(clsA, clsB, clsC, arrayListOne, arrayListTwo));
    }

    /**
     * zip arraylist B and arraylist C into one arraylist A
     * this will zip any two objects into one
     *
     * @param clsA class A a defined object class that contains B and C
     * @param clsB class B
     * @param clsC class C
     * @param arrayListOne array list one
     * @param arrayListTwo array list two
     * @param <A> type parameter A output object type
     * @param <B> type parameter B input one object type
     * @param <C> type parameter C input two object type
     * @return array list of A
     */
    public <A, B, C> ArrayList<A> zipTwo(Class<A> clsA, Class<B> clsB, Class<C> clsC, ArrayList<B> arrayListOne, ArrayList<C> arrayListTwo) {
        ArrayList<A> zipArrayList = new ArrayList<>();
        try {
            int len = Math.min(arrayListOne.size(), arrayListTwo.size());
            for (int i = 0; i < len; i++) {
                zipArrayList.add(clsA.getDeclaredConstructor(clsB, clsC).newInstance(arrayListOne.get(i), arrayListTwo.get(i)));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return zipArrayList;
    }

    /**
     * convert arraylist into observable list
     *
     * @param arrayList input arraylist
     * @param <T> arraylist type
     * @return observable list of T
     */
    public <T> ObservableList<T> convertArrayListToObservableList(ArrayList<T> arrayList) {
        ObservableList<T> observableList = FXCollections.observableArrayList();
        if (arrayList.size() > 0) {
            observableList.addAll(arrayList);
        }
        return observableList;
    }
}
