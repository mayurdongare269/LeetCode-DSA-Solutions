class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;

        // int diff = Math.abs(n - k);

        int start = Math.max(1, n - k);
        int end = (n + k);

        for(int i = start; i <= end; i++) { // i === x
            int diff = Math.abs(n - i);
            if(diff <= k && ((n & i) == 0)) {
                sum += i;
            }
        }

        return sum;
    }
    
}