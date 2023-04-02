import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] state = new boolean[n + 1];
        Arrays.fill(state, true);
        state[1] = false;
        for (int i = 2; i <= n; i++) {
            if (!state[i]) {
                continue;
            }

            for (int j = 2 * i; j <= n; j += i) {
                state[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (state[i]) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }
}