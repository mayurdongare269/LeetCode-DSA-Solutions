/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // we are going to copy next node to position of given node and ref to next.next

        node.val = node.next.val;
        node.next = node.next.next;
    }
}