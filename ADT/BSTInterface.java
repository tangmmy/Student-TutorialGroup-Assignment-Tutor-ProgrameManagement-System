/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

/**
 *
 * @author tangm
 */
public interface BSTInterface<E> {
    public void printTree();
    public boolean isEmpty();
    public void insert(E x);
    public E find(E x);
    public void delete(E x);
}