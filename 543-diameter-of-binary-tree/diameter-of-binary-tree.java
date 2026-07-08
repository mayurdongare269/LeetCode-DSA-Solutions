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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diam - 1;
    }

    public class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public Info diameter(TreeNode root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info lInfo = diameter(root.left);
        Info rInfo = diameter(root.right);

        int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht+rInfo.ht+1);
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;

        return new Info(diam, ht);
    }


}