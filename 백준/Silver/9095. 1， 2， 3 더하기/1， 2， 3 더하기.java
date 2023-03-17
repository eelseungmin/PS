import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    dp[i]: i를 1,2,3의 합으로 나타내는 방법의 수
    dp[1]: 1
    dp[2]: 11 2
    dp[3]: 111 12 21 3
    dp[4]: 1111 31 211 121 dp[3]
           112 22 dp[2]
           13 dp[1]
    dp[4] = dp[3] + dp[2] + dp[1]
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp 배열을 미리 계산해두면 더 효율적
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}