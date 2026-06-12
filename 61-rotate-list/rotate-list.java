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
    public ListNode rotateRight(ListNode head, int k) { // O(n) & O(1)
        if(head == null || k == 0) return head;

        //1. locate tail at last and calculate length of list
        ListNode tail = head;
        int len = 1;

        while(tail.next != null) { // *tail.next bz we want a last node as tail...
            len++;
            tail = tail.next;
        }

        if(k % len == 0) { // as there is no change
            return head;
        }

        // 2. for large list length, we need to take it modulo
        k = k % len;

        // 3. pointers arrangement
        tail.next = head; // attach tail to head
        ListNode newLastNode = findNthNode(head, len - k); // remember: len - k th node we need to find

        head = newLastNode.next; // if forgot - see video or dry run it...
        newLastNode.next = null;

        return head;
    }

    public static ListNode findNthNode(ListNode temp, int k) {
        int cnt = 1;

        while(temp != null) {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }

        return temp;

    }
    
}