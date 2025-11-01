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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> hs = new HashSet<>();
        for (int x : nums) hs.add(x);
        while (head != null && hs.contains(head.val)) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            while (curr.next != null && hs.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}