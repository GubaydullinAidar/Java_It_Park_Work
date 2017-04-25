package ru.itpark.dao;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    private final int MAX_SIZE = 5;

    private Object elements[];
    private int count;

    private class ArrayListIterator implements Iterator<T> {

        private int currentIndex;

        ArrayListIterator(int beginIndex) {
            currentIndex = beginIndex;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public T next() {
            T value = (T) elements[currentIndex];
            currentIndex++;
            return value;
        }
    }
    public ArrayList() {
        this.elements = new Object[MAX_SIZE];
        this.count = 0;
    }

    public void addLast(T element) {
        checkRange();
        this.elements[count] = element;
        count++;
    }

    public void addFirst(T element) {
        checkRange();
        for (int i = count; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = element;
        count++;
    }

    public void insert(T element, int index) {
        checkRange();
        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        this.elements[index] = element;
        count++;
    }

    public void remove(int index) {
        checkRange();
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        this.elements[count - 1] = null;
        count--;
    }

    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            Object tmp = elements[i];
            elements[i] = elements[count - 1 - i];
            elements[count - 1 - i] = tmp;
        }
    }

    public int size() {
        return count;
    }

    public T get(int index) {
        return (T) this.elements[index];
    }

    public int find(T element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return 0;
    }

    private void checkRange() {
        if (count >= MAX_SIZE) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator(0);
    }
}
