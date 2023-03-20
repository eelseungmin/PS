import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    계단 오르기 문제와 비슷함

    dp[i][0]: 규칙을 만족하면서 i번까지의 집을 칠하는 비용의 최솟값, i번째 집은 빨강
    dp[i][1]: 규칙을 만족하면서 i번까지의 집을 칠하는 비용의 최솟값, i번째 집은 초록
    dp[i][2]: 규칙을 만족하면서 i번까지의 집을 칠하는 비용의 최솟값, i번째 집은 파랑

    dp[1][0]: cost[0]
    dp[2][0]: min(dp[1][1], dp[1][2]) + cost[0]
    ...
    dp[n][0]: min(dp[n - 1][1], dp[n - 1][2]) + cost[0]
    dp[n][1]: min(dp[n - 1][0], dp[n - 1][2]) + cost[1]
    dp[n][2]: min(dp[n - 1][0], dp[n - 1][1]) + cost[2]
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}