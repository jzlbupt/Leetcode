package linkedlist;

/**
 * Created by ziljin on 12/07/2017.
 */

/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
// bug free && accepted in the first time! Yeah!
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(head != null){
            if(head.val == val){
                head = head.next;
            }else{
                node.next = head;
                node = node.next;
                head = head.next;
            }
        }
        node.next = head;
        return dummy.next;
    }
}
