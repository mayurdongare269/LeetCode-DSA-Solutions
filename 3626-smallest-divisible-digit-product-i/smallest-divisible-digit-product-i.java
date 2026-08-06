class Solution {
    public int smallestNumber(int n, int t) {
        // int prod = 1;
        int ans = 0;

        while(n <= 100) { // if constrains dont know -> while(true)
            int dig = n;

            int prod = 1;
            while(dig > 0) {
                int last = dig % 10;
                prod *= last;
                dig /= 10;
            }

            if(prod % t == 0) {
                ans = n;
                break;
            }
            
            n++; //increase num
        }

        return ans;
    }
}