import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    최대 랜선의 길이 -> parametric search?

    n개 만큼의 랜선을 만들 수 있는 최대 랜선의 길이?
    -> 어떤 길이로 잘라야 n개의 랜선을 얻을 수 있는가?

    mid: 어떤 길이

    O(Klog(2^31-1))
     */
    static int k, n;
    static int[] cable;
    static long length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        cable = new int[k];
        for (int i = 0; i < k; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }
        length = 0;

        bSearch();

        System.out.println(length);
    }

    public static void bSearch() {
        long left = 1;
        long right = Integer.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (calc(mid) >= n) {
                length = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static long calc(long mid) { // mid의 길이로 모든 랜선을 잘랐을 때 나오는 랜선의 총 갯수
        long sum = 0;

        for (int c : cable) {
            sum += c / mid;
        }

        return sum;
    }
}