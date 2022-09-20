import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int[] arr = new int[256];

        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)]++;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
