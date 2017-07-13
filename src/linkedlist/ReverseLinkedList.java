package linkedlist;

/**
 * Created by ziljin on 12/07/2017.
 */

/**
 * Reverse a singly linked list.
 */
// bug free && accepted in the first time! Yeah!
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
