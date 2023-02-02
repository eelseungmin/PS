import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    범위 때문에 완전탐색으로 푸는 것이 불가능
    이분탐색을 이용하여 구간을 나눈다.
    right를 입력 받은 숫자 중 최댓값으로 설정
    left ~ right 사이에서 가장 큰 수(max)와 가장 작은 수(min)의 차이를 구한다.
    mid를 해당 구간 max - min의 최댓값으로 설정
    max - min > mid면 구간을 끊고 cnt(구간 갯수)를 증가시킨다.

    O(NlogN)
     */
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        System.out.println(bSearch(max));
    }

    public static int bSearch(int max) {
        int left = 0;
        int right = max;
        int res = 0; // 정답

        while (left <= right) {
            int mid = (left + right) / 2;

            if (divide(mid) <= m) { // 구간 갯수가 m개 이하(mid 값이 작아지면 구간 갯수가 늘어남)
                res = mid;
                right = mid - 1;
            } else { // m개 초과(mid 값이 커지면 구간 갯수가 줄어듬)
                left = mid + 1;
            }
        }

        return res;
    }

    public static int divide(int mid) {
        int cnt = 1;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > mid) {
                min = arr[i];
                max = arr[i];
                cnt++;
            }
        }

        return cnt;
    }
}