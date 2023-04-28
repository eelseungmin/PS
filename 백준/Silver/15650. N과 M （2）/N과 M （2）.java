import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n, m;
    static int[] seq;
    static StringBuilder sb;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        sb = new StringBuilder();
        isSelected = new boolean[n + 1];

        makeSeq(0, 1);

        System.out.println(sb);
    }

    static void makeSeq(int cnt, int start) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(seq[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= n; i++) {
            if (!isSelected[i]) {
                seq[cnt] = i;
                isSelected[i] = true;
                makeSeq(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }
}
