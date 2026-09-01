class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] freq = new int[26];

        for(int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int l = 0, r = 0;
        
        while(r < m) {
            freq[s2.charAt(r) - 'a']--;

            while((r - l + 1) == n) {
                if(isNonZero(freq)) {
                    return true;
                }

                freq[s2.charAt(l) - 'a']++;
                l++;
            }

            r++;
        }

        return false;
    }

    private boolean isNonZero(int[] freq) {
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}