class Solution {
    public int characterReplacement(String s, int k) {
        // // Method1: Brute TLE O(n2)
        // int n = s.length();
        // int maxLen = 0;

        // for(int i = 0; i < n; i++) {
        //     int[] hash = new int[26];
        //     int maxFreq = 0;

        //     for(int j = i; j < n; j++) {
        //         hash[s.charAt(j) - 'A']++;
        //         maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

        //         int changes = (j - i + 1) - maxFreq;
        //         if(changes <= k) {
        //             maxLen = Math.max(maxLen, (j - i +1));
        //         } else {
        //             break;
        //         }
        //     }
        // }
        // return maxLen;

        // //Method2: Better O(2n) - not works ?? dont know why - may be issue in innner while loop
        // int n = s.length();
        // int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        // int hash[] = new int[26]; // to store freq...

        // while(r < n) {
        //     hash[s.charAt(r) - 'A']++;
        //     maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

        //     while((r - l + 1) - maxFreq > k) {
        //         hash[s.charAt(l) - 'A']--; 
        //         maxFreq = 0;
        //         for(int i = 0; i < 25; i++) {
        //             maxFreq = Math.max(maxFreq, hash[s.charAt(i)]);
        //             l = l + 1;
        //         }
        //     }

        //     if((r - l + 1) - maxFreq <= k) { // no need to put condition
        //         maxLen = Math.max(maxLen, r - l + 1);
        //         r++;
        //     }
        // }

        // return maxLen;

        //Method3: Optimal - O(n) & O(26)

        int n = s.length();
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int hash[] = new int[26]; // freq

        while(r < n) {
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k) { // remember condition
                hash[s.charAt(l) - 'A']--;
                l = l + 1;
            }

            maxLen = Math.max(maxLen, (r - l + 1));

            r = r + 1;
        }

        return maxLen;




    }
}