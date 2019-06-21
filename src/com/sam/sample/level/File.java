package com.sam.sample.level;

public class File {
    public java.io.File raw;

    public enum Action {OPEN, SAVE};

    public Action action;
    public Data data;

    public File(java.io.File file, Action action) {
        raw = file;
        this.action = action;
    }
}
