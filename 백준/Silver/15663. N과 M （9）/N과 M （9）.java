import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 512MB
    들어오는 숫자가 중복되는데 수열은 중복되면 안되는 게 문제
    -> 이전 수열 마지막 항 == 새로운 수열 마지막 항 -> 중복 수열
     */
    static int n, m;
    static int[] arr;
    static int[] nums;
    static boolean[] isUsed;
    static BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        nums = new int[n];
        isUsed = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

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

        int tmp = 0;
        for (int i = 0; i < n; i++) {
//            if(i != 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            if (!isUsed[i] && tmp != nums[i]) {
                arr[num] = nums[i];
                tmp = arr[num];
                isUsed[i] = true;
                func(num + 1);
                isUsed[i] = false;
            }
        }
    }
}