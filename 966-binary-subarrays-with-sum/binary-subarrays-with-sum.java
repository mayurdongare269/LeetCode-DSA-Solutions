class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Method1: Brute O(n2)
        int n = nums.length;
        int cnt = 0;
        
        for(int i = 0;  i<n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];

                if(sum == goal) cnt++;
            }
        }
        
        return cnt;

        // //method2: Better O(n) & O(n)
        // int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // map.put(0, 1); // most imp

        // int ans = 0;
        // int sum = 0;
        
        // for(int i = 0; i < n; i++) {
        //     sum += nums[i];

        //     if(map.containsKey(sum - goal)) {
        //         ans += map.get(sum - goal);
        //     }

        //     map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }

        // return ans;
    }
}