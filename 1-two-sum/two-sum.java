class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if(map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
       }

       return new int[]{-1, -1};

    // M1: Brute force
    // int n = nums.length;

    // for(int i = 0; i <= n - 1; i++) {
    //     for(int j = i + 1; j <= n - 1; j++) {
    //         if(nums[i] + nums[j] == target) {
    //             return new int[]{i, j};
    //         }
    //     }
    // }
    //  return new int[]{-1, -1};

        
    // }



    // M3: but arr must sorted -> For LeetCode 1 (Two Sum), you CANNOT simply sort the array because the question asks you to return the original indices.
    // Arrays.sort(nums);
    // int left = 0;
    // int right = nums.length - 1;

    // while(left < right) {
    //     int mid = left + (right - left) / 2;

    //     if(nums[left] + nums[right] == target) {
    //         return new int[left, right];
    //     } else if()

    
    }
}