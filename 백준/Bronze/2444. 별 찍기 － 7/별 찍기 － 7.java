import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 공백 4 3 2 1 0
        // 별 1 3 5 7 2n-1
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * (i + 1) - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        // 공백 1 2 3 4
        // 별 7 5 3 1
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append(" ");
            }
            for (int k = 2 * (n - i - 1) - 1; k > 0; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
