class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            minDiff = Math.min(diff, minDiff);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            int d = Math.abs(arr[i] - arr[i-1]);
            if(d == minDiff) {
                // ans.add(arr[i-1], arr[i]);
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }

        return ans;
    }
}