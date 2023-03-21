import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    O(N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1]; // 경로 표시 배열

        dp[1] = 0;
        path[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    path[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    path[i] = i / 2;
                }
            }
        }

        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder();
        int cur = n;
        while (true) {
            sb.append(cur + " ");
            if (cur == 1) {
                break;
            }
            cur = path[cur];
        }
        System.out.println(sb);
    }
}