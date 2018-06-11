package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

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

        System.out.println("The result speed test for 'ArrayList<Integer>', 'IntArrayList', 'LinkedList<Integer>' and 'IntLinkedList': ");
        speedTest();

        System.out.println("Counting the method resize(): ");
        printResizeCounter(1000);
        printResizeCounter(1000000);
        printResizeCounter(1000000000);
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

    private static void printResizeCounter(int size) {
        IntArrayList intArrayList = new IntArrayList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            intArrayList.add(random.nextInt(10));
        }
        System.out.printf("The method 'resize()' is called %d times when added %d elements.\n", intArrayList.getResizeCounter(), size);
    }

    private static void speedTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntArrayList intArrayList = new IntArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntLinkedList intLinkedList = new IntLinkedList();

        final int COUNT = 100000;
        long timeBefore;
        long timeAfter;
        double currentTime;

        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(random.nextInt(100));
            intArrayList.add(random.nextInt(100));
            linkedList.add(random.nextInt(100));
            intLinkedList.add(random.nextInt(100));
        }

        System.out.println("Method 'get(int index)' from the middle of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intArrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int element)' at the end of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.add(11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the beginning of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intArrayList.add(0, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.add(0, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the middle of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(arrayList.size() / 2, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intArrayList.add(intArrayList.size() / 2, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(linkedList.size() / 2, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.add(intLinkedList.size() / 2, 11111);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the beginning of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intArrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the middle of the list (100'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intArrayList.remove(intArrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            intLinkedList.remove(intLinkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();
    }
}
