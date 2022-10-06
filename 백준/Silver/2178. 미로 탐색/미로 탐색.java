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

     */
    static int[][] map;
    static int[][] dist; // 시작 지점부터의 거리를 표현하지만 방문 여부도 나타낸다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        // 2차원 배열 Arrays.fill로 -1 채우기
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 미로 입력받기
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0'; // char to int
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1 && map[i][j] == 1) {
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(dist[n - 1][m - 1] + 1);
    }

    public static void bfs(Node node) {
        if (dist[node.x][node.y] == -1) {
            dist[node.x][node.y]++;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (dist[nx][ny] == -1 && map[nx][ny] == 1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}