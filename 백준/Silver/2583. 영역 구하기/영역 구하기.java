import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] paper;
    static int[][] dist;
    static Queue<Node> q = new LinkedList<>();
    static ArrayList<Integer> areas = new ArrayList<>(); // 넓이 리스트
    static int cnt; // 영역 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        paper = new int[m][n];
        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for (int a = ly; a < ry; a++) {
                for (int b = lx; b < rx; b++) {
                    paper[a][b] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i][j] == 0 && dist[i][j] == -1) {
                    bfs(i, j);
                    cnt++; // 영역 갯수 추가
                }
            }
        }

        Collections.sort(areas);
        System.out.println(cnt);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static void bfs(int x, int y) {
        int tmp = 0; // 영역 넓이

        tmp++;
        dist[x][y]++;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (paper[nx][ny] != 0 || dist[nx][ny] != -1) {
                    continue;
                }

                tmp++;
                dist[nx][ny]++;
                q.offer(new Node(nx, ny));
            }
        }

        areas.add(tmp); // 영역 넓이 리스트에 추가
    }
}