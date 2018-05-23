package com.sample.enums;

/**
 * Created by dhuertas on 12/14/16.
 */
public enum Suit {
    HEARTS(1),
    CLUBS(2),
    DIAMONDS(3),
    SPADES(4);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "Suit{" + "value=" + value + '}';
    }
}
