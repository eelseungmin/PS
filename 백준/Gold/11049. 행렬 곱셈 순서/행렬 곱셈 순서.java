import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    1. 풀고 싶은 가짜 문제(i <= j)
    dp[i][j]: i번~j번까지의 행렬 곱셈 연산 횟수의 최솟값

    2. 가짜 문제를 풀면 진짜 문제를 풀 수 있는가?
    dp[1][N]

    3. 초기값은 어떻게 되는가?
    i == j인 경우 0

    4. 점화식 구하기
    ABCD -> A(BCD), (AB)(CD), (ABC)D
    dp[i][j] = min{dp[i][j], dp[i][k] + dp[k+1][j] + calc(k,k+1)}, i <= k < j
    calc(k,k+1): i~k 연산의 결과와 k+1~j 연산의 결과를 다시 곱했을 때의 연산 횟수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] row = new int[n + 1];
        int[] col = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row[i] = Integer.parseInt(st.nextToken());
            col[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];


        for (int len = 2; len <= n; len++) { // 곱셈 연산 횟수를 구할 구간의 길이
            for (int i = 1; i <= n - len + 1; i++) { // 시작 지점
                int j = i + len - 1; // 종료 지점
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + row[i] * row[k + 1] * col[j]);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}