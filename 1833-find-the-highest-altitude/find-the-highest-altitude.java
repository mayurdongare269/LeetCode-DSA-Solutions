class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] pref = new int[n+1];
        pref[0] = 0;

        for(int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + gain[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n+1; i++) {
            max = Math.max(max, pref[i]);
        }

        return max;
    }
}