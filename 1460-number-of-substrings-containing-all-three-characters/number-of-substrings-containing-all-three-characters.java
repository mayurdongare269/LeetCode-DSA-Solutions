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

            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
                cnt = cnt + (1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2])));
            }
        }

        return cnt;
    }
}