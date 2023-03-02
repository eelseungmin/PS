import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] vis = new int[100001]; // 방문 체크 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        int len = 1; // 현재 부분 수열의 길이
        int maxLen = 1; // 최장 연속 부분 수열의 길이
        vis[arr[0]]++;
        for (int l = 0; l < n; l++) {
            while (r < n - 1 && vis[arr[r]] <= k) {
                r++;
                vis[arr[r]]++;
                len++;
            }

            if (vis[arr[r]] > k) {
                maxLen = Math.max(maxLen, len - 1);
            } else {
                maxLen = Math.max(maxLen, len);
            }

            vis[arr[l]]--;
            len--;
        }

        System.out.println(maxLen);
    }
}