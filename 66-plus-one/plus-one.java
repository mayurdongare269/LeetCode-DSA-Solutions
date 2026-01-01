class Solution {//done
    public int[] plusOne(int[] digits) {
        // int n = digits.length;

        // if(digits[n-1] >= 0 && digits[n-1] <= 8) {
        //     digits[n-1]++;
        // } else {
            
        // }

        
        int n = digits.length;

        // Traverse from last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}