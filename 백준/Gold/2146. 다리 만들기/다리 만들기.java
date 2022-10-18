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
    2초(6~10)

    두 대륙을 연결하는 가장 짧은 다리의 길이 출력
     */
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dist;
    static boolean[][] vis;
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 섬 번호
        // 섬에 번호 매기는 bfs, map[i][j] 같으면 같은 섬
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || vis[i][j]) {
                    continue;
                }

                cnt++;
                vis[i][j] = true;
                map[i][j] = cnt;
                q.offer(new Node(i, j));

                while (!q.isEmpty()) {
                    Node cur = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (vis[nx][ny] || map[nx][ny] == 0) {
                            continue;
                        }

                        map[nx][ny] = cnt;
                        vis[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

        // 다리 만들기를 위한 bfs, map[i][j] map[nx][ny]가 다른 최초의 i,j를 찾으면 다리 길이 계산 가능
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    dist[i][j] = 0;
                    q.offer(new Node(i, j));

                    while (!q.isEmpty()) {
                        Node cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (dist[nx][ny] >= 0 || map[i][j] == map[nx][ny]) {
                                continue;
                            }
                            if (map[nx][ny] != 0 && map[i][j] != map[nx][ny]) {
                                min = Math.min(min, dist[cur.x][cur.y]);
                            }

                            dist[nx][ny] = dist[cur.x][cur.y] + 1;
                            q.offer(new Node(nx, ny));
                        }
                    }

                    for (int k = 0; k < n; k++) {
                        Arrays.fill(dist[k], -1);
                    }
                }
            }
        }

        System.out.println(min);
    }
}