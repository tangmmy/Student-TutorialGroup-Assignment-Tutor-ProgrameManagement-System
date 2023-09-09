package ADT;

/**
 * SortedArrayList.java A class that implements the ADT Sorted List using an array.
 * Note: Some methods are not implemented yet and are left as practical exercises
 *
 * @author Frank M. Carrano
 * @version 2.0
 * @param <T>
 */

public interface SortedArrayInterface<T extends Comparable<T>> {
    /**
     * Adds a new entry to the sorted array.
     * @param newEntry The entry to add.
     */
    void add(T newEntry);

    /**
     * Removes a specified entry from the sorted array.
     * @param entry The entry to remove.
     * @return True if removed successfully, false otherwise.
     */
    boolean remove(T entry);

    /**
     * Get the number of entries in the sorted array.
     * @return The number of entries.
     */
    int size();

    /**
     * Check if the sorted array is empty.
     * @return True if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get an entry at a specified index.
     * @param index The index to retrieve.
     * @return The entry at the index.
     * @throws IndexOutOfBoundsException If index is out of bounds.
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Check if the sorted array contains a specified entry.
     * @param entry The entry to check for.
     * @return True if the entry is found, false otherwise.
     */
    boolean contains(T entry);

    /**
     * Get a string representation of the sorted array.
     * @return A string representation of the sorted array.
     */
    @Override
    String toString();
}
