class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        // int n = intervals.length;
        // int m = intervals[0].length;

        // int bulb = (brightness / 3);

        int bulb = (brightness + 2)/3;

        Arrays.sort(intervals, (a, b) -> Long.compare(a[0], b[0]));// sort by starting

        long totTime = 0;

        long start = intervals[0][0]; // start
        long end = intervals[0][1]; // end

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                totTime += end - start + 1;

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        totTime += end - start + 1;

        return totTime * bulb;

         
        
    }
}