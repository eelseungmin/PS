import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    4
    1 3
    3 1
    2 2
     */
    static int[][] powerUp;
    static boolean[] start;
    static int n;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        powerUp = new int[n + 1][n + 1];
        start = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                powerUp[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 여기까지 입력

        calcSub(1);

        System.out.println(ans);
    }

    static void calcSub(int cnt) {
        if (cnt == n + 1) {
            int diff = calcDiff();
            ans = Math.min(ans, diff);
            return;
        }

        start[cnt] = true;
        calcSub(cnt + 1);
        start[cnt] = false;
        calcSub(cnt + 1);
    }

    static int calcDiff() {
        int linkPower = 0;
        int startPower = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (start[i] && start[j]) {
                    startPower += powerUp[i][j];
                }
                if (!start[i] && !start[j]) {
                    linkPower += powerUp[i][j];
                }
            }
        }

        return Math.abs(startPower - linkPower);
    }
}