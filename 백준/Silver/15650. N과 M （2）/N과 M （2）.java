import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 512MB
     */
    static int n, m;
    static int[] arr = new int[9];
    static boolean[] isUsed = new boolean[9];

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
    }

    public static void func(int num) {
        if (num == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            System.out.print(sb);

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                if (num != 0 && arr[num - 1] > i) {
                    continue;
                }

                arr[num] = i;
                isUsed[i] = true;
                func(num + 1);
                isUsed[i] = false;
            }
        }
    }
}
