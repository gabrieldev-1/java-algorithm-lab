package leetcode;

import data_structure.linked_lists.*;

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
