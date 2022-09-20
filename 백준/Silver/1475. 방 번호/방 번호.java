import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            arr[ch - '0']++;
        }

        if ((arr[9] + arr[6]) % 2 == 0) {
            arr[6] = (arr[9] + arr[6]) / 2;
            arr[9] = 0;
        } else {
            arr[6] = (arr[9] + arr[6]) / 2 + 1;
            arr[9] = 0;
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
