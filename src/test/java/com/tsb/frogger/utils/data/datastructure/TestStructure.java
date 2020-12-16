package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;

/**
 * data structure for testing purposes
 */
public class TestStructure implements Serializable {
    /**
     * number
     */
    private Integer number;
    /**
     * string
     */
    private String string;

    /**
     * constructor
     *
     * @param number name
     * @param string string
     */
    public TestStructure(Integer number, String string){
        this.number = number;
        this.string = string;
    }

    /**
     * getter
     *
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * setter
     *
     * @param number number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * getter
     *
     * @return string
     */
    public String getString() {
        return string;
    }

    /**
     * setter
     *
     * @param string string
     */
    public void setString(String string) {
        this.string = string;
    }
}
