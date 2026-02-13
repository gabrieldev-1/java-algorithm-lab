package leetcode;
import data_structure.linked_lists.*;

public class FindCycles {
    public static Boolean find(SingleLinkedList list) {
        Node slow = list.getHead();
        Node fast = list.getHead();

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            
            if(fast == slow) {
                return true;
            }
        }
        return false;
    
    }
}
        

