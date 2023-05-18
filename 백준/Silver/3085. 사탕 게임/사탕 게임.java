import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*

     */
    static int n;
    static int ans;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        // 행에서 비교하면서 스왑
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1); // 스왑
                    ans = Math.max(ans, search()); // 최댓값 탐색
                    swap(i, j, i, j + 1); // 되돌리기
                }
            }
        }

        // 열에서 비교하면서 스왑
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] != board[j + 1][i]) {
                    swap(j, i, j + 1, i); // 스왑
                    ans = Math.max(ans, search()); // 최댓값 탐색
                    swap(j, i, j + 1, i); // 되돌리기
                }
            }
        }

        System.out.println(ans);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    static int search() {
        int max = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}