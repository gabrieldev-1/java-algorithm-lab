package leetcode;

import data_structure.linked_lists.*;
import java.util.HashMap;

// LEETCODE: 83. Remove Duplicates from Sorted and Unsorted list;
public class RemoveDuplicates {
    /**
    Removes duplicate values from a sorted singly linked list.
    Since the list is sorted, duplicate elements will appear consecutively.
    The algorithm traverses the list and removes nodes that have the same
    value as the current node by adjusting node references.

    Time complexity: O(n)
    Space complexity: O(1)
    
    @param list the sorted singly linked list to remove duplicates from
    */
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
    /**
    Removes duplicate values from an unsorted singly linked list.
    Uses a HashMap to track values that have already been visited.
    While traversing the list, if the next node contains a value that
    already exists in the map, the node is removed by updating references.

    Time complexity: O(n)
    Space complexity: O(n)

    @param list the unsorted singly linked list to remove duplicates from
    */
    public static void removeFromUnsorted(SingleLinkedList list) {
        HashMap<Integer, Boolean> map = new HashMap<>();
    
        Node current = list.getHead();
        map.put(current.getData(), true);

        while(current.getNext() != null) {
            Node next = current.getNext();

            if(map.containsKey(next.getData())) {
                current.setNext(next.getNext());
            }

            map.put(next.getData(), true);
            current = current.getNext();
        }
    }
}
