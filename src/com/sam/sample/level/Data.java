package com.sam.sample.level;

import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    String text;

    public Data() {

    }

    public Data(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
