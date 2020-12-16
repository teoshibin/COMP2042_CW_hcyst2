package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.utils.data.datastructure.TestStructure;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.fail;

/**
 * convertor class testing
 */
public class ConvertorTest {
    /**
     * input 1
     */
    ArrayList<Integer> input1;
    /**
     * input 2
     */
    ArrayList<String> input2;
    /**
     * processed input 1 and input 2
     */
    ArrayList<TestStructure> expected;
    /**
     * convertor instance
     */
    Convertor convertor;

    /**
     * set up dummy value
     */
    @Before
    public void setUp() {
        input1 = new ArrayList<>();
        input2 = new ArrayList<>();
        expected = new ArrayList<>();
        convertor = new Convertor();

        for (int i = 0; i < 3; i++){
            input1.add(i);
            input2.add(String.valueOf(i));
            expected.add(new TestStructure(input1.get(i), input2.get(i)));
        }

    }

    /**
     * test zip two method
     */
    @Test
    public void zipTwo() {
        ArrayList<TestStructure> result = convertor.zipTwo(TestStructure.class, Integer.class, String.class, input1, input2);
        for (int i = 0; i < result.size(); i++){
            TestStructure temp1 = result.get(i);
            TestStructure temp2 = expected.get(i);
            if (!temp1.getNumber().equals(temp2.getNumber()) || !temp1.getString().equals(temp2.getString())){
                fail();
            }
        }
    }

    /**
     * test convert method
     */
    @Test
    public void convertArrayListToObservableList() {
        ObservableList<Integer> result1 = convertor.convertArrayListToObservableList(input1);
        ObservableList<String> result2 = convertor.convertArrayListToObservableList(input2);
        for (int i = 0; i < 3; i++){
            if (!result1.get(i).equals(input1.get(i)) || !result2.get(i).equals(input2.get(i))){
                fail();
            }
        }
    }
}