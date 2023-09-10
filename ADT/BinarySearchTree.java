/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author tangm
 */
import java.util.NoSuchElementException;
import java.util.Iterator;
//import java.util.Comparator;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E> > implements BSTInterface<E>{

    private Node root;
    public BinarySearchTree(){
        root=null;
    }
    private BinarySearchTree(Node r){
        this.root=r;
        root.parent=null;
        root.left=null;
        root.right=null;
    }
    
    private class Node<E>{
        private Node parent,left,right;
        private E element;

        public Node() {
        }
        
        public Node(E element) {
            this.element = element;
        }
        public Node(E element,Node parent){
            this.element=element;
            this.parent=parent;
        }
        public String printNode(){
            return this.element.toString();
        }
        public void setElement(E x){
            this.element=x;
        }
        public E getElement(){
            return this.element;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
        public boolean isLeaf(){
            return this.right==null && this.left==null;
        }
      
    }
    private class BSTIterator implements Iterator{
        private Stack<Node> stack;
        public Node root;
        
        
        private BSTIterator(Node root){
            stack = new Stack<Node>();
            moveLeft(root);
        }
        
        private void moveLeft(Node current){
        while (current != null) {
            stack.push(current);
            current = current.left;
            }
        }
        @Override
        public boolean hasNext(){
            return !stack.isEmpty() ;
        }
        @Override
        public Node next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Node current = stack.pop();
 
            if (current.right != null){
                moveLeft(current.right);
            }
            return current;
        }
        
    }
    
    @Override
    public void printTree(){
        BSTIterator itr= new BSTIterator(this.root);
        while(itr.hasNext()){
            System.out.println(itr.next().element);
        }
    
    
    }
    @Override
    public E find(E x){
        Node<E> p=this.root;
        while(p!=null){
            if(x.compareTo(p.element)==0) return p.element;
            else if(x.compareTo(p.element)<0) p=p.left;
            else p=p.right;
        }
        return null;
    }
    /*
    
    public void preorder(){
        preorder(root);
        
    }
    public void preorder(Node p){
        if(p==null) return;
        
           
        p.visit();
        
        preorder(p.left);
        preorder(p.right);
        
        return;
    }
    
    */
    
    
    
    @Override
    public boolean isEmpty(){
        return this.root==null;
    }
    
    @Override
    public void insert(E x){
        Node<E> p=this.root;
        BSTIterator itr=new BSTIterator(this.root);
        if(p==null){
            this.root=new Node(x);
            return;
        }
        while(p!=null){
           
            if(x.compareTo(p.element) < 0 && p.left!=null) p=p.left;
            else if(x.compareTo(p.element)>0 && p.right!=null) p=p.right;
            else if(x.compareTo(p.element)<=0){
                p.left=new Node(x,p);
                return;
            }
            else{
                p.right=new Node(x,p);
                return;
            }      
        }
    }
    
    
    private void deleteNode(Node N){
        Node<E> par=N.getParent();
        if(par.left==N) par.setLeft(null);
        else par.setRight(null);
    }
    @Override
    public void delete(E x){
        Node<E> tmp,tmpPar=null,p=this.root,prev=null;
        
        if(this.root.left==null && this.root.right==null && this.root.getElement(). equals(x)==true){//tree has only one node left
            this.root=null;
            return;
        }
        
        
        while(p!=null && (p.element).equals(x)==false){
            prev=p;
            if(p.element.compareTo(x)<0) p=p.right;
            else p=p.left;
        }
        
        
        if(p==null || p.element.equals(x)==false){
            System.out.println("not found!");
            return;
        }
        else if(root==null){
            System.out.println("tree is empty");
            return;
        }
        
        
        if(p.left==null && p.right==null){//it is a leaf
            if(p==root) p=null;
            else if(prev.left==p) prev.left=null;
            else prev.right=null;
            
        }
        else if(p.left != null && p.right==null){// left subtree is not null,right is null, replace it with its left child
            if(p==root) {this.root=p.left;}
            else if(prev.left==p) prev.left=p.left;
            else prev.right=p.left;
            
        }
        else if(p.left == null && p.right!=null){//left subtree is null,right is not null, replace it with its right child
            if(p==root) {this.root=p.right;}
            else if(prev.left==p) prev.left=p.right;
            else prev.right=p.right;
        }
        else{// left and right is not null, replace it with its inorder successor
            BSTIterator itr=new BSTIterator(p);
            tmp=itr.next();
            while(tmp.element.compareTo(p.element)<=0) {tmp=itr.next();}
            //tmp=itr.next();
            //tmp=itr.next();
            tmpPar=tmp.getParent();
            //System.out.print("tmp is "+tmp.printNode()+" "+"p is "+p.printNode()+" "+"tmpPar is "+tmpPar.printNode()+"\n");
            p.setElement(tmp.getElement());
            
            if (tmpPar != p) tmpPar.setLeft(tmp.getRight());
            else tmpPar.setRight(tmp.getRight());
            p.setElement(tmp.getElement());
       
        }
        return;
    }
}

