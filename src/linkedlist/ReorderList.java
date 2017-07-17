package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Given a singly linked list L: L0-L1-…-Ln-1-Ln,
 reorder it to: L0-Ln-L1-Ln-1-L2-Ln-2-…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
// bug free && accepted in the first time! Yeah!
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 1. Cut the list into two list  1->2->3->4->5 => 1->2->3 & 4->5
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        // 2. Reverse the second list  5->4
        ListNode newHead = null;
        while(node != null){
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
        }
        // 3. Merge into one list 1->5->2->4->3
        node = head;
        while(node != null && newHead != null) {
            ListNode tmp1 = node.next;
            ListNode tmp2 = newHead.next;
            node.next = newHead;
            newHead.next = tmp1;
            node = tmp1;
            newHead = tmp2;
        }
    }
}
