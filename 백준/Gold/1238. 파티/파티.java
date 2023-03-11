import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int idx, cost;

    public Edge(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}

public class Main {
    /*
    다익스트라를 n -> x, x -> n 왕복하는 방식으로 n번 수행하면 시간초과, O(2*n*mlogn)
    n -> x를 n번, x -> n은 한번만 수행해서 다른 배열에 결과값을 저장해두고 정답을 계산하면 된다, O(n*mlogn)
     */
    static int n, m, x;
    static int[] dist; // Integer.MAX_VALUE 가능
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[f].add(new Edge(t, cost));
        }

        int ans = Integer.MIN_VALUE; // 정답
        int[] distX = new int[n + 1];
        dijkstra(x);
        for (int i = 1; i <= n; i++) {
            distX[i] = dist[i];
        }
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            dijkstra(i);
            sum = dist[x] + distX[i];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.idx] < cur.cost) {
                continue;
            }

            for (Edge e : edges[cur.idx]) {
                if (dist[cur.idx] + e.cost >= dist[e.idx]) {
                    continue;
                }

                dist[e.idx] = dist[cur.idx] + e.cost;
                pq.offer(new Edge(e.idx, dist[e.idx]));
            }
        }
    }
}