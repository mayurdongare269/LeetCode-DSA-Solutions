class Solution {
    public int subarraySum(int[] nums, int k) { // imp concept
        HashMap<Integer, Integer> map = new HashMap<>(); // prefix sum - see video for understanding
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            sum +=  nums[i];

            if(map.containsKey(sum - k)) {
                ans += map.get(sum - k); //means: How many times has (sum - k) appeared before .. so we add freq..
            }

            // or ans += map.getOrDefault((sum-k), 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;


        // run nahi hot... diff for +ve
        // int n = nums.length;

        // // To store the maximum length of the subarray
        // int maxLen = 0;

        // // Pointers for sliding window
        // int left = 0, right = 0;

        // // Sum of the current window
        // int sum = nums[0];

        // // Traverse through the array
        // while (right < n) {

        //     // Shrink the window if sum exceeds k
        //     while (left <= right && sum > k) {
        //         sum -= nums[left];
        //         left++;
        //     }

        //     // Update max length if sum equals k
        //     if (sum == k) {
        //         maxLen = Math.max(maxLen, right - left + 1);
        //     }

        //     // Expand the window to the right
        //     right++;
        //     if (right < n) {
        //         sum += nums[right];
        //     }
        // }

        // return maxLen;
    }
}