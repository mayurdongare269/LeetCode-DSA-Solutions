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
class Solution {  // done --- two appoaches : BFS & DFS ...

    // Method-II
    //.....
    /// Map to store sum of each level
    Map<Integer, Integer> map = new HashMap<>();

    // DFS traversal
    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        map.put(level, map.getOrDefault(level, 0) + root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {
        //Method-II

        map.clear();

        // start DFS from level 1
        dfs(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;

        // iterate over all levels
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = level;
            }
        }

        return resultLevel;





        // methode- I

        // Queue<TreeNode> que = new LinkedList<>();
        // que.add(root);

        // int Curr_level = 1;
        // int maxLevel = 1;
        // int maxSum = Integer.MIN_VALUE;

        // while(!que.isEmpty()) {
        //     int size = que.size();
        //     int sum = 0;

        //     for(int i = 0; i < size; i++) {
        //         TreeNode node = que.poll();
        //         sum += node.val;

        //         if(node.left != null) {
        //             que.add(node.left);
        //         }

        //         if(node.right != null) {
        //             que.add(node.right);
        //         }
        //     }

        //     if(sum > maxSum) {
        //         maxSum = sum;
        //         maxLevel = Curr_level;
        //     }
        //     Curr_level++;
        // }

        // return maxLevel;

    }
}