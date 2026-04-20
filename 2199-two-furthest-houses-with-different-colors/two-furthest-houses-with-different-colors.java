class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        int n = colors.length;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(colors[i] != colors[j]) {
                    int diff = Math.abs(j-i);
                    max = Math.max(diff, max);
                }
            }
        }

        return max;
    }
}