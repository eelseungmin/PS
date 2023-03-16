import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    1 3 6 6 7 9

    2 3 0 1 2
    0 1 2 2 3
    집중국 갯수 >= 센서 갯수
    -> 각 센서 당 1개씩 담당, 영역 최소 길이 0
    집중국 갯수 < 센서 갯수
    -> 집중국의 갯수가 더 적으면 특정 집중국이 여러 개의 센서를 담당해야 한다.

     *    *
    . . . . .
    1 3 6 7 9
        6

    k가 2일 때 센서와 센서 사이를 1회 뛰어넘을 수 있다.
    k가 3이라면 2회 뛰어넘을 수 있다.
    영역을 최소로 줄여야 하므로 긴 간격부터 제외한다.
    따라서 센서 간 간격을 배열에 저장해서 정렬한 뒤 작은 간격부터 n - k개의 간격을 더한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] censor = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            censor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(censor);

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = censor[i + 1] - censor[i];
        }

        Arrays.sort(diff);

        int ans = 0; // 정답
        for (int i = 0; i < n - k; i++) {
            ans += diff[i];
        }

        System.out.println(ans);
    }
}