class Solution { //sliding window not possible!!!
    public boolean checkSubarraySum(int[] nums, int k) { 
        //see video if forgot!!! -> // codewithmic video..

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // to store remainder & index
        map.put(0, -1); //edge case

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if(map.containsKey(remainder)) { // if its present in map or not (past madhe present aahe ka te bagh)
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