class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] hash = new int[256];
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1, cnt = 0;

        for(int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while(r < n) {
            if(hash[s.charAt(r)] > 0) cnt = cnt + 1;
            hash[s.charAt(r)]--;

            while(cnt == m) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIdx = l;
                }

                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) cnt--;
                
                l++;
            }

            r++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx+minLen);
    }
}