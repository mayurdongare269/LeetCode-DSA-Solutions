class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        boolean[] seen = new boolean[26];

        sentence = sentence.toLowerCase();

        for(int i = 0; i < n; i++) {
            int ch = sentence.charAt(i);

            seen[ch - 'a'] = true;
        }

        for(boolean b : seen) {
            if(!b) {
                return false;
            }
        }

        return true;
    }
}