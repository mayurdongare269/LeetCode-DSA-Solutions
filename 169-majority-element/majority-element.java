class Solution {
    // mayur dongare
    public int majorityElement(int[] nums) {
        // int count = 0;
        // int candidate = 0;

        // for (int num : nums) {
        //     if (count == 0) {
        //         candidate = num;
        //     }
        //     count += (num == candidate) ? 1 : -1;
        // }

        // return candidate;
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n/2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
