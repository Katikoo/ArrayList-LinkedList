package com.company;

public class Main {

    public static void main(String[] args) {

        IntList arrayList = new IntArrayList();
        IntList linkedList = new IntLinkedList();

        arrayList.add(47);
        arrayList.add(0);
        arrayList.add(-51);
        arrayList.add(-102);
        arrayList.add(7);

        System.out.println("IntArrayList before sorting: " + arrayList.toString());
    //    sort();
        System.out.println("IntArrayList after sorting: " + arrayList.toString());

        linkedList.add(3);
        linkedList.add(0);
        linkedList.add(-44);
        linkedList.add(61);
        linkedList.add(999);

        System.out.println("IntLinkedList before sorting: " + linkedList.toString());
    //     sort();
        System.out.println("IntLinkedList after sorting: " + linkedList.toString());
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}