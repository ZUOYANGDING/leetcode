/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null ||  head.next==null || m==n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode mark = dummy;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        int index = 1;
        while (index < m) {
            mark = mark.next;
            pre = pre.next;
            cur = cur.next;
            next = next.next;
            index++;
        }
        while (index < n) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            index++;
        }
        ListNode temp = mark.next;
        mark.next = cur;
        temp.next = cur.next;
        cur.next = pre;
        return dummy.next;
        
    }
}