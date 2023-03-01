import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    먼저 정렬한다.
    양쪽 끝에 투 포인터를 설정한다.
    다 양수일 경우
    다 음수일 경우
    음수 양수일 경우
    O(NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int sum; // 합
        int min = Integer.MAX_VALUE; // 합의 최솟값(절댓값)
        int[] ans = new int[2];
        while (l < r) {
            sum = arr[l] + arr[r];
            if (sum == 0) {
                ans[0] = arr[l];
                ans[1] = arr[r];
                break;
            }
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ans[0] = arr[l];
                ans[1] = arr[r];
            }

            if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1]);
    }
}