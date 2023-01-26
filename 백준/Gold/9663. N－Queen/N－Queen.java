import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    어떤 행에 퀸을 놓은 뒤 해당 좌표에서 |, \, / 방향 확인
    해당 위치에 다른 퀸이 존재하면 가지치기

    \: 0,5 1,4 x-y
    /: 0,0 1,1 x+y
     */
    static int n;
    static boolean[] isUsed1, isUsed2, isUsed3;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isUsed1 = new boolean[2 * n]; // |
        isUsed2 = new boolean[2 * n]; // /
        isUsed3 = new boolean[2 * n]; // \

        func(0);

        System.out.println(cnt);
    }

    private static void func(int row) { // 해당 row에 배치
        if (row == n) {
            cnt++;

            return;
        }

        for (int col = 0; col < n; col++) { // row, col마다 배치
            if (isUsed1[col] || isUsed2[row + col] || isUsed3[row - col + n - 1]) {
                continue;
            }

            isUsed1[col] = true;
            isUsed2[row + col] = true;
            isUsed3[row - col + n - 1] = true;

            func(row + 1);

            isUsed1[col] = false;
            isUsed2[row + col] = false;
            isUsed3[row - col + n - 1] = false;
        }
    }
}