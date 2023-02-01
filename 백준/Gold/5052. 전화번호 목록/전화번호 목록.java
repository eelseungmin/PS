import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    O(T*NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] pnum = new String[n];

            for (int i = 0; i < n; i++) {
                pnum[i] = br.readLine();
            }

            Arrays.sort(pnum); // 문자열 사전순 정렬, 접두어가 같은 문자열끼리 앞뒤로 정렬된다.

            if (isValid(n, pnum)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isValid(int n, String[] pnum) {
        for (int i = 0; i < n - 1; i++) {
            if (pnum[i + 1].startsWith(pnum[i])) {
                return false;
            }
        }

        return true;
    }
}