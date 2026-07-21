class Solution {

    public int myAtoi(String s) {

        //M-I: strings but its take more memmory as new string created...
        // s = s.trim();

        // if (s.length() == 0)
        //     return 0;

        // int i = 0;
        // int sign = 1;

        // if (s.charAt(i) == '+' || s.charAt(i) == '-') {

        //     if (s.charAt(i) == '-')
        //         sign = -1;

        //     i++;
        // }

        // long num = 0;

        // while (i < s.length() && Character.isDigit(s.charAt(i))) { // i < s.length() - most imp***

        //     num = num * 10 + (s.charAt(i) - '0'); // convert to integer.. remember "num * 10"

        //     if (sign * num <= Integer.MIN_VALUE)
        //         return Integer.MIN_VALUE;

        //     if (sign * num >= Integer.MAX_VALUE)
        //         return Integer.MAX_VALUE;

        //     i++;
        // }

        // return (int) (sign * num);

        // M-II: using arr optimized
        char[] arr = s.toCharArray();

        int n = arr.length;
        if(n == 0) {
            return 0;
        }

        int i = 0;

        while(i < n && arr[i] == ' ') {
            i++;
        }

        if(i == n) { // if all whitespaces...
            return 0;
        }

        int sign = 1;

        if(arr[i] == '-' || arr[i] == '+') {
            if(arr[i] == '-') {
                sign = -1;
            }
            i++;
        }

        //loop for zeros but no need as it automaticaly handle in calculations

        long ans = 0;

        while(i < n && (arr[i] >= '0' && arr[i] <= '9')) { // add condition
            ans = ans * 10 + (arr[i] - '0'); // convert to int
            
            if(sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if(sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int) (sign * ans);  
        
    }
}