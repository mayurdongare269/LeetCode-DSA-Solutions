class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        int n = series1.length;
        int j = 0;
        int m = series2.length;

        while(i < n || j < m) {
            long t1 = (i < n) ? series1[i][0] : Long.MAX_VALUE;
            long t2 = (j < m) ? series2[j][0] : Long.MAX_VALUE;

            long curTimeStamp = Math.min(t1, t2);

            long val1 = 0;
            if(i < n) {
                val1 = series1[i][1];
                if(series1[i][0] == curTimeStamp) {
                    i++;
                }
            }

            long val2 = 0;
            if(j < m) {
                val2 = series2[j][1];
                if(series2[j][0] == curTimeStamp) {
                    j++;
                }
            }

            ans.add(Arrays.asList((int)curTimeStamp, (int) (val1 + val2)));
        }

        return ans;
    }
}