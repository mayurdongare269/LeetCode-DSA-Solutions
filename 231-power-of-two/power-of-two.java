class Solution {
    //Mayur Dongare
    public boolean isPowerOfTwo(int n) {
        //M-I
        if(n <= 0) return false;
        return (n & (n - 1)) == 0;

        //M-II =- good and easy to remember
        // if (n <= 0) return false;
        // while (n % 2 == 0) {
        //     n /= 2;
        // }
        // return n == 1;
    }
}