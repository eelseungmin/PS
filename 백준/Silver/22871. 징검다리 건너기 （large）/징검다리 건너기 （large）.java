import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    dp로 풀이

    i < j
    0부터 j까지 가는 경우라면
    0과 j 사이의 i마다 거쳐오는 경우들이 있으므로
    0->i에서 드는 힘, i->j에서 드는 힘 중에 더 큰 힘을 선택
    선택한 힘을 최솟값인지 확인하고 갱신한다.

    O(N^2)
     */
    static int n;
    static long[] rocks;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rocks = new long[n];
        dp = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Long.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                long tmp = Math.max(dp[j], (i - j) * (1 + Math.abs(rocks[i] - rocks[j])));
                dp[i] = Math.min(dp[i], tmp);
            }
        }

        System.out.println(dp[n - 1]);
    }
}