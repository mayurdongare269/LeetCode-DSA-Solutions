class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length; //row
        int m = matrix[0].length; //column

        int maxArea = 0; 
        int[][] prefSum = new int[n][m];

        //first calculate prefix sum
        for(int j = 0; j < m; j++) { // as we have to move top to bottom and complete 4 columns
            int sum = 0;
            for(int i = 0; i < n; i++) {
                // sum += matrix[i][j]; matrix is char hence this is not works we need to increase sum like below
                if(matrix[i][j] == '0') {
                    sum = 0;
                } else {
                    sum = sum + 1;
                }
                
                prefSum[i][j] = sum;
            }
        }

        // calculate the area row wise using largetHistogram 
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogram(prefSum[i])); // pass each row to function
        }

        return maxArea;
    }

    public int largestHistogram(int[] h) {
        int n = h.length;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && h[st.peek()] >= h[i]) {
                int element = st.pop();

                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;
                int area = h[element] * width;
                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int element = st.pop();

            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int width = nse - pse - 1;
            int area = h[element] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}