package leetcode;

// Problem: 21. Merge Two Sorted Lists

import data_structure.linked_lists.*;

public class MergeTwoSortedLists {
    /**

    * Merges two sorted linked lists into a single sorted linked list.
    * The method iteratively compares the nodes of both lists and builds
    * a new sorted list using a dummy node to simplify pointer handling.
    *
    * obs: This solution assumes both input lists are already sorted in ascending order.
    *
    * time complexity: O(n + m);
    * space complexity: O(1);
    *
    * @param x first sorted linked list;
    * @param y second sorted linked list;
    * @return a new linked list containing all elements from both lists in sorted order.
    *

    */
    public static LinkedList merge(LinkedList x, LinkedList y) {

        Node currentX = x.getHead();
        Node currentY = y.getHead();

        LinkedList result = new LinkedList();
        Node dummy = new Node(0);
        Node tail = dummy;

        while(currentX != null && currentY != null) {

            if(currentX.getData() <= currentY.getData()) {
                tail.setNext(currentX);
                currentX = currentX.getNext();
                
            } else {
                tail.setNext(currentY);
                currentY = currentY.getNext();

            }

            tail = tail.getNext();
        }

        if(currentX != null) tail.setNext(currentX);
        if(currentY != null) tail.setNext(currentY);

        result.setHead(dummy.getNext());
        return result;
    }
}
