import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N+M)

            1
           / \
          2   3
         /|\
        7 8 9
     */
    static int n, m;
    static int p1, p2;
    static int[][] adj;
    static boolean[] vis;
    static int cnt; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        adj = new int[n + 1][n + 1];
        vis = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
            adj[to][from] = 1;
        }

        bfs(p1, p2);

        System.out.println(cnt);
    }

    public static void bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        vis[from] = true;

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) { // 노드에서 다른 노드로 이동할 때마다 촌수 증가
                int cur = q.poll();

                if (cur == to) {
                    return;
                }

                for (int j = 1; j <= n; j++) {
                    if (adj[cur][j] == 1 && !vis[j]) {
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }

            cnt++;
        }

        cnt = -1; // 촌수 계산 불가
    }
}