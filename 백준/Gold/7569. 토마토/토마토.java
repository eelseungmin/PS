import java.io.*;
import java.util.*;

class Node {
    int x, y, z;

    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    /*
    1초, 256MB

     */
    static int[][][] tomato = new int[101][101][101];
    static int[][][] dist = new int[101][101][101];
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    static int m, n, h;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());

                    if (tomato[i][j][k] == 1) {
                        q.offer(new Node(k, j, i));
                    }
                    if (tomato[i][j][k] == 0) {
                        dist[i][j][k] = -1;
                    }
                }
            }
        }

        bfs();

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) {
                    continue;
                }

                if (dist[nz][ny][nx] >= 0) {
                    continue;
                }

                dist[nz][ny][nx] = dist[cur.z][cur.y][cur.x] + 1;
                q.offer(new Node(nx, ny, nz));
            }
        }
    }
}