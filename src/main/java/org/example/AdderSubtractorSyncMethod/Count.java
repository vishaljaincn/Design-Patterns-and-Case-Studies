package org.example.AdderSubtractorSyncMethod;

public class Count {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public synchronized void incValue(int x) {
        value += x;
    }
}