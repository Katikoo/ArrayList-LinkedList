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
        System.out.print("IntArrayList after sorting: ");
        sort(arrayList);
        System.out.println();

        linkedList.add(3);
        linkedList.add(0);
        linkedList.add(-44);
        linkedList.add(61);
        linkedList.add(999);

        System.out.println("IntLinkedList before sorting: " + linkedList.toString());
        System.out.print("IntLinkedList after sorting: ");
        sort(linkedList);
        System.out.println();
    }

    private static void sort(IntList list) {
        int[] arr = list.makeArrayFromIntList(list);
        int tmp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = tmp;
            }
        }
        System.out.println(list.makeIntListFromArray(arr));
    }
}