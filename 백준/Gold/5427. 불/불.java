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

    벽 있으면 dist값 0
    불, 상근 시작위치 dist 0 입력
    불이랑 상근 따로 bfs 돌리기
    상근이가 벽 밖으로 벗어나면 탈출에 성공했다는 의미
     */

    static char[][] build;
    static int[][] distJ, distF;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> qJ, qF;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            build = new char[h][w];
            distJ = new int[h][w];
            distF = new int[h][w];
            qJ = new LinkedList<>();
            qF = new LinkedList<>();

            // 빌딩 정보 입력받기
            for (int j = 0; j < h; j++) {
                String tmp = br.readLine();
                for (int k = 0; k < w; k++) {
                    build[j][k] = tmp.charAt(k);

                    if (build[j][k] != '#') {
                        distJ[j][k] = -1;
                        distF[j][k] = -1;
                    }
                    if (build[j][k] == '*') {
                        distF[j][k] = 0;
                        distJ[j][k] = 0;
                        qF.offer(new Node(j, k));
                    }
                    if (build[j][k] == '@') {
                        distJ[j][k] = 0;
                        qJ.offer(new Node(j, k));
                    }
                }
            }

            // 불 bfs
            while (!qF.isEmpty()) {
                Node cur = qF.poll();

                for (int l = 0; l < 4; l++) {
                    int nx = cur.x + dx[l];
                    int ny = cur.y + dy[l];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }

                    if (distF[nx][ny] >= 0) {
                        continue;
                    }

                    distF[nx][ny] = distF[cur.x][cur.y] + 1;
                    qF.offer(new Node(nx, ny));
                }
            }

            // 지훈 bfs
            boolean possible = false;
            while (!qJ.isEmpty()) {
                if (possible) { // 지훈이가 탈출한 경우
                    break;
                }
                Node cur = qJ.poll();

                for (int l = 0; l < 4; l++) {
                    int nx = cur.x + dx[l];
                    int ny = cur.y + dy[l];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) { // 탈출 성공
                        System.out.println(distJ[cur.x][cur.y] + 1);
                        possible = true;
                        break;
                    }

                    if (distF[nx][ny] >= 0 && distF[nx][ny] <= distJ[cur.x][cur.y] + 1) { // 불이 이미 붙은 경우나 불이 이제 막 번지려는 경우
                        continue;
                    }

                    if (distJ[nx][ny] >= 0) {
                        continue;
                    }

                    distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
                    qJ.offer(new Node(nx, ny));
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}