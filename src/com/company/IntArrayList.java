package com.company;

public class IntArrayList implements IntList {

    private int arr[] = new int[10];
    private int size = 0;

    IntArrayList() {
    }

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            resize();
        }
        arr[size] = element;
        size++;
    }

    @Override
    public void add(int index, int element) {
        check(index);
        if (size >= arr.length) {
            resize();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        for (int newArr : arr) {
            if (newArr == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        check(index);
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        check(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean removeElement(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void set(int index, int element) {
        check(index);
        arr[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void check(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(", ");
        }
        if (size != 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize() {
        int newSize = arr.length * 3 / 2 + 1;
        System.out.println("newSize: " + newSize);
        int[] newArr = new int[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}