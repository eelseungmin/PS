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
    1초, 128MB
    색약이 아닌 경우: R, G
    색약인 경우: R, G를 하나로
     */
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        // 색약 X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i, j));
                    cnt++;
                }
            }
        }
        System.out.print(cnt + " ");
        // visited 초기화
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        // cnt 초기화
        cnt = 0;
        // G를 R로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
        // 색약 O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i, j));
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
    public static void bfs(Node node) {
        visited[node.x][node.y] = true;
        q.offer(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }
                if (map[nx][ny] != map[cur.x][cur.y] || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }
}