import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    최솟값 -> parametric search?
    m명이 n개의 입국 심사대에서 심사를 받는데 걸리는 최소 시간의 합?
    -> 각각 심사를 받는 시간의 총 합이 x일 때 m명이 심사를 받을 수 있는가?

    심사 시간의 최대합을 기준으로 이분탐색 진행
    m보다 크거나 같으면 초과된 인원만큼 쉬게 하고 right = mid - 1
    작으면 해당 시간 안에 m명 심사가 불가능하므로 left = mid + 1

    O(N*log(N * max(Tk))
     */
    static int n, m;
    static int[] time;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = new int[n];

        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, time[i]);
        }

        System.out.println(bSearch());
    }

    public static long bSearch() {
        long left = 1;
        long right = (long) m * max;
        long res = 0; // 총 시간의 최솟값

        while (left <= right) {
            long mid = (left + right) / 2;

            if (sumPeople(mid) >= m) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static long sumPeople(long mid) { // sum(총 시간 / 심사대 시간) = 해당 총 시간에서의 모든 심사대의 심사 가능 인원수
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mid / time[i];
        }

        return sum;
    }
}