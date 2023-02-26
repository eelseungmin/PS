import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    투 포인터
    슬라이딩 윈도우 사용
    O(N)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0; // 정답
        int r = 1;
        int sum = 1;
        for (int l = 1; l <= n; l++) {
            while (r < n && sum < n) {
                r++;
                sum += r;
            }

            if (sum == n) {
                cnt++;
            }

            sum -= l;
        }

        System.out.println(cnt);
    }
}