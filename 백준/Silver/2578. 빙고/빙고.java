import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int[][] board;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        vis = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                erase(num);
                if (check()) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
        }
    }

    static void erase(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    vis[i][j] = true;
                    return;
                }
            }
        }
    }

    static boolean check() {
        int line = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (vis[i][j]) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                line++;
                if (line == 3) {
                    return true;
                }
            }
            cnt = 0;
        }

        // 세로
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (vis[j][i]) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                line++;
                if (line == 3) {
                    return true;
                }
            }
            cnt = 0;
        }

        // \
        /**
         *    0 1 2 3 4
         *  0         4
         *  1       4
         *  2
         *  3
         *  4
         */
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i; j <= i; j++) {
                if (i == j && vis[i][j]) {
                    cnt++;
                }
            }
        }
        if (cnt == 5) {
            line++;
            if (line == 3) {
                return true;
            }
        }

        // /
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j == 4 && vis[i][j]) {
                    cnt++;
                }
            }
        }
        if (cnt == 5) {
            line++;
            if (line == 3) {
                return true;
            }
        }

        return false;
    }
}