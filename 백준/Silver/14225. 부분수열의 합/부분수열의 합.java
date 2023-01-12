import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n;
    static int[] nums = new int[20];
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static void func(int cnt, int sum) {
        if (cnt == n) {
            if (sum != 0) {
                set.add(sum);
            }
            return;
        }

        func(cnt + 1, sum + nums[cnt]);
        func(cnt + 1, sum);
    }
}