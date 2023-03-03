import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] vis = new int[100001]; // 방문 체크 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = -1;
        int ans = 0; // 정답
        for (int l = 0; l < n; l++) {
            // 다음에 r이 이동할 위치의 숫자가 k개 미만으로 등장했는지 확인하고 r을 옮긴다.
            while (r + 1 < n && vis[arr[r + 1]] < k) {
                r++;
                vis[arr[r]]++;
            }

            ans = Math.max(ans, r - l + 1);

            vis[arr[l]]--;
        }

        System.out.println(ans);
    }
}