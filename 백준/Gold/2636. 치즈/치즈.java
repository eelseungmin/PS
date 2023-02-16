import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    안의 구멍과 바깥의 공기가 접촉한 면 구분하는 방법?
    (0,0)부터 dfs나 bfs로 탐색해서 이어진 모든 0을 외부라고 생각하면 됨
     */
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] vis;
    static int[][] melt; // 녹여야 할 칸
    static boolean[][] external; // 외부 공기
    static int time; // 걸리는 시간
    static int before; // 녹이기 전 칸의 갯수
    static int after; // 녹인 후 칸의 갯수
    static boolean exit; // 종료 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count();
        while (true) {
            melting();
            if (exit) {
                break;
            }
            before = after; // 칸의 갯수 기록
            time++;
        }
    }

    static void melting() { // 치즈 녹이기
        vis = new boolean[n][m];
        melt = new int[n][m];
        external = new boolean[n][m];
        after = 0;
        // 외부 공기 찾아서 표시하기
        marking(0, 0);

        vis = new boolean[n][m];
        // 외부 공기와 접촉한 칸 찾기
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && board[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        if (after == 0) {
            exit = true;
            System.out.println(time);
            System.out.println(before);
            return;
        }

        // 치즈 녹이기
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (melt[i][j] > 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    static void marking(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (vis[x][y] || board[x][y] == 1) {
            return;
        }

        vis[x][y] = true;
        external[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            marking(nx, ny);
        }
    }

    static void dfs(int x, int y) {
        if (vis[x][y] || board[x][y] == 0) {
            return;
        }

        vis[x][y] = true;
        after++; // 탐색하면서 조각 갯수도 세주기

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (external[nx][ny]) { // 다음에 이동할 칸이 외부 공기와 접촉
                melt[x][y]++;
            }
            dfs(nx, ny);
        }
    }

    static void count() {
        before = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 1) {
                    before++;
                }
            }
        }
    }
}