import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int idx, cost;

    public Edge(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    /*
    양방향, 특정한 두 정점은 반드시 통과
    1-v1, v1-v2, v2-n 세 가지 최단거리를 합치고
    1-v2, v2-v1, v1-n 세 가지 최단거리를 합쳐서
    2개 중 작은 게 정답
    O(ElogN)
     */
    static int n, e, v1, v2;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c)); // 양방향
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long len1 = 0;
        dijkstra(1);
        len1 += dist[v1];
        dijkstra(v1);
        len1 += dist[v2];
        dijkstra(v2);
        len1 += dist[n];

        long len2 = 0;
        dijkstra(1);
        len2 += dist[v2];
        dijkstra(v2);
        len2 += dist[v1];
        dijkstra(v1);
        len2 += dist[n];

        if (len1 >= Integer.MAX_VALUE && len2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(len1, len2));
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.cost - e2.cost;
            }
        });

        Arrays.fill(dist, Integer.MAX_VALUE); // 최댓값이 MAX_VALUE를 넘지 않음

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