class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //method1: Optimal : TC: O(2K) & O(1)
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        int maxSum = 0;

        for(int i = 0; i < k; i++) { // <k
            lsum = lsum + cardPoints[i];
        }

        maxSum = lsum;
        int rightIdx = n - 1;
        for(int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rightIdx];
            rightIdx = rightIdx - 1;

            maxSum = Math.max(maxSum, lsum+rsum);
        }

        return maxSum;
    }
}