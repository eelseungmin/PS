import java.io.*;
import java.util.*;

/*
공백 4, 3, 2, 1...
별 1, 2, 3, 4...
전체 줄 갯수 5
 */

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
