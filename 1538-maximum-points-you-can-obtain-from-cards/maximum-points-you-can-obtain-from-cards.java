class Solution {
    public int maxScore(int[] cardPoints, int k) { // easy one 
        int n = cardPoints.length;
        int lSum = 0, maxSum = 0;

        for(int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum; // initialize  with lSum
        int rSum = 0;
        int rightIdx = n - 1;

        for(int i = k - 1; i >= 0; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[rightIdx];
            rightIdx = rightIdx - 1;

            maxSum = Math.max(maxSum, (lSum + rSum));
        }

        return maxSum;
    }
}