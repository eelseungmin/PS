import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    dp[i]: i번째 계단에 오르기 위해서 필요한 최대 비용
    dp[0] = 0
    dp[1] = 10
    dp[2] = max(dp[0], dp[1]) + stairs[2] = 30
    dp[3] = max(dp[1], dp[2]) + stairs[3] = 35
    ...라고 하고 싶지만 연속한 세 계단을 밟아서는 안 된다는 조건을 점화식에 추가할 수 없는 상황

    dp[i][j]: 현재까지 j개의 계단을 연속해서 밟고 i번째 계단에 도달했을 때 최대 비용, i번째 계단은 반드시 밟아야 함
    dp[n][1] = max(dp[n-2][1], dp[n-2][2]) + stairs[n]
    dp[n][2] = dp[n-1][1] + stairs[n]

    마지막 계단을 반드시 밟아야 하므로 dp[n]을 출력하면 된다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[][] dp = new int[n + 1][3];
        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[1] + stairs[2];
        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
            dp[i][2] = dp[i - 1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}