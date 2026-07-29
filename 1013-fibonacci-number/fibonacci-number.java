class Solution {
    public int fib(int n) { 
        //M-I: Recursive ->  TC: O(n2) SC: O(n)
        // if (n == 0) return 0;  // base case
        // if (n == 1) return 1;  // base case

        // return fib(n - 1) + fib(n - 2);

        //MII: iterative ->  O(N) O(1)
        if(n == 0) return 0;
        if (n == 1) return 1;

        int first = 0;
        int second = 1;

        for(int i = 2; i <= n; i++) {
            int cur = first + second;
            first = second;
            second = cur;
        }

        return second;

    }
}