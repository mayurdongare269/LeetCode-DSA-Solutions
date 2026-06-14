class Solution {
    public boolean checkGoodInteger(int n) { // contest que: date(14-06-26)
        int digSum = 0;
        int sqSum = 0;

        int temp = n;

        while(temp != 0) {
            int last = temp % 10;
            digSum += last;
            sqSum += last * last;
            temp /= 10;
        }

        int res = sqSum - digSum;
        if(res >= 50) {
            return true;
        } else {
            return false;
        }
    }
}