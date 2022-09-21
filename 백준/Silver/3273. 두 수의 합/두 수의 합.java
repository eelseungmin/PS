import java.io.*;
import java.util.*;

public class Main {
    /*
    brute force
    O(N^2)

    optimal
    O(N)
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] occur = new int[2000001];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (x - num[i] > 0 && occur[x - num[i]] == 1) {
                cnt++;
            }

            occur[num[i]]++;
        }

        System.out.println(cnt);
    }
}