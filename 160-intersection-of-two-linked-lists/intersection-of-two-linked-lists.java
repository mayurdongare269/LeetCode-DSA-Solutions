/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // M-1 Better Approach (TC: O(n+m))
        Set<ListNode> set = new HashSet<>(); // Set to store visited nodes from the first list

        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}