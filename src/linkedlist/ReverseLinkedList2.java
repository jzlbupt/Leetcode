package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 < m < n < length of list.
 */
// bug free && accepted in the first time! Yeah!
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = new ListNode(0);
        int tmp = n-m;
        while(m>0){
            tail = head;
            head = head.next;
            m--;
        }
        // dummy: 0->1->2->3->4->5  tail = 1
        ListNode reverseHead = head;
        while(tmp >0) {
            head = head.next;
            tmp --;
        }
        ListNode lastHead = head.next;
        head.next = null;
        // dummy: 0->1->2->3->4  5  tail = 1, reverseHead = 2, lastHead = 5
        // reverse from reverseHead
        while(reverseHead != null){
            ListNode node = reverseHead.next;
            reverseHead.next = lastHead;
            lastHead = reverseHead;
            reverseHead = node;
        }
        tail.next = lastHead;
        return dummy.next;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode (5);
        ListNode rst = new ReverseLinkedList2().reverseBetween(head, 2, 4);
    }
}
