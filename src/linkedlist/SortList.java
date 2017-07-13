package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, prev = new ListNode(0);
        while(fast!= null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = sortList(slow);
        prev.next = null;
        head = sortList(head);
        return mergeTwoSortedList(head, head2);
    }
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        ListNode node = new ListNode(0);
        ListNode rst = node;
        while(l1!= null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 != null){
            node.next = l1;
        }
        if(l2 != null) {
            node.next = l2;
        }
        return rst.next;
    }
    public static void main(String args[]) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode rst = new SortList().sortList(head);
    }
}
