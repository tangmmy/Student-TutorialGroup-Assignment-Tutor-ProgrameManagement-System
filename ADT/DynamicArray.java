package ADT;

//@author chaawd (github)

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the DynamicArray with a default capacity
    public DynamicArray() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add an element to the DynamicArray
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    // Get an element at a specific index in the DynamicArray
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    // Remove an element at a specific index from the DynamicArray
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    // Get the current size of the DynamicArray
    public int size() {
        return size;
    }

    // Check if the DynamicArray contains a specific element
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    // Ensure that the array has sufficient capacity, resizing if necessary
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    // Override the iterator method to support iteration over the DynamicArray
    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    // Inner class for the iterator implementation
    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex = 0;

        // Check if there are more elements to iterate over
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        // Get the next element during iteration
        @Override
        public T next() {
            return (T) array[currentIndex++];
        }
    }
}
