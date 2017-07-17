package linkedlist;

/**
 * Created by ziljin on 14/07/2017.
 */

/**
 * A linked list is given such that each node contains an additional random pointer which
 * could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        // 1. 1->2->3->4->5 => 1->1->2->2->3->3->4->4->5->5
        RandomListNode node = head;
        while(node!= null){
            RandomListNode tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            tmp.random = node.random;
            node.next = tmp;
            node = node.next.next;
        }
        // 2. copy random pointers
        node = head;
        while(node != null) {
            if(node.next.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        // 3. partition list
        RandomListNode newHead = head.next;
        RandomListNode rst = newHead;
        node = head;
        while(node != null){
            node.next = node.next.next;
            node = node.next;
            if(newHead.next != null) {
                newHead.next = newHead.next.next;
                newHead = newHead.next;
            }
        }
        return rst;
    }
    public static void main(String args[]) {
        RandomListNode node = new RandomListNode(-1);
        node.random = node;
        RandomListNode rst = new CopyListWithRandomPointer().copyRandomList(node);

    }
}
