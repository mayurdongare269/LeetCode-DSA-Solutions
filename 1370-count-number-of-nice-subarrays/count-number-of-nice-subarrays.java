class Solution {
    public int numberOfSubarrays(int[] nums, int k) { // same as lt 930
        return helper(nums, k) - helper(nums, k-1);
    }
    //MI:
    public int helper(int[] nums, int goal) {
        if(goal < 0) return 0; // bz of goal - 1...
        
        int n = nums.length;
        int l = 0, r = 0, cnt = 0, sum = 0;

        while(r < n) {
            sum += nums[r] % 2; // changes in 930 -> sir directly modify arr 

            while(sum > goal) {
                sum -= nums[l] % 2; // changes in 930
                l++;
            }

            cnt = cnt + (r-l+1);
            r++;
        }

        return cnt;
    }

    //M-II
    // public int helper(int[] nums, int k) {
    //     if(k < 0) return 0; // bz of k - 1 ..

    //     int l = 0, r = 0;
    //     int n = nums.length;
    //     int ans = 0, cntOdd = 0;

    //     while(r < n) {
    //         if(nums[r] % 2 != 0) { // changes in 930
    //             cntOdd++;
    //         }

    //         while(cntOdd > k) {
    //             if(nums[l] % 2 != 0){ // changes in 930
    //                 cntOdd--;
    //             }
    //             l = l + 1;
    //         }

    //         ans = ans + (r - l + 1);
    //         r++;
    //     } 

    //     return ans;
    // }
}