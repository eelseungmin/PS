import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 512MB

    백트래킹
    */
    static int n, m;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];
        isUsed = new boolean[n + 1];

        func(0);
    }

    public static void func(int num) { // 현재까지 고른 숫자의 갯수 num
        if (num == m) {
            sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            System.out.print(sb);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[num] = i;
                isUsed[i] = true;
                func(num + 1);
                isUsed[i] = false;
            }
        }
    }
}
