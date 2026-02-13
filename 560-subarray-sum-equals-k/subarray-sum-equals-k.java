class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            sum +=  nums[i];

            if(map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;


        // int left=0, sum=0;

        // for(int right=0; right<n; right++){
        //     sum += arr[right];

        //     while(sum > target){
        //         sum -= arr[left++];
        //     }

        //     if(sum == target){
        //         System.out.println("Found");
        //         return;
        //     }
        // }
    }
}