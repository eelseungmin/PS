import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    백트래킹은 O(2^N)으로 당연히 시간 초과

    dp[i]: i번째 원소가 수열의 마지막일 때 증가하는 부분수열의 최대 길이
    dp[0] = 1 {10}
    dp[1] = 2 {10, 20}
    dp[2] = 1 {10}

    dp[n] = if(arr[j] < arr[n]) dp[n] = max(dp[n], dp[j] + 1)

    O(N^2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];

        int ans = 0; // 정답
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}