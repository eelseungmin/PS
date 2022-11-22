import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 512MB
     */
    static int n, m;
    static int[] arr = new int[8];
    static boolean[] isUsed = new boolean[8];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        bw.flush();
        bw.close();
    }

    public static void func(int num) throws Exception {
        if (num == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i <= n; i++) {
                arr[num] = i;
                func(num + 1);
        }
    }
}