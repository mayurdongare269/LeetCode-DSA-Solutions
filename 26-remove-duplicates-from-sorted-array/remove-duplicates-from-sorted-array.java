class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int i = 0;
        for(int j = 1; j < n; j++) {
            if(nums[j] != nums[i]) {
                i++; // here inc bz -> first value is always as it is we just need to modify from idx 1 so idx 0 must be as it is...
                nums[i] = nums[j];
            }
        }

        return i + 1;

        // //for arr 
        // int length = i + 1;

        // //Print only unique elements
        // for(int k = 0; k < length; k++) {
        //     System.out.print(nums[k] + " ");
        // }

        // return length;
    }
}