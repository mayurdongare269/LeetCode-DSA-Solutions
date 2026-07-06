/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // List<Integer> result = new ArrayList<>();
        // inorder(root, result);
        // return result;

        // // M-2: Iterative - not for pre & post
        // Stack<TreeNode> st = new Stack<>();
        // List<Integer> res = new ArrayList<>();
        // TreeNode node = root;

        // while(true) {
        //     if(node != null) {
        //         st.push(node);
        //         node = node.left;
        //     } else {
        //         if(st.isEmpty()) {
        //             break; // ends the looop
        //         }

        //         node = st.pop();
        //         res.add(node.val);
        //         node = node.right;
        //     }
        // }

        // return res;


        // M-3: Morris Inorder Traversal TC: O(2n) SC: O(1) - for preorder also,not for post
        ArrayList<Integer> res  = new ArrayList<>();
        TreeNode cur = root;

        while(cur != null) {
            if(cur.left == null) { // no left so add its root
                res.add(cur.val);
                cur = cur.right;
            } else {
                //if left child is not null
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if(prev.right == null) { 
                    prev.right = cur; // attach the thread and go left.. see video if forgot
                    cur = cur.left;
                } else { // if already thread exists, then remove and add in res
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return res;

    }

    //M-1 Recursion
    private void inorder(TreeNode root, List<Integer> result) {
        if(root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}