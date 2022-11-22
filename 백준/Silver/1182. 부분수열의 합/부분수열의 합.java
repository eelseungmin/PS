import java.io.*;
import java.util.*;

public class Main {
    /*

     */
    static int[] arr = new int[20];
    static int[] tmp = new int[20];
    static int n, s, cnt;
    static boolean[] isUsed = new boolean[20];

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (s == 0) { // 크기가 양수인 부분수열 중에서 합이 S가 되는 경우이므로 공집합은 제외
            cnt--;
        }

        System.out.println(cnt);
    }

    public static void func(int num, int sum) { // num번째 수를 더할지 말지 결정하고 num+1번째 수를 정하러 들어가는 재귀함수
        if (num == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }

        func(num + 1, sum);
        func(num + 1, sum + arr[num]);
    }
}