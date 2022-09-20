import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int max = -1;
        int order = -1;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            if (max < n) {
                max = n;
                order = i + 1;
            }
        }

        System.out.print(max + "\n" + order);
    }
}