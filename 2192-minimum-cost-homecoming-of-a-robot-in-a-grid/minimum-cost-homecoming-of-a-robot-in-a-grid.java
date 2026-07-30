class Solution { // TC; O(|r2 − r1| + |c2 − c1|) && SC: O(1)
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int r1 = startPos[0];
        int c1 = startPos[1];

        int r2 = homePos[0];
        int c2 = homePos[1];

        int result = 0;

        // Move in Rows
        if (r2 >= r1) {
            // Moving Down
            for (int r = r1 + 1; r <= r2; r++) {
                result += rowCosts[r];
            }
        } else {
            // Moving Up
            for (int r = r1 - 1; r >= r2; r--) {
                result += rowCosts[r];
            }
        }

        // Move in Columns
        if (c2 >= c1) {
            // Moving Right
            for (int c = c1 + 1; c <= c2; c++) {
                result += colCosts[c];
            }
        } else {
            // Moving Left
            for (int c = c1 - 1; c >= c2; c--) {
                result += colCosts[c];
            }
        }

        return result;
    }
}