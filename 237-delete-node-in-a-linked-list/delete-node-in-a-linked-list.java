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

        node.val = node.next.val; // del node madhe next node chi value ghetali
        node.next = node.next.next; // and as there are 2 same nodes so remove one
    }
}