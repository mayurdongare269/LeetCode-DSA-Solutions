import java.util.Arrays;

class Solution {

    public void helper(int[][] image, int sr, int sc, int color,
                       boolean[][] vis, int orgCol) {

        // Boundary + visited + different color check
        if (sr < 0 || sc < 0 ||
            sr >= image.length || sc >= image[0].length ||
            vis[sr][sc] ||
            image[sr][sc] != orgCol) {

            return;
        }

        // Mark visited
        vis[sr][sc] = true;

        // Change color
        image[sr][sc] = color;

        // Left
        helper(image, sr, sc - 1, color, vis, orgCol);

        // Right
        helper(image, sr, sc + 1, color, vis, orgCol);

        // Up
        helper(image, sr - 1, sc, color, vis, orgCol);

        // Down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] vis =
            new boolean[image.length][image[0].length];

        int orgCol = image[sr][sc];

        helper(image, sr, sc, color, vis, orgCol);

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        Solution obj = new Solution();

        int[][] result = obj.floodFill(image, sr, sc, color);

        // Print result
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}