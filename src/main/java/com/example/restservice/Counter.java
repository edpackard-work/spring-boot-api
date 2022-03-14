package com.example.restservice;

public class Counter {

    private long count;

    public Counter() {
        this.count = 0;
    }

    public void incrementCount() {
        count += 1;
    }

    public long getCount() {
        return this.count;
    }
}
