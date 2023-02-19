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

     */
    static int n, m, cnt;
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[][] map;
    static int[][] dist; // 방문 표시 배열
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            map = new int[m][n];
            dist = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dist[i], -1);
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && dist[i][j] == -1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");
        }

        // 출력
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        dist[x][y]++;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (dist[nx][ny] != -1 || map[nx][ny] == 0) {
                    continue;
                }

                dist[nx][ny]++;
                q.offer(new Node(nx, ny));
            }
        }
    }
}