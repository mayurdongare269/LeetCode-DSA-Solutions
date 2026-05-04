class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //1. transpose
        for(int i = 0; i < n - 1; i++) { // 0 -> n-1
            for(int j = i+1; j < n; j++) { // i+1 -> n
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse
        for(int i = 0; i < n; i++) {
            int l = 0; 
            int r = n - 1;
            while(l < r) {
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;

                l++;
                r--;
            }
        }
    }
}