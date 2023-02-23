import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    bfs를 돌면서 인접한 나라의 인구 차이를 체크해서 해당하는 국경선을 전부 연다.
    연합을 이루고 있는 나라들의 인구수를 수정한다.
    연합을 해체하고 모든 국경선을 닫는다.
     */
    static int n, l, r;
    static int[][] num; // 국가 별 인구수
    static boolean[][] dist; // 방문 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans; // 인구 이동이 일어난 날짜
    static boolean isMove; // 인구 이동 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        num = new int[n][n];
        dist = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구 이동이 없을 때까지
        while (true) {
            isMove = false;
            dist = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!dist[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (!isMove) { // 인구 이동이 없다면 while문 종료
                break;
            }

            ans++; // 날짜 증가
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        dist[x][y] = true;
        q.offer(new Node(x, y));

        Queue<Node> union = new LinkedList<>(); // 연합에 속한 국가 리스트
        union.offer(new Node(x, y));
        int cnt = 1;
        int total = num[x][y];

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (dist[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(num[cur.x][cur.y] - num[nx][ny]);
                if (l <= diff && diff <= r) {
                    dist[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    isMove = true; // 인구 이동 발생
                    cnt++;
                    total += num[nx][ny];
                    union.offer(new Node(nx, ny));
                }
            }
        }

        if (union.size() <= 1) { // 연합에 자신 이외의 국가가 있어야 인구 이동
            return;
        }

        // 연합 내 인구 이동
        int update = total / cnt;
        while (!union.isEmpty()) {
            Node cur = union.poll();

            num[cur.x][cur.y] = update;
        }
    }
}