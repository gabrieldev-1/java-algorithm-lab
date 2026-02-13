package leetcode;
import data_structure.linked_lists.*;

public class FindCycles {
    /**
    * Detects whether a singly linked list contains a cycle.
    *
    * Uses Floyd's Cycle Detection algorithm (Tortoise and Hare),
    * where two pointers traverse the list at different speeds.
    * If a cycle exists, the fast pointer will eventually meet
    * the slow pointer. If the fast pointer reaches the end of
    * the list, no cycle is present.
    *
    * Time complexity: O(n)
    * Space complexity: O(1)
    *
    * @param list the singly linked list to be checked
    * @return true if the list contains a cycle, false otherwise
     */
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
        

