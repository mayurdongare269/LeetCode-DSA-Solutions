class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Required because duplicate skipping logic
        // works only when duplicates are adjacent
        Arrays.sort(nums);

        List<List<Integer>> ansList = new ArrayList<>();

        // Start recursion from index 0
        // Pass empty subset initially
        findSubsets(0, nums, new ArrayList<>(), ansList);

        return ansList;
    }

    public void findSubsets(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {

        ansList.add(new ArrayList<>(ds)); //imp

        for(int i = idx; i < nums.length; i++) {

            // =================================================
            // Skip Duplicates
            // =================================================
            //
            // Example:
            // nums = [1,2,2]
            //
            // At same recursion level:
            //
            // i=1 -> pick first 2
            // i=2 -> skip second 2
            //
            // Prevents duplicate subsets.
            //
            // =================================================

            if(i != idx && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pick current element
            ds.add(nums[i]);

            // Move to next index
            findSubsets(i + 1, nums, ds, ansList);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}