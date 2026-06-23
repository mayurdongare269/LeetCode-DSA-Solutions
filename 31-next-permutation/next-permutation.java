class Solution {
    public void nextPermutation(int[] nums) {
        /* 3 steps..
        1. find the break point from right n-2
        2. find the bigger number  from right n - 1 and swap
        3. reverse from break idx
        */

        int n = nums.length;
        int idx = -1;
        //1. find the break point
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) { // if no break point ex: [3,2,1]
            reverse(nums, 0, n-1);
            return; // imp
        }

        //2. find the bigger number than idx
        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        } 

        //3. reverse from break idx
        reverse(nums, idx+1, n-1);
    }

    public void reverse(int nums[], int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}