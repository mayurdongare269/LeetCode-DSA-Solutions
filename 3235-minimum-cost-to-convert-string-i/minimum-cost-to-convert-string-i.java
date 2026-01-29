class Solution {

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        // adjacency matrix for 26 lowercase letters
        long[][] adjMatrix = new long[26][26];

        // initialize with INF
        for (int i = 0; i < 26; i++) {
            Arrays.fill(adjMatrix[i], Long.MAX_VALUE);
            adjMatrix[i][i] = 0; // cost to convert char to itself
        }

        // build initial edges
        for (int i = 0; i < original.length; i++) {
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            adjMatrix[s][t] = Math.min(adjMatrix[s][t], cost[i]);
        }

        // Floyd-Warshall
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {

                    if (adjMatrix[i][k] == Long.MAX_VALUE ||
                        adjMatrix[k][j] == Long.MAX_VALUE) {
                        continue;
                    }

                    adjMatrix[i][j] =
                        Math.min(adjMatrix[i][j],
                                 adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        // calculate answer
        long ans = 0;

        for (int i = 0; i < source.length(); i++) {

            char sChar = source.charAt(i);
            char tChar = target.charAt(i);

            if (sChar == tChar) continue;

            long minCost = adjMatrix[sChar - 'a'][tChar - 'a'];

            if (minCost == Long.MAX_VALUE) {
                return -1;
            }

            ans += minCost;
        }

        return ans;
    }
}