package linkedlist;

/**
 * Created by ziljin on 13/07/2017.
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8


 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int plus = 0;
        while(l1 != null && l2 != null){
            int num = l1.val + l2.val + plus;
            plus = num/10;
            node.next = new ListNode(num%10);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        ListNode tmp;
        if(l1 != null){
            tmp = l1;
        }else{
            tmp = l2;
        }
        while(tmp != null){
            int num = tmp.val + plus;
            plus = num/10;
            node.next = new ListNode(num%10);
            tmp = tmp.next;
            node = node.next;
        }
        if(plus != 0){
            node.next = new ListNode(plus);
        }
        return dummy.next;
    }
}
