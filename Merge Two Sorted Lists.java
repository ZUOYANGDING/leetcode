/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;
        while (head1!=null && head2!=null){
            if (head1.val<head2.val){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null){
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }
        return dummy.next;
    }
}