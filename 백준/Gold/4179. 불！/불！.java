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
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] maze;
    static int[][] distJ;
    static int[][] distF;
    static Node jihun, fire;
    static Queue<Node> qFire = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];
        distJ = new int[r][c];
        distF = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(distJ[i], -1);
        }
        for (int i = 0; i < r; i++) {
            Arrays.fill(distF[i], -1);
        }
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = tmp.charAt(j);
                if (maze[i][j] == 'J') {
                    jihun = new Node(i, j);
                }
                if (maze[i][j] == 'F') { // 불이 여러 지점에서 날 수 있으므로 불 위치는 큐에 넣는다.
                    qFire.offer(new Node(i, j));
                    distF[i][j]++;
                }
            }
        }

        bfsFire();
        bfsJihun();
    }

    static void bfsFire() {
        while (!qFire.isEmpty()) {
            Node cur = qFire.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }

                if (maze[nx][ny] == '#' || distF[nx][ny] != -1) {
                    continue;
                }

                distF[nx][ny] = distF[cur.x][cur.y] + 1;
                qFire.offer(new Node(nx, ny));
            }
        }
    }

    static void bfsJihun() {
        Queue<Node> q = new LinkedList<>();
        distJ[jihun.x][jihun.y]++;
        q.offer(jihun);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) { // 가장자리에 도달하면 탈출 성공
                    System.out.println(distJ[cur.x][cur.y] + 1);
                    return;
                }

                if (maze[nx][ny] == '#' || distJ[nx][ny] != -1) {
                    continue;
                }

                // 불이 지훈보다 먼저 도달하거나 동시에 도달하면 안됨, 당연히 불이 하나도 없는 경우도 빼야 함
                if (distF[nx][ny] != -1 && distF[nx][ny] <= distJ[cur.x][cur.y] + 1) {
                    continue;
                }

                distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}