import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minimumPushes(String word) {

        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort in descending order of frequency
        Arrays.sort(freq, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int press = (i / 8) + 1;
            result += press * freq[i];
        }

        return result;
    }
}