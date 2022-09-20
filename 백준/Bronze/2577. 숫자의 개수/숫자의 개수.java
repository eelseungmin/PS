import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int abc = 1;

        for (int i = 0; i < 3; i++) {
            abc *= Integer.parseInt(br.readLine());
        }

        int[] arr = new int[10];
        String str = String.valueOf(abc);

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
