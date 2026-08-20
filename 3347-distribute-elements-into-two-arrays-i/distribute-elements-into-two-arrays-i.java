class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int n1 = 0;
        int n2 = 0;

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        arr1[0] = nums[0];
        n1++;
        arr2[0] = nums[1];
        n2++;

        for(int i = 2; i < n; i++) {
            if(arr1[n1-1] > arr2[n2-1]) {
                arr1[n1] = nums[i];
                n1++;
            } else {
                arr2[n2] = nums[i];
                n2++;
            }
        }

        int ans[] = new int[n];
        int n3 = 0;
        for(int i = 0; i < n1; i++) {
            ans[n3] = arr1[i];
            n3++;
        }

        for(int i = 0; i < n2; i++) {
            ans[n3] = arr2[i];
            n3++;
        }

        return ans;

        // return new int[]{arr1, arr2};
    }
}