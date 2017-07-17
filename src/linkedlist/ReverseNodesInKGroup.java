package linkedlist;

/**
 * Created by ziljin on 17/07/2017.
 */

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.
 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // count the length of list
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len ++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        int n = len / k;
        // reverse n times
        while(n>0){
            head = reverseNextK(head, k);
            n--;
        }
        return dummy.next;

    }
    // eg 0->1->2->3->4->... k = 3
    // => 0->3->2->1->4
    // => return 1
    private ListNode reverseNextK(ListNode head, int k){
        ListNode newHead = null;
        ListNode node = head.next;
        ListNode tail = node;
        while(k >0){
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
            k--;
        }
        head.next = newHead;
        tail.next = node;
        return tail;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode (5);
        ListNode rst = new ReverseNodesInKGroup().reverseKGroup(head, 3);
    }
}
