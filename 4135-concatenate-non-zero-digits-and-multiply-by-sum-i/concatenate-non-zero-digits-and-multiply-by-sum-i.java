class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int temp = n;

        while(temp != 0) {
            int last = temp % 10;
            if(last != 0) {
                x = (x * 10) + last;
            }
            temp /= 10;
        } 

        long num = reverse(x);

        long sum = 0;

        while(num > 0) {
            long last = num % 10;
            sum += last;
            num /= 10;
        }

        return sum * reverse(x);
    }

    public int reverse(int n) {
        int temp = n;
        int rev = 0;

        while(temp > 0) {
            int last = temp % 10;
            rev = (rev * 10) + last;
            temp /= 10;
        }

        return rev;
    }
}