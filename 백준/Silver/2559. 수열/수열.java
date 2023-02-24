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
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0; // 오른쪽 포인터
        int len = 1; // 현재 수열 길이
        int sum = arr[0]; // 구간합
        int ans = Integer.MIN_VALUE; // 정답
        for (int left = 0; left < n; left++) {
            while (right < n - 1 && len < k) {
                right++;
                sum += arr[right];
                len++;
            }
            
            if (len == k) {
                ans = Math.max(ans, sum);
            }

            sum -= arr[left];
            len--;
        }

        System.out.println(ans);
    }
}