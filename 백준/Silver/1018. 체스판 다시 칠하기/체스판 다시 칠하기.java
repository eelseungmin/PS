import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O((MN)^2) = O(6250000)
     */
    static boolean[][] map;
    static int n, m;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (tmp.charAt(j) == 'W') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                calc(i, j);
            }
        }

        System.out.println(min);
    }

    static void calc(int x, int y) {
        boolean first = map[x][y]; // 첫 번째 칸의 색깔
        int cnt = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != first) {
                    cnt++;
                }

                first = !first; // 칸마다 색깔 변경
            }
            first = !first;
        }

        cnt = Math.min(cnt, 64 - cnt); // 첫 번째 칸의 색깔의 경우가 2가지이므로 둘 중 최솟값 계산
        min = Math.min(min, cnt); // 기존의 최솟값과 비교
    }
}