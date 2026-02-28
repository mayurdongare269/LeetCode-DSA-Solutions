class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        for(int right = 0; right < n; right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

        // // Method-2
        // int n = s.length();
        // int[] hash = new int[256];
        // Arrays.fill(hash, -1);

        // int l = 0, r = 0, maxLen = 0;

        // while(r < n) {
        //     if(hash[s.charAt(r)] != -1) { // in the map 
        //         if(hash[s.charAt(r)] >= l) {
        //             l = Math.max(hash[s.charAt(r)] + 1, l);
        //         }
        //     }
        //     int len = r - l + 1;
        //     maxLen = Math.max(len, maxLen);

        //     hash[s.charAt(r)] = r;
        //     r++;
        // }

        // return maxLen;
    }
}