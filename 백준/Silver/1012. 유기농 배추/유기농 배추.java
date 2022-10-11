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
    1초, 512MB
     */
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테케 갯수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int loX = Integer.parseInt(st2.nextToken());
                int loY = Integer.parseInt(st2.nextToken());

                map[loY][loX] = 1;
            }

            int cnt = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        visited[a][b] = true;
                        bfs(new Node(a, b));
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void bfs(Node node) {
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] != 1) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }
}