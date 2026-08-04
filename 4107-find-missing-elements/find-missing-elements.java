class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            small = Math.min(small, num);
            large = Math.max(large, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = small; i <= large; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}