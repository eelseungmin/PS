import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(10000*log(100000))
     */
    static int n, m;
    static int[] arr;
    static int ans; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            ans = Math.max(ans, arr[i]);
        }

        m = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int a : arr) { // 1번 규칙에 따라 총액 계산
            sum += a;
        }

        if (sum <= m) {
            System.out.println(ans);
        } else {
            bSearch(ans);
            System.out.println(ans);
        }
    }

    public static void bSearch(int max) {
        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (calcSum(mid) <= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static int calcSum(int mid) { // 2번 규칙 적용했을 때의 총액 계산
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }

        return sum;
    }
}