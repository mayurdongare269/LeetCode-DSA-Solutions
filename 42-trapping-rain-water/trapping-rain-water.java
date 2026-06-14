class Solution {
    public int trap(int[] height) {
        //M-I: Apna Clg
        int n = height.length;

        // cal the leftmax
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i-1], height[i]);
        }

        // cal the rightmax
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        int TP = 0; int width = 1;
        for(int i = 0; i < n; i++) {
            //cal the waterlevel
            int waterlevel = Math.min(rightmax[i], leftmax[i]);
            //cal TrappedWater
            TP += (waterlevel - height[i])*width;
        }

        return TP;
    }
}