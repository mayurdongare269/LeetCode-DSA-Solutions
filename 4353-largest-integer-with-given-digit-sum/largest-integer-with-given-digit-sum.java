class Solution {
    public int largestInteger(int n, int s) {
        if(s > 9 * n) {
            return -1; // as 9 * n is maximum sum 
        }

        if(s == 0) return 0;

        int res = 0;

        for(int i = 0; i < n; i++) {
            int digit = Math.min(9, s); // as max is 9 and we can put it at left side so that we can get maximum num
            res = res * 10 + digit;
            s -= digit;
        }

        return res;
    }
}