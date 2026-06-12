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

    public ListNode reverseKGroup(ListNode head, int k) {
        // TC: O(2n) & SC: O(1)
        // remember the logic and if forgot see striver video...

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            // Step 1: Find kth node from current position
            ListNode kthNode = getKthNode(temp, k);

            // Less than k nodes left -> don't reverse
            if (kthNode == null) {
                if (prevLast != null) { // if list is not big then no need to do this , hence like that condition added... do dry run if forgot
                    prevLast.next = temp;
                }
                break;
            }

            // Step 2: Store next group's starting node
            ListNode nextNode = kthNode.next;

            // Step 3: Break current k-group
            kthNode.next = null;

            // Step 4: Reverse current group
            reverseLinkedList(temp);

            // Step 5: Update head for first group
            if (temp == head) {
                head = kthNode;
            } else {
                // Connect previous reversed group with current reversed group
                prevLast.next = kthNode;
            }

            // Step 6: temp becomes last node after reversal
            prevLast = temp;

            // Move to next group
            temp = nextNode;
        }

        return head;
    }


    // Reverse a linked list and return new head
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Find kth node starting from temp
    private ListNode getKthNode(ListNode temp, int k) {
        k--;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp;
    }
}