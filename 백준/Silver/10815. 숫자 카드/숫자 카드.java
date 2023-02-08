import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    O(MlogN)
     */
    static int n, m;
    static int[] arr, check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        check = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            bSearch(check[i]);
        }

        System.out.println(sb);
    }

    public static void bSearch(int num) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                sb.append(1 + " ");
                return;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        sb.append(0 + " ");
    }
}