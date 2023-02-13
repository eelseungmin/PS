import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N^2)
     */
    static int n, m;
    static int[][] adj;
    static int[] dist;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new int[n + 1][n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, -1);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
            adj[to][from] = 1;
        }

        bfs();

        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (dist[cur] > 2) { // 0=상근, 1=친구, 2=친구의 친구
                continue;
            }

            if (cur != 1) { // 상근이 자기자신은 제외하고 사람 수 늘리기
                cnt++;
            }

            for (int i = 1; i <= n; i++) {
                if (adj[cur][i] == 1 && dist[i] == -1) {
                    dist[i] = dist[cur] + 1;
                    q.offer(i);
                }
            }
        }
    }
}