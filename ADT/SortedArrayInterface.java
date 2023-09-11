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
    

    
    void add(T newEntry);
    //Adds a new entry to the sorted array.
    
    boolean remove(T entry);
    //Removes a specified entry from the sorted array.
 
    int size();
    //Get the number of entries in the sorted array.
 
    boolean isEmpty();
    //Check if the sorted array is empty.

    T get(int index) throws IndexOutOfBoundsException;
    //Get an entry at a specified index.

    boolean contains(T entry);
    //Check if the sorted array contains a specified entry.
    
    
    //Get a string representation of the sorted array.
    @Override
    String toString();
}
