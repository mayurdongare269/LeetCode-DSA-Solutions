class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        int n = text.length();

        for(int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }

        // int min = Integer.MAX_VALUE;
        // for(int i = 0; i < n; i++) {
        //     min = Math.min(freq['b'], Math.min(freq['a'], ))
        // }

        return Math.min(
            Math.min(freq['b' - 'a'], freq['a' - 'a']),
            Math.min(
                Math.min(freq['l' - 'a']/ 2, freq['o' - 'a']/2),
                freq['n' - 'a']
            )
        );
    }
}