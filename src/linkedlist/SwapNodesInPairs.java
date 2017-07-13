package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
// bug free && accepted in the first time! Yeah!
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        //reverse next two nodes, and move two steps
        while(head!= null && head.next != null){
            // dummy: 0->1->2->3->4->5
            ListNode newHead = head.next.next; // head = 1, newHead = 3
            ListNode tmp = head.next; // tmp = 2
            // first step
            head.next = newHead;
            newHead = head;
            head = tmp;
            // second step  dummy: 0  head = 2 -> 3, newHead = 1 -> 3
            head.next = newHead;
            node.next = head;
            // update head and node
            head = newHead.next; // head = 3
            node = newHead; // node = 1
            // dummy: 0->2->1->3->4
        }
        return dummy.next;
    }
    //solution 2: (from nineChapter, more clear)
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            // head -> n1 -> n2
            // head -> n2 -> n1
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            // move to next pair
            head = n1;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode (5);
        ListNode rst = new SwapNodesInPairs().swapPairs2(head);
    }
}
