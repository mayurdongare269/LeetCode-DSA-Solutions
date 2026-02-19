class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];

        //method 2 ...

        // int n = nums.length;

        // // store value + original index
        // int[][] arr = new int[n][2];
        // for (int i = 0; i < n; i++) {
        //     arr[i][0] = nums[i]; // value
        //     arr[i][1] = i;       // original index
        // }

        // // sort by value
        // Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        // // or Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // int l = 0, r = n - 1;

        // while (l < r) {
        //     int sum = arr[l][0] + arr[r][0];

        //     if (sum == target) {
        //         return new int[]{arr[l][1], arr[r][1]};
        //     } else if (sum < target) {
        //         l++;
        //     } else {
        //         r--;
        //     }
        // }

        // return new int[0];
    }
}