import java.io.*;
import java.util.*;

public class Main {
    /*
    O(N^2)
     */
    static int n, m, k;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vis = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (vis[x][y] || map[x][y] != 1) {
            return;
        }

        vis[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
        }
    }
}