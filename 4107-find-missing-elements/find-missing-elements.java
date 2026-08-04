class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int small = nums[0];
        int large = nums[n-1];

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int[] freq = new int[n];
        for(int num : nums) {
            set.add(num);
        }

        for(int i = small; i <= large; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}