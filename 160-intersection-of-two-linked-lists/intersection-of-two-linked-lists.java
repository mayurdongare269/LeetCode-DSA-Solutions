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
        // M-1 Better Approach (TC: O(n+m)) (SC: O(N))
        // Set<ListNode> set = new HashSet<>(); // Set to store visited nodes from the first list

        // while(headA != null) {
        //     set.add(headA);
        //     headA = headA.next;
        // }

        // while(headB != null) {
        //     if(set.contains(headB)) {
        //         return headB;
        //     }
        //     headB = headB.next;
        // }

        // return null;

        // M-2: Optimal- TC: O(n1 + 2n2) & SC: O(1)
        ListNode t1 = headA;
        int n1 = 0; // cnt length of first list

        while(t1 != null) {
            n1++;
            t1 = t1.next;
        }

        ListNode t2 = headB;
        int n2 = 0; // cnt length of second list

        while(t2 != null) {
            n2++;
            t2 = t2.next;
        }

        // now compare and which length is large move it (large - small) lenght forwar. and then start traversing
        if(n1 < n2) {
            return collisionPoint(headA, headB, n2-n1); // hear list2 is large 
        } else {
            return collisionPoint(headB, headA, n1 - n2); // sequence must be correst..first small then large list
        }

        // return null;
    }

    public static ListNode collisionPoint(ListNode t1, ListNode t2, int d) {
        while(d != 0) {
            d--;
            t2 = t2.next;
        }

        while(t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1; // or t2
    }
}