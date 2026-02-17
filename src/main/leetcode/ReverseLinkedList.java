package leetcode;
import data_structure.linked_lists.*;

// LEETCODE: 206. Reverse Linked List

/**
Reverses the nodes of a singly linked list in place.
Uses three references (previous, current, next) to safely reverse
node links while traversing the list once. The last processed node
becomes the new head of the list.

Time complexity: O(n)
Space complexity: O(1)

@param list the singly linked list to be reversed
*/
public class ReverseLinkedList {
    public static void reverse(LinkedList list) {
        Node previous = null;
        Node current = list.getHead();
        Node next = null;

        while(current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        list.setHead(previous);
    }
}
