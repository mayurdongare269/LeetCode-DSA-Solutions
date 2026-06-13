/*
 // Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // =========================================================
    // BRUTE FORCE APPROACH (Using HashMap)
    // =========================================================
    //
    // Idea:
    // 1. Create a copy node for every original node.
    // 2. Store mapping:
    //      originalNode -> copyNode
    // 3. Traverse again and connect:
    //      copy.next = map.get(original.next)
    //      copy.random = map.get(original.random)
    //
    // TC: O(N)
    // SC: O(N)
    //
    // =========================================================

    /*
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        // Create copy nodes
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        // Connect next and random pointers
        while(temp != null) {

            Node copyNode = map.get(temp);

            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
    */


    // =========================================================
    // OPTIMAL APPROACH (No HashMap)
    // =========================================================
    //
    // Step 1: Insert copy nodes in between
    // Original:
    // 7 -> 13 -> 11
    //
    // After insertion:
    // 7 -> 7' -> 13 -> 13' -> 11 -> 11'
    //
    // Step 2: Connect random pointers
    //
    // If:
    // original.random = X
    //
    // Then:
    // copy.random = X.next
    //
    // Because copied node is always present
    // immediately after original node.
    //
    // Step 3: Separate original and copied list.
    //
    // TC: O(N)
    // SC: O(1)
    //
    // =========================================================


    // Step 1: Insert copied nodes in between
    private void insertCopyInBetween(Node head) {

        Node temp = head;

        while(temp != null) {

            Node nextElement = temp.next;

            Node copy = new Node(temp.val);

            copy.next = nextElement;
            temp.next = copy;

            temp = nextElement;
        }
    }


    // Step 2: Connect random pointers
    private void connectRandomPointers(Node head) {

        Node temp = head;

        while(temp != null) {

            Node copyNode = temp.next;

            if(temp.random != null) {
                copyNode.random = temp.random.next;
            }
            else {
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }


    // Step 3: Extract copied list and restore original list
    private Node getDeepCopyList(Node head) {

        Node temp = head;

        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while(temp != null) {

            // Add copied node to new list
            res.next = temp.next;
            res = res.next;

            // Restore original list
            temp.next = temp.next.next;

            temp = temp.next;
        }

        return dummyNode.next;
    }


    public Node copyRandomList(Node head) {

        if(head == null) return null;

        // Step 1
        insertCopyInBetween(head);

        // Step 2
        connectRandomPointers(head);

        // Step 3
        return getDeepCopyList(head);
    }
}