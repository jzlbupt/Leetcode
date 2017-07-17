package linkedlist;

import java.util.Stack;

/**
 * Created by ziljin on 17/07/2017.
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:
 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode node = l1;
        while(node != null) {
            s1.push(node.val);
            node = node.next;
        }
        node = l2;
        while(node != null){
            s2.push(node.val);
            node = node.next;
        }
        int sum = 0;
        ListNode rst = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            rst.val = sum % 10;
            ListNode tmp = new ListNode(sum/10);
            tmp.next = rst;
            rst = tmp;
            sum = sum/10;
        }
        return rst.val == 0 ? rst.next : rst;
    }
}
