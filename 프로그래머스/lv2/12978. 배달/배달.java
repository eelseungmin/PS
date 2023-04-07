import java.util.*;

class Solution {
    static int[] dist;
    static ArrayList<ArrayList<Edge>> edges;
    
    public int solution(int N, int[][] road, int K) {
        dist = new int[N + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < road.length; i++) {
            edges.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            edges.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }
        
        dijkstra(1);
        
        int ans = 0; // 정답
        for (int d : dist) {
            if (d <= K) {
                ans++;                
            }
        }
        
        return ans;
    }
    
    class Edge implements Comparable<Edge> {
        int idx, cost;
        
        Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
    
    void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (cur.cost > dist[cur.idx]) {
                continue;
            }
            
            for (Edge e : edges.get(cur.idx)) {
                if (dist[cur.idx] + e.cost >= dist[e.idx]) {
                    continue;
                }
                
                dist[e.idx] = dist[cur.idx] + e.cost;
                pq.offer(new Edge(e.idx, dist[e.idx]));
            }
        }
    }
}