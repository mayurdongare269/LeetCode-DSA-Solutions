class Solution {
    public int numberOfSubarrays(int[] nums, int k) { // same as lt 930
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int[] nums, int k) {
        if(k < 0) return 0; // bz of k - 1 ..

        int l = 0, r = 0;
        int n = nums.length;
        int ans = 0, cntOdd = 0;

        while(r < n) {
            if(nums[r] % 2 != 0) {
                cntOdd++;
            }

            while(cntOdd > k) {
                if(nums[l] % 2 != 0){
                    cntOdd--;
                }
                l = l + 1;
            }

            ans = ans + (r - l + 1);
            r++;
        } 

        return ans;
    }
}