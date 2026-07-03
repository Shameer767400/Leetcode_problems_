import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            indegree[e[1]]++;
            set.add(e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        int idx = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (Edge e : graph[u]) {
                if (--indegree[e.to] == 0)
                    q.offer(e.to);
            }
        }

        if (set.isEmpty()) return -1;

        int[] vals = new int[set.size()];
        int p = 0;
        for (int x : set) vals[p++] = x;

        int lo = 0, hi = vals.length - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(vals[mid], graph, topo, online, k)) {
                ans = vals[mid];
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit,
                          List<Edge>[] graph,
                          int[] topo,
                          boolean[] online,
                          long k) {

        int n = online.length;
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (Edge e : graph[u]) {

                if (e.cost < limit) continue;

                int v = e.to;

                if (v != 0 && v != n - 1 && !online[v]) continue;

                if (dist[u] + e.cost < dist[v]) {
                    dist[v] = dist[u] + e.cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
