import java.io.*;
import java.util.*;

public class Main {
    /*
    2, 256
    1 ≤ N ≤ 37, N은 3k 꼴

    다른 숫자가 1개라도 발견되면 쪼개기
    1 2 3
    4 5 6
    7 8 9
    */
    static int[][] paper;
    static int num1, num2, num3; // -1, 0, 1

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, 0, 0);
        System.out.print(num1 + "\n" + num2 + "\n" + num3 + "\n");
    }

    public static boolean check(int n, int r, int c) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[i][j] != paper[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void func(int n, int r, int c) {
        if (check(n, r, c)) { // base case: 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
            switch (paper[r][c]) {
                case -1:
                    num1++;
                    break;
                case 0:
                    num2++;
                    break;
                case 1:
                    num3++;
                    break;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(n / 3, r + i * (n / 3), c + j * (n / 3));
            }
        }
    }
}