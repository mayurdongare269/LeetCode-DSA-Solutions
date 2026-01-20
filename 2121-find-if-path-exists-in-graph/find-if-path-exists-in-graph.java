class Solution { // done graph que
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Create adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Build graph (bi-directional)
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // Step 3: DFS
        boolean[] vis = new boolean[n];
        return dfs(graph, source, destination, vis);



        // boolean vis[] = new boolean[n];

        // for(int i = 0; i < n; i++) {
        //     if(!vis[i]) {
        //         if(dfs(n, edges, i, destination, vis)) {
        //             return true;
        //         }
        //     }
        // }

        // return false;
    }

    public boolean dfs(ArrayList<Integer> graph[], int src, int dest, boolean vis[]) {
        if(src == dest) return true;

        vis[src] = true;

        for(int i = 0; i < graph[src].size(); i++) {
            int e = graph[src].get(i);

            if(!vis[e]) {
                if(dfs(graph, e, dest, vis)) {
                    return true;
                }
            }
        } 

        return false;
    }
}