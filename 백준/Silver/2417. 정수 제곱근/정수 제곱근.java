import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    O(logN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(binarySearch(n));
    }

    public static long binarySearch(long target) { // target보다 작은 수 중 target의 제곱근 구하기
        long left = 0;
        long right = target;

        long result = -1;
        while (left <= right) {
            long mid = (left + right) / 2;

            if ((long) Math.pow(mid, 2) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}