import java.io.*;
import java.util.*;

public class Main {
    /*
    2초, 256MB
    1. 조합을 통해 25에서 7을 뽑는다.
    2. 뽑은 조합을 bfs를 통해 가로세로 인접 여부를 체크한다.
    3. 이다솜파의 숫자가 4명 이상인지 같이 확인한다.
     */
    static char[][] map = new char[5][5];
    static int[] combX = new int[25];
    static int[] combY = new int[25];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int ans;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < 25; i++) {
            combY[i] = i / 5;
            combX[i] = i % 5;
        }

        comb(new int[7], 0, 0, 7);
        System.out.println(ans);
    }

    public static void comb(int[] comb, int idx, int depth, int left) { // 재귀를 이용한 조합
        if (left == 0) {
            bfs(comb);
            return;
        }

        if (depth == 25) {
            return;
        }

        comb[idx] = depth;
        comb(comb, idx + 1, depth + 1, left - 1); // 선택
        comb(comb, idx, depth + 1, left); // 선택 X, 배열에 들어갈 숫자만 증가시킴
    }

    public static void bfs(int[] comb) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];
        int lds = 0; // 이다솜파 인원수
        int adj = 1; // 인접한 인원의 수

        visited[0] = true;
        q.offer(comb[0]);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int curX = combX[cur];
            int curY = combY[cur];

            if (map[curY][curX] == 'S') {
                lds++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && nx == combX[comb[j]] && ny == combY[comb[j]]) {
                        visited[j] = true;
                        q.offer(comb[j]);
                        adj++;
                    }
                }
            }
        }

        if (adj == 7 && lds >= 4) {
            ans++;
        }
    }
}