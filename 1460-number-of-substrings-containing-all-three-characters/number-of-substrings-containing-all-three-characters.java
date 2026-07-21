class Solution {
    public int numberOfSubstrings(String s) {
        // //method1: Brute
        // int n = s.length();
        // int cnt = 0;

        // for(int i = 0; i < n; i++) {
        //     int[] freq = new int[3];
        //     for(int j = i; j < n; j++) {
        //         // freq[s.charAt(i) - 'a'] = 1;
        //         freq[s.charAt(j) - 'a']++;

        //         if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
        //             // cnt += 1;
        //             cnt = cnt + (n - j);
        //             break;
        //         }
        //     }
        // }

        // return cnt;

        //Optimal: O(n) & o(1) - window solution .. for 2 pointer & sliding see striver sheet
        int n = s.length();
        int[] lastseen = {-1, -1, -1};
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            lastseen[s.charAt(i) - 'a'] = i;

            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) { // here no need if condi but for understanding written
                cnt = cnt + (1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2])));
            }
        }

        return cnt;


        //method3: Optimal - sliding
        //  // Frequency array for 'a', 'b', 'c'
        // int[] freq = new int[3];

        // // Left pointer for the sliding window
        // int left = 0;

        // // Result variable to store count of valid substrings
        // int res = 0;

        // // Traverse the string with right pointer
        // for (int right = 0; right < s.length(); right++) {
        //     // Increment frequency of current character
        //     freq[s.charAt(right) - 'a']++;

        //     // Shrink the window from the left while all characters are present
        //     while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
        //         // Count substrings from current right to end
        //         res += (s.length() - right);

        //         // Move left pointer and update frequency
        //         freq[s.charAt(left) - 'a']--;
        //         left++;
        //     }
        // }

        // return res;
    }
}