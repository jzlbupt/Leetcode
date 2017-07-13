package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode d1 = new ListNode(0), d2 = new ListNode(0);
        ListNode n1 = d1, n2 = d2;
        while(head != null){
            if(head.val < x){
                d1.next = head;
                d1 = d1.next;
            }else{
                d2.next = head;
                d2 = d2.next;
            }
            head = head.next;
        }
        d1.next = n2.next;
        // remember to cut the list
        n2.next = null;
        d2.next = null;
        return n1.next;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode rst = new PartitionList().partition(head, 2);
    }
}
