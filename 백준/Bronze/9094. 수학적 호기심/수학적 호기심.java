import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 2; j < n; j++) {
                    if (i < j) {
                        if ((Math.pow(i, 2) + Math.pow(j, 2) + m) % (i * j) == 0) {
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}