package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode node = head;
        ListNode tail = new ListNode(0);
        while(node != null){
            tail = node;
            node = node.next;
            len ++;
        }
        k = k%len;
        if(k == 0) return head;
        int i=len - k;
        node = head;
        ListNode prev = new ListNode(0);
        while(i>0){
            prev = node;
            node = node.next;
            i--;
        }
        prev.next = null;
        tail.next = head;
        return node;
    }
}
