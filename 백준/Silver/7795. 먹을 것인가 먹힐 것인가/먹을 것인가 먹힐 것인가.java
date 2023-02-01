import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    O((N+M)logM)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += binarySearch(b, a[i]);
            }

            System.out.println(ans);
        }
    }

    public static int binarySearch(int[] arr, int target) { // target보다 작은 수 중 가장 오른쪽 idx return
        int left = 0;
        int right = arr.length - 1;

        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result + 1;
    }
}