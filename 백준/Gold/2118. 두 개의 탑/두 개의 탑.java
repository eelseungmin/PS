import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    투 포인터
    O(N)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n];

        int sum = 0; // 주어진 지점들 사이의 거리의 총합
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            point[i] = tmp;
            sum += tmp;
        }

        /**
         * 한 지점을 고정한 채로 다른 지점을 살펴본다.
         * 시계방향이 반시계방향보다 더 커지는 시점부터는 최댓값이 변하지 않는다.(같을 때가 최댓값)
         * 변하지 않으므로 그 부분부터는 더 살펴볼 필요가 없다.
         */
        int l = 0;
        int r = 1;
        int clock = point[0]; // 시계방향
        int ans = Integer.MIN_VALUE; // 정답
        while (l < n) {
            ans = Math.max(ans, Math.min(clock, sum - clock));

            if (clock < sum - clock) {
                clock += point[r];
                r++;
                r %= n; // 이렇게 하면 r = 0, 1, 2, ..., n-1, n, 0, ...
            } else {
                clock -= point[l];
                l++;
            }
        }

        System.out.println(ans);
    }
}