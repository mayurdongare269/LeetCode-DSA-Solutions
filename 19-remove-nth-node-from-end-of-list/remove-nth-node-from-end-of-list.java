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
        if(head == null) return null;

        ListNode temp = head;
        int cnt = 0;

        while(temp != null) {
            cnt++;
            temp = temp.next;
        }

        if(cnt == n) { // if n is as tot length, so we need to remove head
            return head.next; // return so that below code never runs
        }

        int len = cnt - n; // as we need to reach the 1 node previous of the target node so this formula used -> do dry run if any doubt
        temp = head;

        while(temp != null) {
            len--;
            if(len == 0) {
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}