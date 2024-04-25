package org.example.domain;

public class Door {
    int number;

    public Door(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Door{" +
                "number=" + number +
                '}';
    }
}
