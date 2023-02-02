import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N*log(wood's max height==10^9))
     */
    static int[] woods;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        woods = new int[n];
        int max = Integer.MIN_VALUE; // 높이가 가장 높은 나무의 높이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, woods[i]);
        }

        System.out.println(binarySearch(max, m));
    }

    public static int binarySearch(int max, int target) { // 나무들의 높이의 합을 target보다 크거나 같게 하는 절단기 높이 최댓값 구하기
        int left = 0;
        int right = max;
        int result = -1; // 절단기 높이 최댓값

        while (left <= right) {
            int mid = (left + right) / 2;

            if (calcHeight(mid) >= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static long calcHeight(int cutter) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (woods[i] <= cutter) {
                continue;
            }

            sum += woods[i] - cutter;
        }

        return sum;
    }
}