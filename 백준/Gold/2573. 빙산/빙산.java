import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    두 덩어리로 분리되는지 여부 체크
    1년마다 각 빙산마다 상하좌우 바다 칸 갯수 확인하고 그만큼 높이 감소시키기

    O(NM)
     */
    static int n, m;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int totalIce; // 빙산 총 갯수
    static int teamIce; // 빙산 덩어리 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙산 녹이기
        int year = 0;
        while (true) {
            year++;

            meltIce();

            int status = checkIce();
            if (status == 0) {
                System.out.println(0);
                return;
            } else if (status == 1) {
                continue;
            } else {
                System.out.println(year);
                return;
            }
        }
    }

    static void meltIce() { // 빙산 녹이기
        int[][] nearIce = new int[n][m]; // 녹일 높이를 기록할 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (map[nx][ny] == 0) {
                        nearIce[i][j]++;
                    }
                }
            }
        }

        // 빙산을 한꺼번에 녹여야 주위 빙산 갯수를 계산할 때 지장이 없음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = Math.max(0, map[i][j] - nearIce[i][j]);
            }
        }
    }

    static int checkIce() {
        totalIce = 0;
        teamIce = 0;
        vis = new boolean[n][m]; // 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    teamIce++;
                }
            }
        }

        if (teamIce >= 2) { // 빙산이 두 덩어리 이상으로 분리됨
            return 2;
        } else if (totalIce == 0 && teamIce < 2) { // 빙산이 다 녹았지만 분리되지 않음
            return 0;
        } else { // 빙산이 다 녹지 않았고 분리되지도 않음
            return 1;
        }
    }

    static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (map[x][y] == 0 || vis[x][y]) {
            return;
        }

        vis[x][y] = true;
        totalIce++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
        }
    }
}