class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int start1 = 0; // 10101..
        int start0 = 0; // 010101...

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) { // even
                if(s.charAt(i) == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if(s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }

        return Math.min(start1, start0);
    }
}