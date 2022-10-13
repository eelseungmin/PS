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
    1초, 256MB

    큐에 시작 위치 넣고 bfs 수행한 뒤 도착 위치의 dist 출력
     */
    static int[][] dist;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<Node> q = new LinkedList<>();
    static int l, curX, curY, nx, ny;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            dist = new int[l][l];
            for (int j = 0; j < l; j++) { // dist 초기화
                Arrays.fill(dist[j], -1);
            }

            st = new StringTokenizer(br.readLine());
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());

            // 시작 위치 dist, 큐 처리
            dist[curX][curY]++;
            q.offer(new Node(curX, curY));

            bfs();
            System.out.println(dist[nx][ny]);
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) { // 목적 위치에 도착하기 전까지 bfs 수행
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) {
                    continue;
                }

                if (dist[nextX][nextY] >= 0) {
                    continue;
                }

                dist[nextX][nextY] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }
    }
}