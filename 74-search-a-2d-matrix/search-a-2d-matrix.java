class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // Number of rows
        int n = matrix[0].length;// Number of col

        int left = 0, right = m * n - 1; // Total elements = m*n, last valid index = (m*n - 1)

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // mid / n == row and mid % n == colom
            int midElm = matrix[mid / n][mid % n]; // Convert 1D index to 2D

            if(midElm == target) {
                return true;
            } else if(midElm < target) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }

        return false;
    }
}