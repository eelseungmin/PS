import java.io.*;
import java.util.*;

import static java.lang.System.exit;

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
    지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
    지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력

    불 bfs를 먼저 돌리고, 얻은 정보를 바탕으로 지훈 bfs를 돌린다.
     */

    static char[][] map;
    static int[][] distJ; // 지훈
    static int[][] distF; // 불
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> qJ = new LinkedList<>();
    static Queue<Node> qF = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        distJ = new int[r][c];
        distF = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(distJ[i], -1);
            Arrays.fill(distF[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'J') { // 지훈 시작점
                    distJ[i][j] = 0;
                    qJ.offer(new Node(i, j));
                }
                if (map[i][j] == 'F') { // 불 시작점
                    distF[i][j] = 0;
                    qF.offer(new Node(i, j));
                }
            }
        }

        bfs(qF, distF); // 불 bfs
        bfsJ(qJ, distJ, distF); // 지훈 bfs

        System.out.println("IMPOSSIBLE");
    }

    // 불 bfs
    public static void bfs(Queue<Node> q, int[][] dist) {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (dist[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }

    // 지훈 bfs
    public static void bfsJ(Queue<Node> q, int[][] distJ, int[][] distF) {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 미로의 범위를 벗어났다는 건 탈출에 성공했음을 의미, 출력 후 프로그램 종료
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    System.out.println(distJ[cur.x][cur.y] + 1);
                    exit(0);
                }

                if (distJ[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }

                // 해당 시점에 불 번지는 곳이나 도착 전에 불이 이미 번진 곳은 이동 불가
                if (distF[nx][ny] != -1 && distJ[cur.x][cur.y] + 1 >= distF[nx][ny]) {
                    continue;
                }

                distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}