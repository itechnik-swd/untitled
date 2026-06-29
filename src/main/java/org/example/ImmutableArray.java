package org.example;

final class ImmutableArray {
    private final int[] array;

    public ImmutableArray(int[] array) {
        this.array = array.clone();
    }

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}
