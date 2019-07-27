/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return divideLists(lists, 0, lists.length-1);
    }
    
    public ListNode divideLists(ListNode[] lists, int head, int tail) {
        if (head > tail ){
            return null;
        } else if (head == tail) {
            return lists[head];
        } else {
            int mid = (head + tail) / 2;
            ListNode l1 = divideLists(lists, head, mid);
            ListNode l2 = divideLists(lists, mid+1, tail);
            return mergeTwoLists(l1, l2);
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return dummy.next;
    }
}