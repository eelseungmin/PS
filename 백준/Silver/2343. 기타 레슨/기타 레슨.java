import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    m개의 블루레이에 n개의 강의를 모두 담기 위한 최소 크기?
    -> 크기가 x인 블루레이 m개에 n개의 강의를 모두 담을 수 있는가?

    mid: x

    O(Nlog(10000*N))
     */
    static int n, m;
    static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        length = new int[n];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, length[i]);
        }

        System.out.println(bSearch(maxLength));
    }

    public static int bSearch(int maxLength) {
        int left = maxLength; // 주어진 입력에서의 최댓값
        int right = 10000 * n;
        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (calcCnt(mid) <= m) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static int calcCnt(int mid) { // 블루레이 크기가 mid일 때 필요한 블루레이 갯수 return
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (sum + length[i] > mid) { // 블루레이 크기보다 강의 길이의 합이 커지면 블루레이 추가
                sum = 0;
                cnt++;
            }

            sum += length[i];
        }

        if (sum != 0) { // 남은 강의 길이의 합이 0이 아니면 블루레이에 담아줘야 하므로 블루레이 추가
            cnt++;
        }

        return cnt;
    }
}