class Solution {// done .. solved ...
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        long sum = 0;
        long Ncount = 0;

        long min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum += Math.abs(matrix[i][j]);
                

                min = Math.min(min, Math.abs(matrix[i][j]));

                if(matrix[i][j] < 0) {
                    Ncount++;
                }
            }
        }

        if(Ncount % 2 == 0) {
            return sum;
        }

        return sum - min - min;
    }
}