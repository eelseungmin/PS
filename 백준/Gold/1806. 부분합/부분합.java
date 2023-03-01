import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        int sum = arr[0]; // 부분합
        int len = 1; // 길이
        int ans = Integer.MAX_VALUE; // 정답
        for (int l = 0; l < n; l++) {
            while (r < n - 1 && sum < s) {
                r++;
                len++;
                sum += arr[r];
            }

            if (sum >= s) {
                ans = Math.min(ans, len);
            }

            sum -= arr[l];
            len--;
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}