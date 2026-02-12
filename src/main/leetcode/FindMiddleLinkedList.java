package leetcode;
import data_structure.linked_lists.*;

// LEETCODE: 876. Middle of the Linked List

/**
Finds and returns the middle node of a singly linked list.
Uses the two-pointer technique (slow and fast pointers).
The fast pointer moves two nodes at a time while the slow
pointer moves one node. When the fast pointer reaches the end,
the slow pointer will be at the middle of the list.

Time complexity: O(n)
Space complexity: O(1)

@param list the singly linked list to search
@return the middle node of the list
*/
public class FindMiddleLinkedList {
    public static Node find(SingleLinkedList list) {
        Node current = list.getHead();
        Node middle = list.getHead();

        while(current.getNext() != null) {
            current = current.getNext().getNext();
            middle = middle.getNext();
        }

        return middle;
    }
}
