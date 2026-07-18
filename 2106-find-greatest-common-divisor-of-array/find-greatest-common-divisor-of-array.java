class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num < small) {
                small = num;
            } 
            if(num > large) {
                large = num;
            }
        }

        return findGCD(small, large);
    }

    private int findGCD(int a, int b) {
        while(a > 0 && b > 0) {
            if(b > a) {
                b = b % a;
            }
            else {
                a = a % b;
            }
        }

        if(a == 0) return b;

        return a; 
    }
}

// private int gcd(int a, int b) {

//     while(b != 0) {
//         int temp = b;
//         b = a % b;
//         a = temp;
//     }

//     return a;
// }