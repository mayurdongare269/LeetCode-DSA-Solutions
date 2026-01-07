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
class Solution { // done but cppped

    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // First DFS to compute total sum
        totalSum = getTotalSum(root);

        // Second DFS to compute subtree sums and max product
        computeSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum of tree
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // DFS to compute subtree sums and update max product
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subSum = node.val + leftSum + rightSum;

        // product if we cut above this subtree
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
