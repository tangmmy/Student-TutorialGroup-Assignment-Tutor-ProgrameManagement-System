
package ADT;
/**
 *
 * @author Li Hao
 * @param <T>
 */
public class lihaoLinkedList<T extends Comparable<T>> implements lihaoListInterface<T> {    
    Node firstNode;
    Node lastNode;
    int numberOfEntries;

    public lihaoLinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }
   
    // Adds a new entry to the end of the list
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } 
        else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        numberOfEntries++;
        return true;
    }
   
    // Edits the entry at the given position with a new value
    @Override
    public boolean edit(T anEntry, int givenPosition) {
        boolean valid = false;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == numberOfEntries) {
                lastNode.data = anEntry;
                valid = true;
            } 
            else {
                Node findNode = firstNode;
                for (int index = 1; index < givenPosition; index++) {
                    findNode = findNode.next;
                }
                findNode.data = anEntry;
                valid = true;
            }
        }
        return valid;
    }
  
    // Removes an entry at the given position and returns it
    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1 && numberOfEntries == 1) {
                result = firstNode.data;
                firstNode = null;
                lastNode = null;
            } 
            else if (givenPosition == 1 && numberOfEntries > 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } 
            else if (givenPosition == numberOfEntries) {
                result = lastNode.data;
                Node tempNode = firstNode;
                for (int index = 1; index < givenPosition - 1; index++) {
                    tempNode = tempNode.next; //get previous data
                }               
                lastNode = tempNode;                
            } 
            else {
                Node tempNode = firstNode;
                for (int index = 1; index < givenPosition - 1; index++) {
                    tempNode = tempNode.next;
                }

                result = tempNode.next.data;
                tempNode.next = tempNode.next.next;
            }
            numberOfEntries--;
        }
        return result;
    }
   
    // Retrieves the entry at the given position
    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == numberOfEntries) {
                result = lastNode.data;
            } else {
                Node findNode = firstNode;

                int counter = 1;
                while (counter < givenPosition) {  
                    findNode = findNode.next;
                    counter++;
                }

                result = findNode.data;
            }
        }
        return result;
    }
   
    // Finds the position of a given entry in the list
    @Override
    public int getPosition(T anEntry) {
        int position = 0;
        if (!isEmpty()) {
            Node findNode = firstNode;
            for (int index = 0; index < numberOfEntries; index++) {
                if (anEntry.compareTo(findNode.data) == 0) {
                    position = index + 1;
                }
                findNode = findNode.next;
            }
        }
        return position;
    }
   
    // Searches for a given entry in the list and returns it
    @Override
    public T search(T anEntry) {
        T result = null;
        if (!isEmpty()) {
            Node findNode = firstNode;
            for (int index = 0; index < numberOfEntries; index++) {
                if (anEntry.compareTo(findNode.data) == 0) {
                    result = findNode.data;
                }
                findNode = findNode.next;
            }
        }
        return result;
    }
       
    // Sorts the list in ascending order using selection sort
    @Override
    public void selectionSortAsc() {
      for (Node node1 = firstNode; node1 != null; node1 = node1.next) {

        Node smallest = node1; // Assume the current node is the smallest

        // Find the smallest node
        for (Node node2 = node1; node2 != null; node2 = node2.next) {
            if (smallest.data.compareTo(node2.data) > 0) {
                smallest = node2;
            }
        }

        // Swap the smallest node with the node in its actual position
        T temp = node1.data;
        node1.data = smallest.data;
        smallest.data = temp;
      }
   }
   
    // Sorts the list in descending order using selection sort
    @Override
    public void selectionSortDesc() {
        for (Node node1 = firstNode; node1 != null; node1 = node1.next) {

            Node greater = node1;//Assume the current node is the largest

            //find the greatest node
            for (Node node2 = node1; node2 != null; node2 = node2.next) {
                if (greater.data.compareTo(node2.data) < 0) {
                    greater = node2;
                }

            }
        //swaps the greatest node with the node in its actual position
            Node temp = new Node(node1.data);
            node1.data = greater.data;
            greater.data = temp.data;
        }
    }

    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    private class Node {
        private T data;
        private Node next;
        private Node previous;

        private Node() {
        }
        private Node(T data) {
            this.data = data;
            next = null;
        }
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }   
}
