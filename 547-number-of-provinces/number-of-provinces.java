class Solution {

    private void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true;

        // Check all cities connected to current city
        for (int nextCity = 0; nextCity < isConnected.length; nextCity++) {

            if (isConnected[city][nextCity] == 1 &&
                !visited[nextCity]) {

                dfs(nextCity, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int city = 0; city < n; city++) {

            if (!visited[city]) {

                provinces++;

                dfs(city, isConnected, visited);
            }
        }

        return provinces;
    }
}