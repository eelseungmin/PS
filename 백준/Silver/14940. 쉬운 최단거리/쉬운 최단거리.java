import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /*

     */
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dist; // 방문 표시 배열
    static Node dest; // 목적지 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) { // 목적지 좌표 획득
                    dest = new Node(i, j);
                }
                if (map[i][j] == 0) { // 원래 갈 수 없는 땅인 위치는 0을 출력
                    dist[i][j] = 0;
                }
            }
        }

        bfs();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        dist[dest.x][dest.y]++;
        q.offer(dest);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (dist[nx][ny] != -1 || map[nx][ny] == 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}