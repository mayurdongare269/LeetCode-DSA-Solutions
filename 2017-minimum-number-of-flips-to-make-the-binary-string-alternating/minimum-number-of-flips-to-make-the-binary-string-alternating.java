class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < ss.length(); i++) {

            char c = ss.charAt(i);

            if(c != (i % 2 == 0 ? '0' : '1')) diff1++;
            if(c != (i % 2 == 0 ? '1' : '0')) diff2++;

            if(i >= n) {
                char prev = ss.charAt(i - n);

                if(prev != ((i-n) % 2 == 0 ? '0' : '1')) diff1--;
                if(prev != ((i-n) % 2 == 0 ? '1' : '0')) diff2--;
            }

            if(i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}