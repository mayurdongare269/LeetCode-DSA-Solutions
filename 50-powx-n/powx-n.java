class Solution {
    public double myPow(double x, int n) {

        //M-I : TLE

        // // Base case: any number to the power of 0 is 1
        // if (n == 0 || x == 1.0) return 1; 
        
        // long temp = n; // to avoid integer overflow
        
        // // Handle negative exponents
        // if (n < 0) {
        //     x = 1 / x;
        //     temp = -1L * n; // Convert negative exponent to positive using long to avoid overflow for Integer.MIN_VALUE
        // }

        // double ans = 1;

        // for (long i = 0; i < temp; i++) {
        //     ans *= x; 
        // }
        // return ans;

        // M-II: optimal

        double ans = 1.0;
        long nn = n;

        if(nn < 0) nn = -1 * nn;

        while(nn > 0) {
            if(nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }

        // for -ve n
        if(n < 0) ans = (double)(1.0) / (double) (ans);

        return ans;
    }
}