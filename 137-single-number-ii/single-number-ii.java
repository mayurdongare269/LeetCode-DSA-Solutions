class Solution {
    public int singleNumber(int[] nums) { // there are 4 approaches using bitmanipulation
        //M3: Optimal approach..using logic
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 1; i < n; i += 3) {
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }

        return nums[n-1];
    }
}