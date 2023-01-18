import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n;
    static int[] arr;
    static int[] nums;
    static boolean[] vis;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nums = new int[n];
        vis = new boolean[n];
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSeq(0);

        System.out.println(max);
    }

    static void makeSeq(int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(nums[i] - nums[i + 1]);
            }
            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                nums[cnt] = arr[i];
                makeSeq(cnt + 1);
                vis[i] = false;
            }
        }
    }
}