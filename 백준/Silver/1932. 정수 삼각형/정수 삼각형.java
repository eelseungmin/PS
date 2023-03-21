import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    dp[i][j]: 맨 위층이 1층일 때, i층까지 내려오면서 선택된 수의 최대 합
    단, 양쪽 끝은 끝값을 그대로 더하고 나머지는 양쪽 값중 더 큰 값을 더한다.
    
    O(N^2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        int[][] tri = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = tri[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + tri[i][j];
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
                }
            }
        }

        int ans = 0; // 정답
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}