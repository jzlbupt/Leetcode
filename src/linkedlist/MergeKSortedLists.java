package linkedlist;

/**
 * Created by ziljin on 17/07/2017.
 */

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    // Divide & Conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return mergeHelper(lists, 0, lists.length -1);
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if(start == end){
            return lists[start];
        }
        int mid = start + (start-end)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    // TLE
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists == null || lists.length == 0) return null;
//        if(lists.length == 1) return lists[0];
//        for(int i=1; i<lists.length; i+=2){
//            lists[i] = mergeTwoLists(lists[i-1], lists[i]);
//        }
//        return lists[lists.length -1];
//    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
