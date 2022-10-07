import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /*
    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
    모든 익지 않은 토마토로부터 익은 토마토까지의 거리 중 최단을 찾는 것
    -> 익은 토마토만 bfs 시작점으로 취급
     */
    static int[][] tomato;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        dist = new int[n][m];
        tomato = new int[n][m];
        q = new LinkedList<>();

        // 입력 받으면서 익은 토마토만 큐에 집어넣기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
                if (tomato[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) { // bfs 돌렸는데도 익지 않은 토마토가 있으면 -1 출력
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= tomato.length || ny < 0 || ny >= tomato[0].length) {
                    continue;
                }

                if (dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}