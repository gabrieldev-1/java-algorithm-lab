package leetcode;

import data_structure.linked_lists.*;

public class ReverseLinkedList {
    public static void reverse(SingleLinkedList list) {
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
