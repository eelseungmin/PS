import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 128MB
     */
    static int k;
    static int[] arr;
    static int[] set;
    static boolean[] isUsed = new boolean[50];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            set = new int[k];
            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }

            func(0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void func(int num) throws Exception {
        if (num == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 0; i < k; i++) {
            if (!isUsed[set[i]]) {
                if (num != 0 && arr[num - 1] > set[i]) {
                    continue;
                }
                arr[num] = set[i];
                isUsed[set[i]] = true;
                func(num + 1);
                isUsed[set[i]] = false;
            }
        }
    }
}