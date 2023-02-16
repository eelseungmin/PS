import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;
    boolean gram;

    public Node(int x, int y, boolean gram) {
        this.x = x;
        this.y = y;
        this.gram = gram;
    }
}

public class Main {
    /*

     */
    static int n, m, t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] castle;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        castle = new int[n][m];
        dist = new int[n][m][2]; // [0]은 그람이 없을 때, [1]은 그람이 있을 때
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = bfs();

        if (res == -1) {
            System.out.println("Fail");
            return;
        } else {
            System.out.println(res);
        }
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        dist[0][0][0]++;
        q.offer(new Node(0, 0, false));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (dist[cur.x][cur.y][0] > t || dist[cur.x][cur.y][1] > t) {
                break;
            }
            if (cur.x == n - 1 && cur.y == m - 1) {
                if (dist[n - 1][m - 1][0] != -1 && dist[n - 1][m - 1][1] != -1) {
                    return Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
                } else if (dist[n - 1][m - 1][0] == -1) {
                    return dist[n - 1][m - 1][1];
                } else {
                    return dist[n - 1][m - 1][0];
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (cur.gram) { // 그람이 있을 때 타일의 값과 상관없이 이동 가능
                    if (dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[cur.x][cur.y][1] + 1;
                        q.offer(new Node(nx, ny, true));
                    }
                } else { // 그람이 없을 때
                    if (dist[nx][ny][0] == -1) {
                        if (castle[nx][ny] == 0) { // 빈 공간 이동
                            dist[nx][ny][0] = dist[cur.x][cur.y][0] + 1;
                            q.offer(new Node(nx, ny, false));
                        } else if (castle[nx][ny] == 2) { // 그람 발견
                            dist[nx][ny][1] = dist[cur.x][cur.y][0] + 1;
                            q.offer(new Node(nx, ny, true));
                        }
                    }
                }
            }
        }

        return -1;
    }
}