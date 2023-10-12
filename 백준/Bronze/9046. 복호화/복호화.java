import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            String s = sc.nextLine();
            int max = Integer.MIN_VALUE;
            char maxValue = 0;
            int cnt = 0;

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if ('a' <= ch && ch <= 'z')
                    arr[ch - 'a']++;
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            for (int j = 0; j < arr.length; j++) {
                if (max == arr[j]) {
                    cnt++;
                    maxValue = (char) (j + 'a');
                }
            }

            System.out.println(cnt == 1 ? maxValue : "?");
        }
    }
}