class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(nums1[i]);
        }

        int cnt = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            if(set.contains(nums2[i])) {
                cnt++;
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int ans[] = new int[res.size()];
        for(int i= 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}