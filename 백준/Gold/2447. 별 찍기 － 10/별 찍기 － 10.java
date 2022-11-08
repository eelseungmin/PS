import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 256MB
    n = 3^k, k는 1~8

    별 찍기 1~9와 다르게 배열을 만들어서 거기에 별을 넣는 아이디어가 중요
    */
    static StringBuilder sb = new StringBuilder();
    static char[][] board;

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ' ');
        }

        func(n, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void func(int n, int r, int c) {
        if (n == 1) {
            board[r][c] = '*';
            return;
        }

        int tmp = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                func(tmp, r + i * tmp, c + j * tmp);
            }
        }
    }
}