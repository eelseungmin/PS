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
    static boolean[][] visited;
    static Queue<Node> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int painting = 0;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        // 그림 정보 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    painting++; // 그림의 시작점이므로 갯수 증가
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(painting + "\n" + max);
    }

    public static void bfs(Node node) {
        visited[node.x][node.y] = true;
        q = new LinkedList<>();
        q.offer(node);

        int area = 0; // 그림의 넓이

        while (!q.isEmpty()) {
            Node cur = q.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 다음 좌표가 지도 바깥이면
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        max = Math.max(max, area);
    }
}