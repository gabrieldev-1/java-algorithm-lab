package leetcode;
import data_structure.linked_lists.*;

// LEETCODE: 83. Remove Duplicates from Sorted and Unsorted list;
public class RemoveDuplicates {
    public static void removeFromSorted(SingleLinkedList list) {
        Node current = list.getHead();

        while(current.getNext() != null) {
            Node next = current.getNext();

            if(current.getData() == next.getData()) {
                current.setNext(next.getNext());
            }

            current = current.getNext();
        }

    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.add(10);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(40);
        
        removeFromSorted(list);
        list.print();
    }
}
