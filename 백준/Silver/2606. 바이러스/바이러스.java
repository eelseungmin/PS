import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N^2)
     */
    static int n, m;
    static int[][] adj;
    static boolean[] vis;
    static int cnt; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new int[n + 1][n + 1];
        vis = new boolean[n + 1];

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

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (vis[cur]) {
                continue;
            }

            vis[cur] = true;
            cnt++;

            for (int i = 1; i <= n; i++) {
                if (adj[cur][i] == 1) {
                    q.offer(i);
                }
            }
        }

        cnt--; // 1번 컴퓨터 제외
    }
}