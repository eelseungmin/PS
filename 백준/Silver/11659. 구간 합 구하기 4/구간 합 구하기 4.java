import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    dp[i] = arr[1]부터 arr[i]까지의 합
    dp[1] = 5
    dp[2] = 5 + 4 = dp[1] + arr[2]
    dp[3] = 5 + 4 + 3 = dp[2] + arr[3]
    dp[i] = dp[i - 1] + arr[i]
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j] - dp[i - 1]);
        }
    }
}