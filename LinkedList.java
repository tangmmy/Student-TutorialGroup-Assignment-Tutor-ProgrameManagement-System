/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author tangm
 */
import java.util.*;
public class LinkedList<E> {
    public LinkedList(){first=null;}
    public E getFirst(){
        if(first==null) throw new NoSuchElementException();
        return first.data;
    }
    public E removeFirst(){
        if(first==null) throw new NoSuchElementException();
        E element=first.data;
        first=first.next;
        return element;
    }
    public void addFirst(E element){
        Node newNode=new Node();
        newNode.data=element;
        newNode.next=first;
        first=newNode;
    }
    public void remove(E element){
        Node newNode=this.first;
        //System.out.print(element.toString() + " "+ (newNode.data).toString());
        if(Objects.equals( newNode.data,element)) {
            System.out.print("remove first\n");
            removeFirst();
        }
        else{
            //System.out.print("as2\n");
            while(newNode.next!=null){
                //System.out.print("as2\n");
                if( Objects.equals((newNode.next).data,element)) {
                    newNode.next = (newNode.next).next;
                    break;
                }
                //System.out.print(newNode.next + " "+newNode.next.next);
                newNode=newNode.next;
                
            }
        }
        
        
        
    }
    public ListIterator<E> listIterator(){
        return new LinkedListIterator();
    }
    
    
    private Node first;
    private class Node{
        public E data;
        public Node next;
    }
    private class LinkedListIterator implements ListIterator<E>{
        private Node position;
        private Node previous;
        public LinkedListIterator(){
            position=null;
            previous=null;
        }
        @Override
        public boolean hasNext(){
            if(position==null) return first!=null;
            else return position.next!=null;
        }
        @Override
        public E next(){
            if(!hasNext()) throw new NoSuchElementException();
            previous=position;
            
            if(position==null) position=first;
            else position=position.next;
            return position.data;
            
        
        }
        @Override
        public void add(E element){
            if(position==null){
                addFirst(element);
                position=first;
            }
            else{
                Node newNode=new Node();
                newNode.data=element;
                newNode.next=position.next;
                position.next=newNode;
                position=newNode;
            }
            previous=position;
            
        }
        @Override
        public void remove(){
            if(previous==position) throw new IllegalStateException();
            if(position==first) removeFirst();
            else previous.next=position.next;
            position=previous;
            
            
        }
        @Override
        public void set(E element){
            if(position==null) throw new NoSuchElementException();
            position.data=element;
        }
           
    }
}
