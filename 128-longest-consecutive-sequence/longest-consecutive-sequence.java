class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 0) return 0;

        HashSet<Integer> st = new HashSet<>();
        int longest = 1; // 1

        for(int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        for(int it : st) { // here loop on set, not on nums....**********
            if(!st.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while(st.contains(x+1)) {
                    cnt++;
                    x++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}