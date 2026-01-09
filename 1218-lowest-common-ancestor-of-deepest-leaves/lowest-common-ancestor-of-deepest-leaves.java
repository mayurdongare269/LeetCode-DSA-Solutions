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

     Map<Integer, Integer> dMap = new HashMap<>(); //  d == depth
    int maxD = 0;

    private void findD(TreeNode root, int d) {
        if(root == null) {
            return;
        }

        dMap.put(root.val, d);

        if(d > maxD) {
            maxD = d;
        }

        findD(root.left, d+1);
        findD(root.right, d+1);
    }

    //stp 2:
    private TreeNode findLCA(TreeNode root) {
        if(root == null) {
            return null;
        }

        if(dMap.get(root.val) == maxD) {
            return root;
        }

        TreeNode left = findLCA(root.left);
        TreeNode right = findLCA(root.right);

        if(left != null && right != null) {
            return root;
        }

        if(left != null) {
            return left;
        } else {
            return right;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Two pass approach

        //first DFS: cal depth
        findD(root, 0);

        // secoond DFS: find LCA of deepest nodes
        return findLCA(root);
    }
}