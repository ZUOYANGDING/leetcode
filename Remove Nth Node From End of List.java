/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n==0){
            return head;
        }
        ListNode current_node = head;
        ListNode break_node = null;
        ListNode pre_node = null;
        int sleep = n-1;
        int pre = n;
        while (current_node != null){
            if (sleep == 0){
                break_node = head;
            } else if (sleep < 0) {
                break_node = break_node.next;
            }
            if (pre == 0){
                pre_node = head;
            } else if (pre < 0){
                pre_node = pre_node.next;
            }
            sleep--;
            pre--;
            current_node = current_node.next;
        }
        ListNode next_node = break_node.next;
        // System.out.println("pre_node");
        if (pre_node == null){
            // System.out.println("here");
            head = break_node.next;
            return head;
        } else {
            pre_node.next = next_node;
            return head;
        }
    }
}