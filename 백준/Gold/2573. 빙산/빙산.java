import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /*
    1초, 256MB

    빙산 높이 0에 접한 칸 갯수만큼 년마다 감소
    두 덩어리 이상으로 분리되는 최초 시간, 다 녹을 때까지 분리 안되면 0 출력

    빙산 녹이는 건 bfs가 아니라 그냥 함수 하나 짜서 진행 시키고
    두 덩어리로 떨어졌는지를 판단하는 조건??
    -> 아무 빙산이나 골라서 빙산인 칸 bfs 해서 빙산 갯수 센 다음에 전체 빙산 갯수와 같으면 아직 분리가 안된 것

     */
    static int n, m, year;
    static int[][] map;
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            year++;
            melting(); // 빙산 녹이기
            vis = new int[n][m]; // 방문 배열 초기화
            int status = status();// 빙산 상태 확인
            if (status == 0) {
                System.out.println(0);
                return;
            } else if (status == 2) {
                System.out.println(year);
                return;
            }
            vis = new int[n][m]; // 방문 배열 초기화
        }
    }

    public static boolean check(int nx, int ny) { // 범위 안에 있는지 확인
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            return true;
        }
        return false;
    }

    public static void melting() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (check(nx, ny) && map[nx][ny] == 0) { // 주변의 0 갯수 구하기
                        vis[i][j]++;
                    }
                }
            }
        }

        // 0 갯수 만큼 빙산 녹이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = Math.max(0, map[i][j] - vis[i][j]);
            }
        }
    }

    // 0: 빙산이 다 녹음, 1: 빙산이 한 덩어리, 2: 두 덩어리 이상
    public static int status() {
        int exist = 0; // 빙산 갯수
        int curx = -1;
        int cury = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    curx = i;
                    cury = j;
                    exist++;
                }
            }
        }

        if (exist == 0) { // 다 녹음
            return 0;
        }

        // 빙산끼리 붙어있는지 확인
        int exist2 = 0;
        vis[curx][cury]++;
        q.offer(new Node(curx, cury));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            exist2++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 바깥, 방문 여부, 빙산 여부 필터링
                if (!check(nx, ny) || vis[nx][ny] == 1 || map[nx][ny] == 0) {
                    continue;
                }

                vis[nx][ny] = 1;
                q.offer(new Node(nx, ny));
            }
        }

        if (exist == exist2) { // 한 덩이
            return 1;
        }
        return 2; // 두 덩이 이상
    }
}