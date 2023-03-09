import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    /*
    간선에 가중치가 있으므로 다익스트라 알고리즘 사용
    O(ElogV)
     */
    static int v, e, k;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        edges = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            edges[i] = new ArrayList<>();
        }
        dist = new int[v + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        // 최소 힙 생성
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        // dist 배열 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작점 pq에 추가, 거리 배열 갱신
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        // pq가 빌 때까지 거리 갱신 반복
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (Edge e : edges[cur.to]) {
                if (dist[cur.to] + e.weight >= dist[e.to]) {
                    continue;
                }

                dist[e.to] = dist[cur.to] + e.weight;
                pq.offer(new Edge(e.to, dist[e.to]));
            }
        }
    }
}