import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    길이가 100인 숫자까지 직접 완전탐색으로 확인하는 건 불가능

    dp[i][j]: i번째 자릿수가 j일 때(길이가 i인 수가 j로 시작할 때) 계단 수 갯수(j는 0~9)
    i번째 자리의 숫자가 0이면 i-1번째 숫자는 1만 가능
    i번째 자리의 숫자가 9이면 i-1번째 숫자는 8만 가능
    초기값 dp[1][] 채우기

    O(N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        final long mod = 1000000000L;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 9) {
                    dp[i][j] += dp[i - 1][j + 1] % mod;
                }
                if (j != 0) {
                    dp[i][j] += dp[i - 1][j - 1] % mod;
                }
            }
        }

        long ans = 0; // 정답
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i] % mod;
        }
        ans %= mod;
        
        System.out.println(ans);
    }
}