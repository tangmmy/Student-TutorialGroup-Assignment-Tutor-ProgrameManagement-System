
package ADT;

/**
 *
 * @author Li Hao
 * @param <T>
 */

public interface lihaoListInterface <T extends Comparable<T>> {
    
    public boolean add(T newEntry);

    public boolean edit(T anEntry, int position);

    public T remove(int position);

    public T getEntry(int position);

    public int getPosition(T anEntry);

    public T search(T anEntry);
    
    public void selectionSortAsc();

    public void selectionSortDesc();

    public void clear();

    public boolean isEmpty();

    public int getNumberOfEntries();

}
