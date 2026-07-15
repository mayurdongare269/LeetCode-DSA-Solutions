class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = 0;
        int oddSum = 0;
        
        for(int i = 1; i <= n; i++) {
            oddSum += (2*i - 1);
            evenSum += 2*i;
        }

        return GCD(oddSum, evenSum);

// Sum of first n odd numbers = n²
// Sum of first n even numbers = n(n+1)
    }

    public int GCD(int a, int b) {
        while(a > 0 && b > 0) {
            if(a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        
        if(a == 0) {
            return b;
        } 

        return a;
    }

    public int gcd2(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
}