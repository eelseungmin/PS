import java.io.*;
import java.util.*;

public class Main {
    /*
    10초, 128MB

    */
    static int n, cnt;
    static int[][] map;
    static boolean[] isUsed1, isUsed2, isUsed3;

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isUsed1 = new boolean[30]; // 열에 퀸이 존재하는지 확인하는 배열
        isUsed2 = new boolean[30]; // \에 퀸이 존재하는지 확인하는 배열
        isUsed3 = new boolean[30]; // /에 퀸이 존재하는지 확인하는 배열

        func(0);

        System.out.println(cnt);
    }

    public static void func(int cur) { // cur번째 행에 퀸을 배치하는 함수
        if (cur == n) { // 배치가 완료되었으므로 cnt 증가
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed1[i] || isUsed2[cur+i] || isUsed3[cur-i+n-1]) { // 각 일직선상에 퀸이 존재할 경우, n-1을 더하는 이유는 인덱스가 음수가 되지 않게 하기 위해서
                continue;
            }

            isUsed1[i] = true;
            isUsed2[cur+i] = true;
            isUsed3[cur-i+n-1] = true;

            func(cur + 1);

            isUsed1[i] = false;
            isUsed2[cur+i] = false;
            isUsed3[cur-i+n-1] = false;
        }
    }
}