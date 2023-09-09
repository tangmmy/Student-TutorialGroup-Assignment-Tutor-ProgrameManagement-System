package ADT;

/**
 * SortedArrayList.java A class that implements the ADT Sorted List using an array.
 * Note: Some methods are not implemented yet and are left as practical exercises
 *
 * @author Frank M. Carrano
 * @version 2.0
 * @param <T>
 */

import java.util.Iterator;

public class SortedArrayList<T extends Comparable<T>> implements Iterable<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the SortedArrayList with a default capacity
    public SortedArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Add an element to the SortedArrayList while maintaining sorted order
    public void add(T element) {
        if (size == array.length) {
            ensureCapacity();
        }

        int index = findInsertionIndex(element);
        shiftElementsRight(index);
        array[index] = element;
        size++;
    }

    // Remove an element from the SortedArrayList if it exists
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            shiftElementsLeft(index);
            size--;
            return true;
        }
        return false;
    }

    // Get the current size of the SortedArrayList
    public int size() {
        return size;
    }

    // Check if the SortedArrayList is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get an element at a specific index in the SortedArrayList
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    // Check if the SortedArrayList contains a specific element
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    // Override toString method to provide a string representation of the SortedArrayList
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Override the iterator method to support iteration over the SortedArrayList
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return (T) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // Find the index where the element should be inserted to maintain sorted order
    private int findInsertionIndex(T element) {
        int index = 0;
        while (index < size && element.compareTo((T) array[index]) > 0) {
            index++;
        }
        return index;
    }

    // Shift elements to the right starting from the given index
    private void shiftElementsRight(int index) {
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
    }

    // Shift elements to the left starting from the given index
    private void shiftElementsLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
    }

    // Ensure that the array has sufficient capacity, resizing if necessary
    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Find the index of a specific element in the SortedArrayList
    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
