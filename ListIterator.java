/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author tangm
 */
public interface ListIterator<E> {
    E next();
    boolean hasNext();
    void add(E element);
    void remove();
    void set(E element);
    
    
}
