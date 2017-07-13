package linkedlist;

/**
 * Created by ziljin on 12/07/2017.
 */

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int tmp = head.next.val;
                while(head.next != null && head.next.val == tmp){
                    head.next = head.next.next;
                }
            }else{ // move when head.next val is not a duplicate one.
                head = head.next;
            }
        }
        return dummy.next;
    }
}
