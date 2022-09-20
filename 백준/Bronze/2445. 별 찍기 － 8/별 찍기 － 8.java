import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 윗부분
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            for (int k = 2 * (n - i - 1); k > 0; k--) {
                sb.append(" ");
            }
            for (int h = 0; h < i + 1; h++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        // 아랫부분
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1 - i; j > 0; j--) {
                sb.append("*");
            }
            for (int k = 0; k < 2 * (i + 1); k++) {
                sb.append(" ");
            }
            for (int h = n - 1 - i; h > 0; h--) {
                sb.append("*");
            }
            sb.append("\n");
        }


        System.out.print(sb.toString());
    }
}
