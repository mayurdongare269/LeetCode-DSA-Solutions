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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res, 0);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res, int level) {
        if(root == null) {
            return;
        }

        if(level == res.size()) {
            res.add(root.val);
        }

        inorder(root.right, res, level+1); // as right view hence first move right..if left view then left
        inorder(root.left, res, level+1); // then left
    }
}