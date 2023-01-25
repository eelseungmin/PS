import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n, s;
    static int[] seq;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        makeSum(0, 0);
        if (s == 0) {
            ans--;
        }

        System.out.println(ans);
    }

    static void makeSum(int cnt, int sum) {
        if (cnt == n) {
            if (sum == s) {
                ans++;
            }
            return;
        }

        makeSum(cnt + 1, sum);
        makeSum(cnt + 1, sum + seq[cnt]);
    }
}