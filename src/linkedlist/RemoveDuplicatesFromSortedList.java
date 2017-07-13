package linkedlist;

/**
 * Created by ziljin on 12/07/2017.
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        node = head;
        while(node != null && node.next != null){
            if(node.next.val != node.val){
                node = node.next;
            }else{
                node.next = node.next.next;
            }
        }
        return head;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode rst = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
    }
}
