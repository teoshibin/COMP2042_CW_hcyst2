package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;

public class TestStructure implements Serializable {
    private Integer number;
    private String string;

    public TestStructure(Integer number, String string){
        this.number = number;
        this.string = string;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
