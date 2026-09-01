class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int n = s.length();

        int[] counter = new int[26];

        // Count the frequency of each character in p
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            counter[ch - 'a']++;
        }

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        int k = p.length();

        while (j < n) {

            counter[s.charAt(j) - 'a']--;

            if (j - i + 1 == k) {

                if (allZero(counter)) {
                    result.add(i);
                }

                counter[s.charAt(i) - 'a']++;
                i++;
            }

            j++;
        }

        return result;
    }

    private boolean allZero(int[] counter) {

        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }
}