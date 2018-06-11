package com.company;

public class IntLinkedList implements IntList {

    private int size = 0;
    private Entry first;
    private Entry last;

    IntLinkedList() {
    }

    private static class Entry {
        int item;
        Entry next;
        Entry previous;

        Entry(int value) {
            this.item = value;
        }
    }

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (first == null) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public void add(int index, int element) {
        check(index);
        Entry newEntry = new Entry(element);
        if (index == 0) {
            newEntry.next = first;
            first.previous = newEntry;
            first = newEntry;
            size++;
            return;

        } else if (index == size - 1) {
            newEntry.previous = last;
            last.next = newEntry;
            last = newEntry;
            size++;
            return;

        } else {
            Entry oldEntry = first;
            for (int i = 0; i < index; i++) {
                oldEntry = oldEntry.next;
            }
            Entry oldPrevious = oldEntry.previous;
            oldPrevious.next = newEntry;
            oldEntry.previous = newEntry;
            newEntry.previous = oldPrevious;
            newEntry.next = oldEntry;
        }
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        return index(value) != -1;
    }

    private int index(int value) {
        int index = 0;
        if (value == 0) {
            for (Entry tmp = first; tmp != null; tmp = tmp.next) {
                if (tmp.item == 0)
                    return index;
                index++;
            }
        } else {
            for (Entry tmp = first; tmp != null; tmp = tmp.next) {
                if (tmp.item == value)
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        check(index);
        Entry result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        check(index);
        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
            last = last.previous;
        } else {
            entry(index - 1).next = entry(index + 1);
        }
        size--;
        return true;
    }

    @Override
    public boolean removeElement(int element) {
        if (element == 0) {
            for (Entry tmp = first; tmp != null; tmp = tmp.next) {
                if (tmp.item == 0) {
                    entryBefore(tmp);
                    return true;
                }
            }
        } else {
            for (Entry tmp = first; tmp != null; tmp = tmp.next) {
                if (tmp.item == element) {
                    entryBefore(tmp);
                    return true;
                }
            }
        }
        return false;
    }

    private void entryBefore(Entry tmp) {
        final Entry next = tmp.next;
        final Entry prev = tmp.previous;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            tmp.previous = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previous = prev;
            tmp.next = null;
        }
        tmp.item = 0;
        size--;
    }

    @Override
    public void set(int index, int element) {
        check(index);
        entry(index).item = element;
    }

    private Entry entry(int index) {
        if (index < (size >> 1)) {
            Entry entry = first;
            for (int i = 0; i < index; i++)
                entry = entry.next;
            return entry;
        } else {
            Entry entry = last;
            for (int i = size - 1; i > index; i--)
                entry = entry.previous;
            return entry;
        }
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
    public int[] makeArrayFromIntList(IntList list) {
        int[] result = new int[list.size()];
        Entry entry = first;
        for (int i = 0; i < result.length; i++) {
            result[i] = entry.item;
            entry = entry.next;
        }
        return result;
    }

    @Override
    public IntList makeIntListFromArray(int[] array) {
        IntList result = new IntLinkedList();
        for (int newArray : array) {
            result.add(newArray);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i)).append(", ");
        }
        if (size != 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

}
