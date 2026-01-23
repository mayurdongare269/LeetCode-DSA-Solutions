import java.util.*;

class Solution {

    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    private void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new Edge(f[0], f[1], f[2]));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS levels = stops
        for (int i = 0; i <= k; i++) {
            int[] temp = dist.clone();

            for (EdgeListNode node : getEdges(graph)) {
                int u = node.u;
                int v = node.v;
                int wt = node.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < temp[v]) {
                    temp[v] = dist[u] + wt;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // Helper to flatten graph edges
    static class EdgeListNode {
        int u, v, wt;
        EdgeListNode(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    private List<EdgeListNode> getEdges(ArrayList<Edge>[] graph) {
        List<EdgeListNode> list = new ArrayList<>();
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                list.add(new EdgeListNode(e.src, e.dest, e.wt));
            }
        }
        return list;
    }
}
