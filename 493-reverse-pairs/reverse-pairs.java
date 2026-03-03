class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    public static int mergeSort(int[] nums, int si, int ei) {
        int cnt = 0;
        if(si >= ei) {
            return cnt;
        }

        int mid = si + (ei - si) / 2;

        cnt += mergeSort(nums, si, mid); // left half
        cnt += mergeSort(nums, mid+1, ei); // right half
        cnt += countPairs(nums, si, mid, ei); // modifications

        merge(nums, si, mid, ei);
        return cnt;
    }

    public static int countPairs(int[] nums, int si, int mid, int ei) {
        int cnt = 0;
        int right = mid + 1;

        for(int i = si; i <= mid; i++) {
            while(right <= ei && (long)nums[i] > 2L * nums[right]) right++;
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    public static void merge(int[] nums, int si, int mid, int ei) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = si;
        int j = mid + 1;

        while(i <= mid && j <= ei) {
            if(nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        while(i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while(j <= ei)  {
            temp.add(nums[j]);
            j++;
        }

        for(i = si; i <= ei; i++) {
            nums[i] = temp.get(i - si);
        }
    }
}