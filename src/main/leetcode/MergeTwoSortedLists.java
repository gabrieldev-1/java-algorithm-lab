package leetcode;

import data_structure.linked_lists.*;

public class MergeTwoSortedLists {
    public static SingleLinkedList merge(SingleLinkedList x, SingleLinkedList y) {

        Node currentX = x.getHead();
        Node currentY = y.getHead();

        SingleLinkedList result = new SingleLinkedList();
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

        // adiciona o restante
        if(currentX != null) tail.setNext(currentX);
        if(currentY != null) tail.setNext(currentY);

        result.setHead(dummy.getNext());
        return result;
    }
}
