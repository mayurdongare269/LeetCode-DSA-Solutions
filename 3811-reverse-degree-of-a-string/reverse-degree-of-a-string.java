class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            int revVal = 'z' - s.charAt(i) + 1;
            int idx = i+1;

            sum += revVal * idx;
        }

        return sum;
    }
}