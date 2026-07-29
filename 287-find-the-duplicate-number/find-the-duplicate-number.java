class Solution {
    public int findDuplicate(int[] nums) {
        //MI: Optimal TC: (n) SC: (1)
        //  int slow = nums[0];
        //  int fast = nums[0];

        // do {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // } while(slow != fast);

        // fast = nums[0];

        // while(slow != fast){
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }

        // return slow;


        //MII: better TC: (n) SC: (n)
        int n = nums.length;
        int[] freq = new int[n+1];

        for(int i = 0; i < n; i++) {
            if(freq[nums[i]] == 0) {
                freq[nums[i]]++;
            } else {
                return nums[i];
            }
        }

        return 0;
    }
}