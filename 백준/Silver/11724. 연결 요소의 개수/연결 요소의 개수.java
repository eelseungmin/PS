import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    이어진 요소의 갯수를 출력하면 된다.

    O(N+M)
     */
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges.get(from).add(to);
            edges.get(to).add(from); // 무방향 그래프이므로 역방향 간선도 추가
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == 0) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dist[start]++;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int node : edges.get(cur)) {
                if (dist[node] != 0) {
                    continue;
                }

                dist[node]++;
                q.offer(node);
            }
        }
    }
}