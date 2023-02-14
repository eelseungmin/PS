import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /*
    O(N^2)
     */
    static int n;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> home;
    static int cnt, complex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        vis = new boolean[n][n];
        home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    home.add(cnt);
                    complex++; // 일련의 dfs가 끝나면 해당 단지의 집의 수 리스트에 추가, 단지수 증가
                }
            }
        }

        Collections.sort(home);
        StringBuilder sb = new StringBuilder();
        sb.append(complex + "\n");
        for (int num : home) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
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