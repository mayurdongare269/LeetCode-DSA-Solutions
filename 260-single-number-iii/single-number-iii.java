class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        long xor = 0;

        for(int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        // int rightmost = (int)(xor & (xor-1)) & (int)xor;
        int rightmost = (int)(xor & -xor);

        int b1 = 0, b2 = 0;
        for(int i = 0; i < n; i++) {
            if((nums[i] & rightmost) != 0) {
                b1 = b1 ^ nums[i];
            }else {
                b2 = b2 ^ nums[i];
            }
        }

        if(b1 < b2) {
            return new int[]{b1, b2};
        } 
        return new int[]{b2, b1};
    }
}