/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k<=1) {
            return head;
        }
        ListNode dummy_head = new ListNode(-1);
        dummy_head.next = head;
        ListNode temp = dummy_head;
        int length = 1;
        while (head != null) {
            if (length % k == 0) {
                temp = reverse(temp, head.next);
                head = temp.next;
            } else {
                head = head.next;
            }
            length++;
        }
        return dummy_head.next;
    }
    
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode index = head.next;
        ListNode pre = head;
        ListNode ne = null;
        ListNode dummy_head = head.next;
        while (index != tail) {
            ne = index.next;
            index.next = pre;
            pre = index;
            index = ne;
        }
        dummy_head.next = index;
        head.next = pre;
        return dummy_head;
    }
}