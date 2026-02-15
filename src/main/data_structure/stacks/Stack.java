package data_structure.stacks;

class Node {
    int data;
    Node previous;

    public Node(int data) {
        this.data = data;
        this.previous = null;2
    }
}
/**
* Represents a stack data structure implemented using linked nodes.
* Follows the LIFO (Last In, First Out) principle, where elements
* are added and removed from the top of the stack.
*/
public class Stack {
    private Node first;
    private int size;
 
    public Stack() {
        this.first = null;
        this.size = 0;
    }
    
    public int getSize() {
        return size;
    }

    public Node peek() {
        if(first == null) {
            System.out.println("The list is empty.");
        }

        return first;
    }

    public Boolean isEmpty() {
        if(first == null) {
            return true;

        } else {
            return false;
        
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        
        if (first == null) {
            first = newNode;
            return;
        }

        newNode.previous = first;
        first = newNode;
        size++;
    }

    public void pop() {
        if(first == null) {
            System.out.println("The list is empty.");
            return;
        }

        first = first.previous;
    }

    public void print() {
        Node current = first;
        
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.previous;
        }
    }
}
