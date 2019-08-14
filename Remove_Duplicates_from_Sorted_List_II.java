/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode after = head.next;
        while (after != null) {
            if (cur.val == after.val) {
                after = after.next;        
            } else {
                int flag = 0;
                while (cur.val == cur.next.val) {
                    cur = cur.next;
                    flag++;
                }
                if (flag == 0) {
                    after = after.next;
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    after = after.next;
                    cur = cur.next;
                    pre.next = cur;
                }
            }
        }
        if (cur.next != null && cur.val == cur.next.val) {
            pre.next = after;
        }
        return dummy.next;
    }
}