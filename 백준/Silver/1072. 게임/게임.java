import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(logX)
     */
    static long winRate; // 주어진 입력에서의 승률
    static int res; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        winRate = (long) y * 100 / x;
        res = -1;

        bSearch(x, y);

        System.out.println(res);
    }

    public static void bSearch(int x, int y) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isDiffer(x + mid, y + mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static boolean isDiffer(int x, int y) { // mid번 만큼 게임을 더 했을 때의 승률이 주어진 입력에서의 승률과 다른지 return
        long newWinRate = (long) y * 100 / x;

        if (winRate != newWinRate) {
            return true;
        }

        return false;
    }
}