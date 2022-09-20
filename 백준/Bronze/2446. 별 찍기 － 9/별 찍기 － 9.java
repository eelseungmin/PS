import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 윗부분(공백, 별) 97531
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int k = 2 * n - 2 * i - 1; k > 0; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        // 아랫부분(공백, 별) 3210  3579
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - i - 2; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * (i + 2) - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }


        System.out.print(sb.toString());
    }
}
