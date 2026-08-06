class Solution { //sliding window not possible!!!
    public boolean checkSubarraySum(int[] nums, int k) { 
        //see video if forgot!!! -> // codewithmic video..

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) >= 2) {
                    return true;
                } 
            } else { //imp..add in map
                map.put(remainder, i);
            }
        }

        return false;
    }
}