/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow1 = head;
        ListNode slow2 = head;
        for (int i = 0;i < n; i++) {
            slow2 = slow2.next;
        }
        if (slow2 == null) {
            return head.next;
        }
        while (slow2.next != null) {
            slow1 = slow1.next;
            slow2 = slow2.next;
        }
        slow1.next = slow1.next.next;
        return head;
    }
}