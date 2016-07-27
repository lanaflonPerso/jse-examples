package com.org.ds.general;

public class Time {
    public static final Time EPOCH = new Time(0);
    private int value;

    public Time(int secondsElapsedSinceEpoch) {
        setValue(secondsElapsedSinceEpoch);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int secondsElapsedSinceEpoch) {
        this.value = secondsElapsedSinceEpoch;
    }
}
